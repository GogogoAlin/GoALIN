package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.fragment.around.Food;
import com.example.alin.gogogo.fragment.around.Hotel;
import com.example.alin.gogogo.fragment.around.Location;
import com.example.alin.gogogo.fragment.around.Relax;

import java.util.ArrayList;
import java.util.List;

public class AroundInfo extends AppCompatActivity {

    private RadioGroup group;
    private RadioButton[] buttons;
    private FragmentManager manager;
    private List<Fragment> list;
    private ImageView iv;
    private int current = 0;
    private String longitude,latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around_info2);
        group = (RadioGroup) findViewById(R.id.rg_collection_ac);
        buttons = new RadioButton[group.getChildCount()];
        iv= (ImageView) findViewById(R.id.iv_collection_sliding_activity);
        Intent intent = getIntent();
        longitude=intent.getStringExtra("longitude");
        latitude=intent.getStringExtra("latitude");

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        list = new ArrayList<>();
        initView();
        initFragment();
    }
    private void initFragment() {
        Hotel hotelFragment=new Hotel();
        Food foodFragment=new Food();
        Relax relaxaFragment=new Relax();
        Location locationFragment=new Location();

        list.add(hotelFragment);
        list.add(foodFragment);
        list.add(relaxaFragment);
        list.add(locationFragment);

        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.collecction_second_fragment_rl_ac, list.get(0));
        ft.commit();
    }

    private void initView() {
        for (int i = 0; i < group.getChildCount(); i++) {
            buttons[i] = (RadioButton) group.getChildAt(i);
        }

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int j = 0; j < group.getChildCount(); j++) {
                    if (buttons[j].getId() == i) {
                        replaceFragment(j);
                    }
                }
            }

            private void replaceFragment(int i) {
                FragmentTransaction ft = manager.beginTransaction();

                Fragment targetFragment = list.get(i);
                Fragment currentFragment = list.get(current);

                if (targetFragment.isAdded()) {
                    ft.show(targetFragment);
                    ft.hide(currentFragment);
                    ft.commit();
                } else {
                    ft.add(R.id.collecction_second_fragment_rl_ac, list.get(i));
                    ft.hide(currentFragment);
                    ft.commit();
                }
                current = i;
            }
        });
    }
}
