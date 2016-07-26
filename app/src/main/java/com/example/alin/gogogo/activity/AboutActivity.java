package com.example.alin.gogogo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
public class AboutActivity extends AppCompatActivity {
   private ScrollView scrollView;

    private TextView show_tv;

    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        scrollView=(ScrollView) findViewById(R.id.scrollView_about);
        show_tv=(TextView) findViewById(R.id.tv_about);
        iv_back=(ImageView) findViewById(R.id.input_about_left);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
