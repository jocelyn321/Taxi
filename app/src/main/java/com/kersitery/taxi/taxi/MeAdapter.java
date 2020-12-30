package com.kersitery.taxi.taxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2020/6/22.
 */

public class MeAdapter extends BaseAdapter {
    private Context mContext;
    private String[] arraywords;

    public MeAdapter(Context mContext, String[] arraywords) {
        this.mContext = mContext;
        this.arraywords = arraywords;
    }

    @Override
    public int getCount() {
        return arraywords.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        private TextView textView;
        private TextView divider;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_me,null);
            viewHolder.textView = view.findViewById(R.id.tv_item);
            viewHolder.divider = view.findViewById(R.id.divider);
            viewHolder.textView.setText(arraywords[i]);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }
}
