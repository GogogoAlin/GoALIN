package com.example.alin.gogogo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.alin.gogogo.R;

public class EntertainmentActivity extends AppCompatActivity {

    private ImageView homecatory_back_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);
        homecatory_back_food= (ImageView) findViewById(R.id.homecatory_back_food);
        homecatory_back_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
