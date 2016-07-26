package com.example.alin.gogogo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.alin.gogogo.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class StoreDetailActivity extends AppCompatActivity {
    @ViewInject(R.id.store_blessing_back)
private ImageView iv_store_blessing_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        x.view().inject(this);
        iv_store_blessing_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}




