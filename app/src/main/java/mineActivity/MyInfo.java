package mineActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.alin.gogogo.R;

public class MyInfo extends AppCompatActivity {
    private EditText phone,nickname,sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        initview();
        SharedPreferences preferences = getSharedPreferences("personnal", this.MODE_PRIVATE);
        if(preferences!=null){
            String p = preferences.getString("phone", "＋86");
            String n = preferences.getString("nickname", "dudu");
            String s = preferences.getString("sex", "");
            phone.setText(p);
            nickname.setText(n);
            sex.setText(s);

        }
    }

    private void initview() {
        phone=(EditText) findViewById(R.id.phone);
        nickname=(EditText)findViewById(R.id.nickname);
        sex=(EditText)findViewById(R.id.sex);



    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.laod_back:
                finish();
                break;
            case R.id.save:
                String phone_s = phone.getText().toString();
                String nickname_s=nickname.getText().toString();
                String sex_s=sex.getText().toString();
                SharedPreferences preferences = getSharedPreferences("personnal", this.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("phone",phone_s);
                editor.putString("nickname",nickname_s);
                editor.putString("sex",sex_s);
                editor.commit();
                break;
        }

    }
}
