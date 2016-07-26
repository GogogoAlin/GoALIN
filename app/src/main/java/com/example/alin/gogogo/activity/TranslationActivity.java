package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.SenceDetail;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_translation)
public class TranslationActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_tracfic_self_driving)
    private TextView tv_tracfic_self_driving;
    @ViewInject(R.id.tv_bus_route)
    private TextView tv_bus_route;
    @ViewInject(R.id.tv_subway_route)
    private TextView tv_subway_route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        loadData();
    }

    private void loadData() {
        Intent intent = getIntent();
//        tv_tracfic_self_driving.setText(intent.getStringExtra("self"));
//        tv_bus_route.setText(intent.getStringExtra("bus"));
//        tv_subway_route.setText(intent.getStringExtra("subway"));
        Bundle bundle = intent.getBundleExtra("bundle");
        SenceDetail.DBean dbean= (SenceDetail.DBean) bundle.getSerializable("DBean");
        tv_tracfic_self_driving.setText(dbean.getSelfdrivingRoadmap());
        tv_bus_route.setText(dbean.getTransitRoadmap());
        tv_subway_route.setText(dbean.getUndergroundRoadmap());
//        String aaa = intent.getStringExtra("aaa");
//        tv_subway_route.setText(aaa);

    }
}
