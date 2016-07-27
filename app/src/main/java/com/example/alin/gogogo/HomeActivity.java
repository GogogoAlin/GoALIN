package com.example.alin.gogogo;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.alin.gogogo.fragment.CameraFragment;
import com.example.alin.gogogo.fragment.CollectionFragment;
import com.example.alin.gogogo.fragment.HomeFragment;
import com.example.alin.gogogo.fragment.MineFragment;
import com.example.alin.gogogo.fragment.OrderFragment;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SlindingOnClickCallback {
    private SlidingMenu.CanvasTransformer mTransformer;
    private List<Fragment> list;
    private RadioGroup group;
    private RadioButton[] buttons;
    private int current = 2;
    private FragmentManager manager;
    private SlidingMenu menu;
    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);


        initAnimation();
        initMenu();
        initView();
        initFragment();
           jump();

    }

    private void jump() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 2);
        switch (id) {
            case 3:
                buttons[3].setChecked(true);
                break;
            case 0:
                buttons[0].setChecked(true);
                break;
            case 4:
                buttons[4].setChecked(true);
                break;


        }
    }

    /***
     * @author Alin
     */
    private void initView() {
        list = new ArrayList<>();
        group = (RadioGroup) findViewById(R.id.rg_home_activity);
        buttons = new RadioButton[group.getChildCount()];
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
                    ft.add(R.id.fragmentlayout, list.get(i));
                    ft.hide(currentFragment);
                    ft.commit();
                }
                current = i;
            }
        });
    }

    /***
     * @author Alin
     */
    private void initFragment() {
        CollectionFragment collectionFragment = new CollectionFragment();
        collectionFragment.setCallback(this);
        OrderFragment orderFragment = new OrderFragment();
        orderFragment.setCallback(this);
        HomeFragment homeFragement = new HomeFragment();
        homeFragement.setCallback(this);
        CameraFragment cameraFragment = new CameraFragment();
        cameraFragment.setCallback(this);
        MineFragment mineFragment = new MineFragment();
        mineFragment.setCallback(this);
        list.add(collectionFragment);
        list.add(orderFragment);
        list.add(homeFragement);
        list.add(cameraFragment);
        list.add(mineFragment);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragmentlayout, homeFragement);
        transaction.commit();
    }

    /***
     * author LJ
     */
    private void initMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.7f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setBehindCanvasTransformer(mTransformer);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.leftmenu);
        LinearLayout linearLayout = (LinearLayout) menu.findViewById(R.id.mydetail);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                intent.putExtra("id",4);
                startActivity(intent);
            }
        });
    }

    /***
     * author LJ
     */
    private void initAnimation() {
        mTransformer = new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (percentOpen * 0.25 + 0.75);
                canvas.scale(scale, scale, canvas.getWidth() / 2,
                        canvas.getHeight() / 2);
            }
        };
    }

    /**
     * @author Alin
     */
    @Override
    public void togOnClick() {

        menu.toggle();
    }
}