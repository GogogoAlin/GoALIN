package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.fragment.picsfragment.DefaultPicsFragmentInActivity;
import com.example.alin.gogogo.fragment.picsfragment.NetFriendUpdateFragmentInActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_picture_show)
public class PictureShowActivity extends AppCompatActivity {

    @ViewInject(R.id.rg_picture_show)
    private RadioGroup group;
    private RadioButton[] buttons;
    private List<Fragment> list;
    private int current =0;
    private FragmentManager manager;
    private String shopId;
    @ViewInject(R.id.iv_back_picture_show)
    private ImageView iv_back_picture_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        Intent intent = getIntent();
        shopId = intent.getStringExtra("shopId");
        initView();
        initFragment();
        setListener();

    }

    private void setListener() {
        iv_back_picture_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("shopId",shopId);
        DefaultPicsFragmentInActivity defaultPicsFragmentInActivity = new DefaultPicsFragmentInActivity();
        defaultPicsFragmentInActivity.setArguments(bundle);
        NetFriendUpdateFragmentInActivity netFriendUpdateFragmentInActivity = new NetFriendUpdateFragmentInActivity();
        netFriendUpdateFragmentInActivity.setArguments(bundle);
        list.add(defaultPicsFragmentInActivity);
        list.add(netFriendUpdateFragmentInActivity);

        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.fl_picture_show, list.get(0));
        ft.commit();
    }


    private void initView() {
        list = new ArrayList<>();
        buttons = new RadioButton[group.getChildCount()];
        for (int i = 0; i < group.getChildCount(); i++) {
            buttons[i]= (RadioButton) group.getChildAt(i);
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
                    ft.add(R.id.fl_picture_show, list.get(i));
                    ft.hide(currentFragment);
                    ft.commit();
                }
                current = i;
            }
        });
    }
}
