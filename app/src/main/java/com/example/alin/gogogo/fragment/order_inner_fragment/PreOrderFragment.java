package com.example.alin.gogogo.fragment.order_inner_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.PreOrderAdapter;
import com.example.alin.gogogo.bean.DBPreOrder;
import com.example.alin.gogogo.utils.DBLocationDBUtils;
import com.example.alin.gogogo.utils.PreOrderDBUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by Alin on 2016/7/18.
 */
public class PreOrderFragment extends Fragment {
    private PullToRefreshListView pullToRefreshListView;
    private List<DBPreOrder> listorder;
    private PreOrderAdapter preOrderAdapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 3:
                    listorder.clear();
                   listorder.addAll(PreOrderDBUtils.getInstance().qureyDBPreGift());
                   preOrderAdapter.notifyDataSetChanged();
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pre_order_fragment_layout,null);
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.pull_listView_order);
        loadData();
        return view;
    }

    private void loadData() {
        listorder= PreOrderDBUtils.getInstance().qureyDBPreGift();
        if (listorder!=null){
            preOrderAdapter=new PreOrderAdapter(listorder,getActivity());
            pullToRefreshListView.setAdapter(preOrderAdapter);
            pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    handler.sendEmptyMessage(3);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //预约订单
        if (listorder!=null){
            listorder.clear();
            listorder.addAll(PreOrderDBUtils.getInstance().qureyDBPreGift());
            preOrderAdapter.notifyDataSetChanged();
        }
    }
}
