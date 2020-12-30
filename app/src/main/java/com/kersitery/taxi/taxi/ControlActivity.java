package com.kersitery.taxi.taxi;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ControlActivity extends AppCompatActivity {
    private RadioGroup rg;
    private LinearLayout layout;
    private RadioButton control,work,message,me;
    FragmentOne fragmentOne ;
    FragmentTwo fragmentTwo;
    FragmentThree fragmentThree;
    FragmentFour fragmentFour ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        layout = (LinearLayout) findViewById(R.id.layout);
        control = (RadioButton) findViewById(R.id.control);
        work = (RadioButton) findViewById(R.id.work);
        message = (RadioButton) findViewById(R.id.message);
        me = (RadioButton) findViewById(R.id.me);
        fragmentOne = new FragmentOne();
       fragmentTwo = new FragmentTwo();
       fragmentThree = new FragmentThree();
        fragmentFour = new FragmentFour();
        getFragmentManager().beginTransaction().add(R.id.layout, fragmentOne).commitAllowingStateLoss();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.control:
                        if(fragmentOne==null){
                            fragmentOne = new FragmentOne();
                        }
                        getFragmentManager().beginTransaction().replace(R.id.layout,fragmentOne).commitAllowingStateLoss();
                        break;
                    case R.id.work:
                        if(fragmentTwo==null){
                            fragmentTwo = new FragmentTwo();
                            break;
                        }
                        getFragmentManager().beginTransaction().replace(R.id.layout,fragmentTwo).commitAllowingStateLoss();
                        break;
                    case R.id.message:
                        if(fragmentThree==null){
                            fragmentThree = new FragmentThree();
                        }
                        getFragmentManager().beginTransaction().replace(R.id.layout,fragmentThree).commitAllowingStateLoss();
                        break;

                    case R.id.me:
                        if(fragmentFour==null){
                            fragmentFour = new FragmentFour();
                        }
                        getFragmentManager().beginTransaction().replace(R.id.layout,fragmentFour).commitAllowingStateLoss();
                        break;
                }

            }
            
        });
    }
}
