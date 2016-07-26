package com.example.alin.gogogo.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.HotelAdapter;
import com.example.alin.gogogo.bean.Hotel;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {

    private PullToRefreshListView pullToRefreshListView;
    private List<Hotel.DBean.RowsBean> rows = new ArrayList<>();
    private HotelAdapter adapter;
    private ImageView homecatory_back;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                adapter = new HotelAdapter(rows, HotelActivity.this);
                pullToRefreshListView.setAdapter(adapter);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_listView_hotel_activity);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        homecatory_back= (ImageView) findViewById(R.id.homecatory_back);
        homecatory_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        loadData();
    }

    private void loadData() {
        RequestParams requestParams = new RequestParams(Cans.HOTEL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Hotel hotel = new Gson().fromJson(result, Hotel.class);
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
