package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.CityTicketPullAdapter;
import com.example.alin.gogogo.bean.CityScencicSpot;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ScenicspotTicket extends AppCompatActivity {
    private PullToRefreshListView refreshListView;
    private  int PageNo=1;
    private List<CityScencicSpot.DBean.RowsBean>rowsBeenList;
    private List<CityScencicSpot.DBean.RowsBean>cureenList;
    private CityTicketPullAdapter adapter;
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
        setContentView(R.layout.activity_scenicspot_ticket);

        refreshListView=(PullToRefreshListView)findViewById(R.id.pull_listView_city);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        cureenList=new ArrayList<>();
        adapter=new CityTicketPullAdapter(cureenList,ScenicspotTicket.this);
        refreshListView.setAdapter(adapter);
        initdata();
        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String  shopID=cureenList.get(i).getShopId();
                Intent intent =new Intent(ScenicspotTicket.this,SenceDetailActivity.class);
                intent.putExtra("shopId",shopID);
                startActivity(intent);

            }
        });
        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                cureenList.clear();
                PageNo=1;
                initdata();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(1000);
                            handler.sendEmptyMessage(0);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();



            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                PageNo++;
                initdata();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(1000);
                            handler.sendEmptyMessage(1);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();




            }
        });



    }

    private void initdata() {
        RequestParams params=new RequestParams(Cans.city_ticket+PageNo+Cans.city_ticketlast);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                CityScencicSpot cityScencicSpot = new Gson().fromJson(result, CityScencicSpot.class);
                rowsBeenList = cityScencicSpot.getD().getRows();
                cureenList.addAll(rowsBeenList);
                adapter.notifyDataSetChanged();
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

    public void Clickbt(View view){
        switch (view.getId()){
            case R.id.homecatory_back :
                finish();
                break;
            case R.id.search:

                break;
            case R.id.refresh:

                break;



        }



    }

}
