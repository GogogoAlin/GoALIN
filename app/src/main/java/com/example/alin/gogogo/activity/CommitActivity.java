package com.example.alin.gogogo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.alin.gogogo.LoginService;
import com.example.alin.gogogo.R;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class CommitActivity extends AppCompatActivity {
    private Button back_btn;
    private RadioGroup rg_select;
    private RadioButton menbtn,womenbtn;
    private EditText PhoneNumber;//手机号
    private EditText VertifyCode;//验证码
    private EditText nickName;//昵称
    private EditText password;//密码
    private CheckBox checkBox_Agrement;//checkbox
    private Button Register;//注册
    private Button SendReQuest; //请求验证码
    private EventHandler eventHandler;


    private String username,passwords,sex,phonenumber;

    private static final int CODE_ING = 1;   //已发送，倒计时
    private static final int CODE_REPEAT = 2;  //重新发送
    private static final int SMSDDK_HANDLER = 3;  //短信回调
    private int TIME = 60;//倒计时60s
    private String userphone;

    private Handler handler=new Handler(){
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case CODE_ING://已发送,倒计时
                    SendReQuest.setText("重新发送("+--TIME+"s)");
                    break;
                case CODE_REPEAT://重新发送
                    SendReQuest.setText("获取验证码");
                    SendReQuest.setClickable(true);
                    break;
                case SMSDDK_HANDLER:
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    //回调完成
                    if (result == SMSSDK.RESULT_COMPLETE)
                    {
                        //验证码验证成功
                        if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)
                        {
                            Toast.makeText(CommitActivity.this, "验证成功", Toast.LENGTH_LONG).show();

                            if(check()){
                                username=nickName.getText().toString();
                                passwords=password.getText().toString();
                                phonenumber=PhoneNumber.getText().toString();
                                if(rg_select.getCheckedRadioButtonId()==R.id.rb_men){
                                    sex="男";

                                }else{
                                    sex="女";
                                }
                                LoginService.saveuserInfo(getApplicationContext(),username,passwords,sex,phonenumber);
                                finish();


                            }


                        }
                        //已发送验证码
                        else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE)
                        {
                            Toast.makeText(getApplicationContext(), "验证码已经发送",
                                    Toast.LENGTH_SHORT).show();
                        } else
                        {
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    if(result==SMSSDK.RESULT_ERROR)
                    {
                        try {
                            Throwable throwable = (Throwable) data;
                            throwable.printStackTrace();
                            JSONObject object = new JSONObject(throwable.getMessage());
                            String des = object.optString("detail");//错误描述
                            int status = object.optInt("status");//错误代码
                            if (status > 0 && !TextUtils.isEmpty(des)) {
                                Toast.makeText(getApplicationContext(), des, Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                            //do something
                        }
                    }
                    break;



            }
        }

    };

  boolean check() {
        if(TextUtils.isEmpty(nickName.getText().toString())||TextUtils.isEmpty(password.getText().toString())){

            Toast.makeText(CommitActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
      if(!checkBox_Agrement.isChecked()){

          Toast.makeText(CommitActivity.this, "请认真阅读用户协议", Toast.LENGTH_SHORT).show();

          return false;

      }

      if(LoginService.getSavaUserInfo(getApplicationContext())!=null){
          List<Map<String, String> > list =LoginService.getSavaUserInfo(getApplicationContext());
          for (int i = 0; i < list.size(); i++) {
              if(list.get(i).get("phonenumber").equals(phonenumber)){
                  Toast.makeText(CommitActivity.this,"该用户已经被注册",Toast.LENGTH_SHORT).show();
                  return false;
              }

          }


      }

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit);
        initView();
        initSDK();//短信初始化

    }

    private void initSDK() {
        SMSSDK.initSDK(this, "14f61058074cc", "e0ac984e98cd7cb395499825732d9d70");
        eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                msg.what = SMSDDK_HANDLER;
                handler.sendMessage(msg);
            }
        };
        // 注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
    }

    private void initView() {
        rg_select=(RadioGroup)findViewById(R.id.rg_commit);
        back_btn = (Button) findViewById(R.id.commit_back);
        PhoneNumber = (EditText) findViewById(R.id.commit_phone_et);
        VertifyCode = (EditText) findViewById(R.id.login_check_et);
        nickName = (EditText) findViewById(R.id.niname_et);
        password = (EditText) findViewById(R.id.mima_commit_et);
        checkBox_Agrement = (CheckBox) findViewById(R.id.checkbox_commit);
        Register = (Button) findViewById(R.id.login_commit_btn);
        SendReQuest = (Button) findViewById(R.id.getcheck_tv);
        Register.setOnClickListener(new OnClickListener());
        SendReQuest.setOnClickListener(new OnClickListener());



    }


     private class OnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            switch(view.getId()){

                case R.id.getcheck_tv:
                    userphone=PhoneNumber.getText().toString();
                    new AlertDialog.Builder(CommitActivity.this)
                            .setTitle("发送短信")
                            .setMessage("我们将把验证码发送到以下号码:\n"+"+86:"+userphone)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    SMSSDK.getVerificationCode("86", userphone);
                                    SendReQuest.setClickable(false);
                                    new Thread(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            for (int i = 60; i > 0; i--)
                                            {
                                                handler.sendEmptyMessage(CODE_ING);
                                                if (i <= 0)
                                                {
                                                    break;
                                                }
                                                try
                                                {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException e)
                                                {
                                                    e.printStackTrace();
                                                }
                                            }
                                            handler.sendEmptyMessage(CODE_REPEAT);
                                        }
                                    }).start();
                                }
                            })
                            .create()
                            .show();
                    break;
                case R.id.login_commit_btn:
                    SMSSDK.submitVerificationCode("86", userphone, VertifyCode.getText().toString());//对验证码进行验证->回调函数
                    break;

            }






        }
    }


}
