package com.kersitery.taxi.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    private int time = 5;
    private TextView txtView;
    private Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        findView();
    }
    private void findView(){
        txtView = (TextView) findViewById(R.id.tv_countdown);
        txtView.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                //跳转不会跳转两次，直接点击就停止timer和handler
                if (runnable!=null){
                    handler.removeCallbacks(runnable);
                }
            }
        });
        timer.schedule(timerTask,1000,1000);//延迟1s每隔1s倒计时
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() { @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);//5s后执行下面的程序
    }
    TimerTask timerTask = new TimerTask() { @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    txtView.setText("跳转 "+time+" s");
                    if(time<0){
                        timer.cancel();//避免跳两次
                    }
                }
            });//在另外的线程中更新主线程的时间
        }
    };



}
