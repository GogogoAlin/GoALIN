package com.example.alin.gogogo.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.LittleFoodAdapter;
import com.example.alin.gogogo.bean.CityScencicSpot;
import com.example.alin.gogogo.bean.LittleFood;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class LittleActivity extends AppCompatActivity {
    private PullToRefreshListView refreshListView;
    private  int PageNo=1;
    private ImageView homecatory_back_food;

    private List<LittleFood.DBean.RowsBean> rowsBeenList;

    private List<LittleFood.DBean.RowsBean>cureenList;

    private LittleFoodAdapter littleFoodAdapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                   refreshListView.onRefreshComplete();
                    break;
                case 1:
                    refreshListView.onRefreshComplete();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little);
        refreshListView=(PullToRefreshListView) findViewById(R.id.pull_listView_food);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        cureenList=new ArrayList<>();
        homecatory_back_food = (ImageView) findViewById(R.id.homecatory_back_food);
        homecatory_back_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        littleFoodAdapter=new LittleFoodAdapter(cureenList,LittleActivity.this);
        refreshListView.setAdapter(littleFoodAdapter);
        initData();
        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                cureenList.clear();
                PageNo=1;
                initData();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0);
                    }
                }.start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                PageNo++;
                initData();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(1);
                    }
                }.start();
            }
        });

    }

    private void initData() {
        RequestParams params=new RequestParams(Cans.littlefood);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
              LittleFood littleFood=new Gson().fromJson(result,LittleFood.class);
                rowsBeenList=littleFood.getD().getRows();
                cureenList.addAll(rowsBeenList);
                littleFoodAdapter.notifyDataSetChanged();

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
    public void  onClick(View view){
        switch (view.getId()){
            case R.id.homecatory_back_food:
                finish();
                break;
        }
    }
}
