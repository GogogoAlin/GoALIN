package com.example.alin.gogogo.fragment.collection_inner_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.activity.SenceDetailActivity;
import com.example.alin.gogogo.adapter.ScenicCollectionAdapter;
import com.example.alin.gogogo.bean.DBScinceBean;
import com.example.alin.gogogo.bean.SenceDetail;
import com.example.alin.gogogo.myinterface.OnCollectionListener;
import com.example.alin.gogogo.utils.ScenicDBUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alin on 2016/7/18.
 */
public class SenceFragment extends Fragment {
    private PullToRefreshListView pullToRefreshListView;
    private List<DBScinceBean> list = new ArrayList<>();
    private ScenicCollectionAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                adapter.notifyDataSetChanged();
                pullToRefreshListView.onRefreshComplete();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sence_fragment_layout, null);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_listView_sence);
        loadData();
        return view;
    }

    private void loadData() {
        list = ScenicDBUtil.getInstance().qureyDBScinceBean();
        if (list != null) {
            adapter = new ScenicCollectionAdapter(getActivity(), list);
            pullToRefreshListView.setAdapter(adapter);
            pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
                @Override
                public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                    list.clear();
                    list.addAll(ScenicDBUtil.getInstance().qureyDBScinceBean());
                    handler.sendEmptyMessage(1);
                }
            });
            pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), SenceDetailActivity.class);
                    intent.putExtra("shopId", list.get(i - 1).getShopId());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (list != null) {
            list.clear();
            list.addAll(ScenicDBUtil.getInstance().qureyDBScinceBean());
            adapter.notifyDataSetChanged();

        }
    }
}
