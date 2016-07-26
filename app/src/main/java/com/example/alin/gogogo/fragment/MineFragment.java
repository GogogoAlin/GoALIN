package com.example.alin.gogogo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alin.gogogo.HomeActivity;
import com.example.alin.gogogo.LoginActivity;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.activity.AboutActivitys;
import com.example.alin.gogogo.activity.CollectionActivity;
import com.example.alin.gogogo.activity.CommitActivity;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;

import mineActivity.Label;
import mineActivity.MyInfo;
import mineActivity.UpdataPassword;

public class MineFragment extends Fragment {
    private Intent intent;
    private Button btn;
    private View view;
    private SlindingOnClickCallback callback;
    private Button btn_load, btn_commit, btn_order, btn_collect, LogInSucess;

    private String username, password, phonenumber, sex;
    private TextView textview;
    private Button exit;
    private LinearLayout camera_linear,about_linear,lable_linear,infor_linear,key_linear;
    public void setCallback(SlindingOnClickCallback callback) {
        this.callback = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, null);
        initView();
        initMine();
        setOnListener();


        return view;
    }

    private void setOnListener() {
        //返回
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.togOnClick();
            }
        });

        //推出登陆
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preference = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.clear().commit();
                continueLogin();

            }
        });
        //实现收藏按钮跳转的监听
        btn_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CollectionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void continueLogin() {

        btn_load.setVisibility(View.VISIBLE);
        btn_commit.setVisibility(View.VISIBLE);
        LogInSucess.setVisibility(View.INVISIBLE);
        textview.setVisibility(View.VISIBLE);
        exit.setVisibility(View.INVISIBLE);


    }

    private void initMine() {

        SharedPreferences preferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        phonenumber = preferences.getString("phonenumber", null);
        username = preferences.getString("username", null);
        password = preferences.getString("password", null);
        sex = preferences.getString("sex", null);

        if (phonenumber != null) {
            //已经登陆
            btn_load.setVisibility(View.GONE);
            btn_commit.setVisibility(View.GONE);
            LogInSucess.setVisibility(View.VISIBLE);
            textview.setVisibility(View.GONE);
            LogInSucess.setText(username);
            exit.setVisibility(View.VISIBLE);
            return;

        }


    }


    private void initView() {
        LogInSucess = (Button) view.findViewById(R.id.Login_sucess);//登陆
        textview = (TextView) view.findViewById(R.id.textView6);//提醒登陆

        btn = (Button) view.findViewById(R.id.sliding_mine);//侧滑
        btn_commit = (Button) view.findViewById(R.id.commit_mine);//注册
        exit = (Button) view.findViewById(R.id.exit);//推出登陆

        btn_order = (Button) view.findViewById(R.id.orderMenu);//我的订单
        btn_collect = (Button) view.findViewById(R.id.mineCollect);//我的收藏
        btn_load = (Button) view.findViewById(R.id.load_mine);//登陆

        camera_linear= (LinearLayout) view.findViewById(R.id.camera_linear);
        about_linear= (LinearLayout) view.findViewById(R.id.about_linear);
        lable_linear=(LinearLayout)view.findViewById(R.id.lable_linear);
        infor_linear=(LinearLayout)view.findViewById(R.id.infor_linear);
        key_linear=(LinearLayout)view.findViewById(R.id.key_linear);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CommitActivity.class);
                startActivity(intent);
            }
        });

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        camera_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(),HomeActivity.class);
                intent.putExtra("id",3);
                startActivity(intent);

            }
        });
        about_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =new Intent(getActivity(), AboutActivitys.class);
                startActivity(intent);
            }
        });
        lable_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =new Intent(getActivity(), Label.class);
                startActivity(intent);
            }
        });
        infor_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =new Intent(getActivity(), MyInfo.class);
                startActivity(intent);
            }
        });

        key_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =new Intent(getActivity(), UpdataPassword.class);
                startActivity(intent);
            }
        });
    }
}
