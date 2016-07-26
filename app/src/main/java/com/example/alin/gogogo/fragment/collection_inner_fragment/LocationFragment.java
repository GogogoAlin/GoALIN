package com.example.alin.gogogo.fragment.collection_inner_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.activity.GiftDetailActivity;
import com.example.alin.gogogo.adapter.CollectionLocationAdapter;
import com.example.alin.gogogo.adapter.PreOrderAdapter;
import com.example.alin.gogogo.bean.DBGift;
import com.example.alin.gogogo.bean.DBPreOrder;
import com.example.alin.gogogo.utils.DBLocationDBUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by Alin on 2016/7/18.t
 */
public class LocationFragment extends Fragment {
    private PullToRefreshListView pullToRefreshListView;
    private List<DBGift> list;
    private CollectionLocationAdapter adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 2:
                    list.clear();
                    list.addAll(DBLocationDBUtils.getInstance().qureyDBGift());
                    adapter.notifyDataSetChanged();
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_fragment_layout, null);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_listView_location);
        loadData();

        return view;
    }

    private void loadData() {
        list = DBLocationDBUtils.getInstance().qureyDBGift();
        if (list!=null){
            adapter = new CollectionLocationAdapter(list, getActivity());
            pullToRefreshListView.setAdapter(adapter);
            pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    handler.sendEmptyMessage(2);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                }
            });
            pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), GiftDetailActivity.class);
                    intent.putExtra("shopId",list.get(i-1).getGoodsId());
                    startActivity(intent);
                }
            });
        }



    }

    @Override
    public void onResume() {
        super.onResume();
        if (list!=null){
            list.clear();
            list.addAll(DBLocationDBUtils.getInstance().qureyDBGift());
            adapter.notifyDataSetChanged();
        }

    }
}
