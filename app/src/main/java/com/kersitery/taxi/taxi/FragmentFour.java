package com.kersitery.taxi.taxi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Administrator on 2020/6/19.
 */

public class FragmentFour extends Fragment {
    private ImageView back;
    private Button btn_out;
    private ListView listView;
    private String[] arrayword = new String[]{"个人信息","任务查询","修改密码","关于我们"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        back = view.findViewById(R.id.back);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().finish();
//            }
//        });
        btn_out = view.findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        listView = view.findViewById(R.id.lv_me);
        listView.setAdapter(new MeAdapter(getActivity(),arrayword));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent1 = new Intent(getActivity(),MyMessageActivity.class);
                        startActivity(intent1);
                        break;

                    case 1:
                        Intent intent2 = new Intent(getActivity(),JobActivity.class);
                        startActivity(intent2);
                        break;

                    case 2:
                        Intent intent3 = new Intent(getActivity(),ChangePWActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getActivity(),AoutMeActivity.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }

}
