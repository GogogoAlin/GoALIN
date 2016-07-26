package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.alin.gogogo.HomeActivity;
import com.example.alin.gogogo.R;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MoreServerActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView more_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_server_layout);
        more_iv= (ImageView) findViewById(R.id.iv_more);
        more_iv.setOnClickListener(this);
        initView();
        more_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
    }

    private void initView() {

    }

    
    //点击返回
    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.jingdian:
                intent = new Intent(this,ScenicspotTicket.class);
                break;
            case R.id.guide:
                intent = new Intent(this,SenceGuideActivity.class);
                break;
            case R.id.daolan:
                intent = new Intent(this,ThreeDActivity.class);
                break;
            case R.id.hotel:
                intent = new Intent(this,HotelActivity.class);
                break;
            case R.id.littlefood:
                intent = new Intent(this,LittleActivity.class);
                break;
            case R.id.gift:
                intent = new Intent(this,NativegiftActivity.class);
                startActivity(intent);
                break;
            case R.id.infor:
                intent = new Intent(this,AroundInfoActivity.class);
                break;
            case R.id.entertainment:
                intent = new Intent(this,EntertainmentActivity.class);
                break;
            case R.id.route:
                intent = new Intent(this,RouteDetailActivity.class);
                break;
            case R.id.camera:
                intent = new Intent(this,HomeActivity.class);
                intent.putExtra("id",3);
                break;
            case R.id.collect:
                intent = new Intent(this,CollectionActivity.class);
//                intent.putExtra("id",0);
                break;

        }
        startActivity(intent);
    }
}
