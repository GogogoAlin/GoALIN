package com.example.alin.gogogo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alin.gogogo.activity.ForgetKeyActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login_btn, forget_btn;
    private EditText phone_et, key_et;
    private ImageView back_btn;
    private String password;
    private String phonenumber;
    private String username;
    private String sex;
    List<Map<String, String>> list = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_layout);
        back_btn = (ImageView) findViewById(R.id.laod_back);
        login_btn = (Button) findViewById(R.id.load_login_bt);
        forget_btn = (Button) findViewById(R.id.forget_key);
        phone_et = (EditText) findViewById(R.id.login_phone_et);
        key_et = (EditText) findViewById(R.id.login_mima_et);
        setListener();

    }

    private void setListener() {
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        forget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetKeyActivity.class);
                startActivity(intent);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check()) {
                    SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", username).commit();
                    editor.putString("password", password).commit();
                    editor.putString("sex", sex).commit();
                    editor.putString("phonenumber", phonenumber).commit();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("id", 4);
                    startActivity(intent);

                }

            }
        });


    }

    private boolean check() {
        if (TextUtils.isEmpty(phone_et.getText().toString()) || TextUtils.isEmpty(key_et.getText().toString())) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (LoginService.getSavaUserInfo(getApplicationContext()) != null) {
            list = LoginService.getSavaUserInfo(getApplicationContext());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get("phonenumber").equals(phone_et.getText().toString()) && list.get(i).get("password").equals(key_et.getText().toString())) {

                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    username = list.get(i).get("username").toString();
                    password = list.get(i).get("password").toString();
                    sex = list.get(i).get("sex").toString();
                    phonenumber = list.get(i).get("phonenumber").toString();
                    return true;
                }


            }


        }


        Toast.makeText(LoginActivity.this, "用户名密码不正确", Toast.LENGTH_SHORT).show();
        return false;
    }


    @Override
    public void onClick(View view) {

    }
}
