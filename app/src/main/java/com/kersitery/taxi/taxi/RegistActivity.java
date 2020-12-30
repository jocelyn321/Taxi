package com.kersitery.taxi.taxi;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_top;
    private ImageView img_back;

    private EditText ed_username, ed_password ,ed_reaffirm;
    private Button btn_regist;
    private UserSQLitHelper helper;
    private UserDao dao;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        helper = new UserSQLitHelper(this);
        dao = new UserDao(this);
        sp = getSharedPreferences("data", MODE_PRIVATE);

        ed_username = (EditText) findViewById(R.id.ed_usernameR);
        ed_password = (EditText) findViewById(R.id.ed_passwordR);
        ed_reaffirm = (EditText) findViewById(R.id.ed_reaffirm);
        btn_regist = (Button) findViewById(R.id.btn_registR);
        btn_regist.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registR:
                String username = ed_username.getText().toString().trim();
                String password = ed_password.getText().toString().trim();
                String again = ed_reaffirm.getText().toString().trim();
                if(TextUtils.isEmpty(username) ||
                        TextUtils.isEmpty(password) ||
                        TextUtils.isEmpty(again)){
                    Toast.makeText(RegistActivity.this,"请完善信息",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.equals(again)){
                    //把username,password注册到
                    addUser(username, password);
                    Intent intent  = new Intent(RegistActivity.this, MainActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(RegistActivity.this,"两次输入密码不同，请重新输入",Toast.LENGTH_SHORT).show();
                }
        }

    }
    public void addUser(String username,String password){
        String pwd = dao.login(username);
        if(pwd == null){
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();   //
            values.put("username", username);
            values.put("password", password);
            db.insert("tbl_user", null, values);
            db.close();
        }else{
            Toast.makeText(RegistActivity.this,"该用户名已经存在",Toast.LENGTH_SHORT).show();
        }



    }


}
