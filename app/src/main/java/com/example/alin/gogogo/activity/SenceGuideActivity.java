package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.SenceGuideAdapter;
import com.example.alin.gogogo.bean.VoiceGuide;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_sence_guide)
public class SenceGuideActivity extends AppCompatActivity {

    @ViewInject(R.id.lv_sence_guide)
    private ListView lv;
    private SenceGuideAdapter adapter;
    @ViewInject(R.id.iv_sence_guide_back)
    private ImageView iv_sence_guide_back;
    private List<VoiceGuide.DBean.RowsBean> rowsBeanList=new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                adapter = new SenceGuideAdapter(rowsBeanList, SenceGuideActivity.this);
                lv.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initData();
        listener();

    }

    private void listener() {
        //返回键的设置
        iv_sence_guide_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //listview的点击跳转监听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VoiceGuide.DBean.RowsBean rowsBean = rowsBeanList.get(i);
                String shopId = rowsBean.getShopId();
                Intent intent = new Intent(SenceGuideActivity.this,SenceDetailActivity.class);
                intent.putExtra("shopId",shopId);
                startActivity(intent);
            }
        });

    }

    public void onClick(View view){
        Toast.makeText(this,"sss",Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        RequestParams requestParams = new RequestParams(Cans.VOICE_GUIDE);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                VoiceGuide voiceGuide = new Gson().fromJson(result, VoiceGuide.class);
                rowsBeanList = voiceGuide.getD().getRows();
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
