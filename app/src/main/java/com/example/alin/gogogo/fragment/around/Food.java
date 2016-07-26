package com.example.alin.gogogo.fragment.around;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.LittleFoodAdapter;
import com.example.alin.gogogo.bean.LittleFood;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Food extends Fragment {
    private PullToRefreshListView refreshListView;
    private  int PageNo=1;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, container, false);
        refreshListView= (PullToRefreshListView) view.findViewById(R.id.pull_food);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        cureenList=new ArrayList<>();
        littleFoodAdapter=new LittleFoodAdapter(cureenList,getActivity());
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

        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



            }
        });

        return view;


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


}
