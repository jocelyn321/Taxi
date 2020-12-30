package com.kersitery.taxi.taxi;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChangePWActivity extends AppCompatActivity {
    private Button btn_modify;
    private LinearLayout back;
    private EditText et_old,et_new,et_again;
    private SharedPreferences sp;
    private UserDao dao;
    private UserSQLitHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pw);
        back = (LinearLayout) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        et_old = (EditText) findViewById(R.id.et_old);
        et_new = (EditText) findViewById(R.id.et_new);
        et_again = (EditText) findViewById(R.id.et_again);
        dao = new UserDao(this);
        sp = getSharedPreferences("data", MODE_PRIVATE);
        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSave();
            }
        });
    }
    public void onSave(){
        String password = et_old.getText().toString().trim();
        String newPass = et_new.getText().toString();
        String newAgain = et_again.getText().toString();
        if (TextUtils.isEmpty(password)||TextUtils.isEmpty(newPass)||TextUtils.isEmpty(newAgain)) {
            Toast.makeText(ChangePWActivity.this,"请完善信息",Toast.LENGTH_SHORT).show();
            return;
        }
        String username = sp.getString("login", null);
        if(password.equals(dao.login(username))){
            if(newPass.equals(newAgain)){
                dao.update(username,newPass,null,null,null);
                Toast.makeText(ChangePWActivity.this,"密码修改成功",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(ChangePWActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(ChangePWActivity.this,"旧密码输入错误",Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
