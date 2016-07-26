package com.example.alin.gogogo.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.CitysAdapter;
import com.example.alin.gogogo.bean.Citys;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ChooseActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Citys.DBean.RowsBean> rowsBeanList = new ArrayList<>();
    private CitysAdapter adapter;
    private ImageView iv;
    private int areaId = 13;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                adapter = new CitysAdapter(ChooseActivity.this, rowsBeanList);
                gridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        gridView = (GridView) findViewById(R.id.gv_citys);
        iv = (ImageView) findViewById(R.id.homecatory_back_choose);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        loadData();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_already_choose:
                areaId = 13;
//                areaId="";

                break;
            case R.id.btn_bejing_choose:
                areaId = 11;
                break;
            case R.id.btn_changchun_choose:
                areaId = 22;
                break;
            case R.id.btn_hebei_choose:
                areaId = 13;
                break;
            case R.id.btn_jiangsu_choose:
                areaId = 32;
                break;
            case R.id.btn_liaoning_choose:
                areaId = 21;
                break;
            case R.id.btn_shanghai_choose:
                areaId = 31;
                break;
            case R.id.btn_shanxi_choose:
                areaId = 14;
                break;
            case R.id.btn_tianjin_choose:
                areaId = 12;
                break;
            case R.id.btn_zhejiang_choose:
                areaId = 33;
                break;
        }
        rowsBeanList.clear();
        loadData();
    }

    private void loadData() {
        RequestParams requestParams = new RequestParams(String.format(Cans.CITYS, areaId));
//        RequestParams requestParams = new RequestParams(Cans.CITYS);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rowsBeanList = new Gson().fromJson(result, Citys.class).getD().getRows();
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
