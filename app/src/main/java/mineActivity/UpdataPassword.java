package mineActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alin.gogogo.LoginService;
import com.example.alin.gogogo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdataPassword extends AppCompatActivity {
    private EditText  oldpassword,newpassword,surepassword;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_password);
        init();

    }

    private void init() {
        oldpassword=(EditText)findViewById(R.id.oldpassword);
        newpassword=(EditText)findViewById(R.id.newpassword);
        surepassword=(EditText)findViewById(R.id.surepassword);

    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.laod_back:
                finish();
                break;
            case R.id.submit:
                String o=oldpassword.getText().toString();
                String n=newpassword.getText().toString();
                String s=surepassword.getText().toString();
                SharedPreferences preference = this.getSharedPreferences("info", Context.MODE_PRIVATE);
                String phone = preference.getString("phonenumber", "");
                Log.i("TAG",phone+"=======================");
                if (phone !="") {
                    //已经登陆了
                    String password = preference.getString("password", "0");//要修改的密码
                    if(password.equals(o)){
                        //修改共享文件
                        SharedPreferences.Editor editor = preference.edit();
                        editor.putString("password",o).commit();
                        //修改内部存储的文件
                        File file = new File(this.getFilesDir(),"userinfo.txt");
                        Map<String,String> map = new HashMap<String,String>();
                        List<Map<String,String>> list=new ArrayList<>();

                        try {
                            FileInputStream fis = new FileInputStream(file);
                            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
                            String data;
                            while((data=bufferedReader.readLine())!=null) {
                                String[] infos = data.split("##");
                                if (infos[3].equals(phone)) {
                                    map.put("username", infos[0]);
                                    map.put("password",n);
                                    map.put("sex", infos[2]);
                                    map.put("phonenumber", infos[3]);
                                    list.add(map);
                                } else {
                                        map.put("username", infos[0]);
                                        map.put("password", infos[1]);
                                        map.put("sex", infos[2]);
                                        map.put("phonenumber", infos[3]);
                                        list.add(map);
                                    }
                                }
                            file.delete();
                            for (int i = 0; i < list.size(); i++) {
                                Map<String,String>maps=list.get(i);
                                LoginService.saveuserInfo(this,maps.get("username"),maps.get("password"),maps.get("sex"),maps.get("phonenumber"));

                            }
                            finish();


                        } catch (FileNotFoundException e) {
                            e.printStackTrace();

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }else{

                        Toast.makeText(UpdataPassword.this,"密码不正确",Toast.LENGTH_SHORT).show();
                        finish();

                    }

                }else{

                    Toast.makeText(this,"请先进行登陆",Toast.LENGTH_SHORT).show();
                    finish();
                }


        }
    }
}
