package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.HomeActivity;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.ThreeAdapter;
import com.example.alin.gogogo.bean.Three2;
import com.example.alin.gogogo.fragment.HomeFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ThreeDActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,View.OnClickListener{
    private ListView listview;
    private List<String> list;
    private Three2  three2;
    private static  int pageNo=1;
    private ThreeAdapter threeAdapter;
   private  SwipeRefreshLayout refresh;
    List<Three2.DBean.RowsBean> rowsBeen;
    List<Three2.DBean.RowsBean> currentList;
    private ImageView iv;
   private Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case 0:
                   refresh.setRefreshing(false);
                   break;
           }
       }
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_d);
        listview=(ListView) findViewById(R.id.lv_3d);
        refresh=(SwipeRefreshLayout) findViewById(R.id.swipe_3d);
       currentList=new ArrayList<>();
        iv=(ImageView) findViewById(R.id.three_back);
        iv.setOnClickListener(this);
        threeAdapter=new ThreeAdapter(this,currentList);
        listview.setAdapter(threeAdapter);

        initData();

    }
    private void initData() {
        RequestParams params=new RequestParams(Cans.three);
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
               Three2 three2=new Gson().fromJson(result,Three2.class);
                rowsBeen=three2.getD().getRows();
                currentList.addAll(rowsBeen);
                threeAdapter.notifyDataSetChanged();
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

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
        
    }
    @Override
    public void onRefresh() {
        Toast.makeText(ThreeDActivity.this,"下拉刷新",Toast.LENGTH_SHORT).show();
        currentList.clear();
        pageNo=1;
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.three_back:
                finish();
                break;
        }
    }
}
