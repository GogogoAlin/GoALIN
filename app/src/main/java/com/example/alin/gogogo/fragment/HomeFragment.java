package com.example.alin.gogogo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.RefrenceLayout;
import com.example.alin.gogogo.activity.ChooseActivity;
import com.example.alin.gogogo.activity.MoreServerActivity;
import com.example.alin.gogogo.activity.ScenicspotTicket;
import com.example.alin.gogogo.activity.SearchActivity;
import com.example.alin.gogogo.activity.SenceDetailActivity;
import com.example.alin.gogogo.activity.SenceGuideActivity;
import com.example.alin.gogogo.activity.ThreeDActivity;
import com.example.alin.gogogo.adapter.Nanjinadapter;
import com.example.alin.gogogo.bean.homenanjin;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RefrenceLayout.onLoadingListener {

    private ListView listView;
    private RefrenceLayout refrenceLayout;
    private List<String> list;
    private View view1;
    private View listview_mb;
    private homenanjin nanjin;
    private Nanjinadapter adapter;
    private ImageView iv;
    private ImageView ticket_bt;
    private ImageView guide_bt, voice_btn;
    private ImageView moreserver_bt;
    private SlindingOnClickCallback callback;
    private TextView tv_citys_header;


    private static int pageNo = 1;
    List<com.example.alin.gogogo.bean.homenanjin.DBean.RowsBean> rowsBeen;
    List<com.example.alin.gogogo.bean.homenanjin.DBean.RowsBean> cuttentlist;
    private Button buttonsearch;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    refrenceLayout.setRefreshing(false);
                    break;

                case 1:
                    adapter.notifyDataSetChanged();
                    refrenceLayout.setLoadingState(false);
                    break;
            }
        }

    };

    public void setCallback(SlindingOnClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view1 = inflater.inflate(R.layout.refreshheaderview, null);
        tv_citys_header = (TextView) view1.findViewById(R.id.tv_citys_header);
        voice_btn = (ImageView) view1.findViewById(R.id.voice);
        buttonsearch=(Button)view.findViewById(R.id.search);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        listview_mb = inflater.inflate(R.layout.home_nanjin_listviewmb, null);
        refrenceLayout = (RefrenceLayout) view.findViewById(R.id.Refrencelayout);
        listView = (ListView) view.findViewById(R.id.listview);

        iv = (ImageView) view.findViewById(R.id.homecatory);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.togOnClick();
            }
        });

        refrenceLayout.setOnRefreshListener(this);
        refrenceLayout.setonLoadingListener(this);
        listView.addHeaderView(view1);
        cuttentlist = new ArrayList<>();
        adapter = new Nanjinadapter(cuttentlist, getActivity());
        initdata();
        listView.setAdapter(adapter);


        jump();
        initview();




        return view;

    }

    private void jump() {
        //alin添加城市跳转的监听事件
        tv_citys_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChooseActivity.class);
                startActivity(intent);
            }
        });

        //alin添加语音导航的跳转
        voice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SenceGuideActivity.class);
                startActivity(intent);
            }
        });
        //alin添加listview的点击跳转监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), SenceDetailActivity.class);
                homenanjin.DBean.RowsBean bean = cuttentlist.get(i - 1);
                String shopId = bean.getShopId();
                intent.putExtra("shopId",shopId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //再次添加监听事件
        final Intent intent = new Intent();
        ticket_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.setClass(getActivity(), ScenicspotTicket.class);
                startActivity(intent);

            }
        });
        guide_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), ThreeDActivity.class);
                startActivity(intent1);
            }
        });
        moreserver_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), MoreServerActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void initview() {
        ticket_bt = (ImageView) view1.findViewById(R.id.ticket);
        guide_bt = (ImageView) view1.findViewById(R.id.guild_3d);
        moreserver_bt = (ImageView) view1.findViewById(R.id.more_service);
    }


    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
        cuttentlist.clear();
        pageNo = 1;
        initdata();
        new Thread() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }
                handler.sendEmptyMessage(0);
            }

        }.start();

    }


    @Override
    public void onLoad() {
        pageNo++;
        initdata();
        new Thread() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);
            }

        }.start();


    }

    public void initdata() {
        RequestParams params = new RequestParams(Cans.home_nanjin + pageNo + Cans.home_nanjin_last);

        x.http().get(params, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                nanjin = new Gson().fromJson(result, homenanjin.class);
                rowsBeen = nanjin.getD().getRows();
                cuttentlist.addAll(rowsBeen);
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

            @Override
            public boolean onCache(String result) {

                return false;
            }
        });


    }


}
