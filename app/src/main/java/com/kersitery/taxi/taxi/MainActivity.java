package com.kersitery.taxi.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private EditText et_name,et_password;
    private SharedPreferences sp;
    private UserSQLitHelper helper;
    private UserDao dao;
    private TextView tv_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new UserSQLitHelper(this);
        dao = new UserDao(this);
        sp = getSharedPreferences("data",MODE_PRIVATE);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        tv_sign = (TextView) findViewById(R.id.tv_sign);
        tv_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,RegistActivity.class);
                startActivity(intent1);
            }
        });
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username = et_name.getText().toString().trim();
               String password = et_password.getText().toString().trim();
                // 如果为空，完善信息
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this,"请完善信息",Toast.LENGTH_SHORT).show();
                    return;
                }
                // 密码与用户名匹配成功，则登录成功
                if (password.equals(dao.login(username))) {
                    Toast.makeText(MainActivity.this,username + "登录成功",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor e = sp.edit();// 获得SharedPreferences.Editor对象
                    e.putString("login", username); // 向SharedPreferences.Editor对象中添加数据
                    e.commit(); // 提交，完成数据储存
                    Intent intent2 = new Intent(MainActivity.this, ControlActivity.class);
                    startActivity(intent2);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String pass = intent.getStringExtra("password");
        et_name.setText(name);
        et_password.setText(pass);
    }
}
