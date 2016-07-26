package com.example.alin.gogogo.fragment.around;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.HotelAdapter;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends Fragment {

    private PullToRefreshListView pullToRefreshListView;
    private List<com.example.alin.gogogo.bean.Hotel.DBean.RowsBean> rows = new ArrayList<>();
    private HotelAdapter adapter;
    private ImageView homecatory_back;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                adapter = new HotelAdapter(rows, getActivity());
                pullToRefreshListView.setAdapter(adapter);

            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_hotel);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        loadData();



        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



            }
        });
        return view;

    }

    private void loadData() {
        RequestParams requestParams = new RequestParams(Cans.HOTEL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                com.example.alin.gogogo.bean.Hotel hotel = new Gson().fromJson(result, com.example.alin.gogogo.bean.Hotel.class);
                rows = hotel.getD().getRows();
                Log.d("tagtag", "onSuccess: "+rows.size());
                handler.sendEmptyMessage(100);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
