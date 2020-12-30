package com.kersitery.taxi.taxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2020/6/22.
 */

public class MessageAdapter extends BaseAdapter {
    private Context mContext;

    public MessageAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 3;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_work, null);
        }
        return view;
    }
}
