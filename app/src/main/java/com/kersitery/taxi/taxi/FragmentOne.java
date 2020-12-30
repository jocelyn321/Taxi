package com.kersitery.taxi.taxi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2020/6/19.
 */

public class FragmentOne extends Fragment {
    private TextView see_s;
    private String[] content = new String[]{"马坡（1/20）","怡馨.仓上（1/20）","石园（1/20)",
            "博联.建新（1/20）","西单.国泰（1/20）"};
    private View view;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.lv_station);
        ControlAdapter controlAdapter = new ControlAdapter(getActivity(),content);
//        //配置适配器
        listView.setAdapter(controlAdapter);
        see_s = view.findViewById(R.id.see_s);
        listView.setAdapter(new ControlAdapter(getActivity(),content));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        see_s.setText("马坡（1/20）");
                        break;
                    case 1:
                        see_s.setText("怡馨.仓上（1/20）");

                        break;
                    case 2:
                        see_s.setText("石园（1/20）");
                        break;
                    case 3:
                        see_s.setText("博联.建新（1/20）");
                        break;

                    case 4:
                        see_s.setText("西单.国泰（1/20）");
                        break;
                }
            }
        });

//        //绑定recycleview的id
//        recyclerView = view.findViewById(R.id.recycle_view_control);
//        //竖直排布列表
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        //声明选择竖直排布
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        //适配器adapter
//        adapter = new ControlAdapter(setList());
//        recyclerView.setAdapter(adapter);

    }

//    private List<ControItem> setList() {
//        list = new ArrayList<>();
//        ControItem item = new ControItem();
//        item.content = "ming";
//
//        return list;
//    }
}
