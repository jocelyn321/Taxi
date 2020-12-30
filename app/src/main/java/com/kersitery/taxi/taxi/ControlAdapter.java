package com.kersitery.taxi.taxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ControlAdapter extends BaseAdapter {

    public Context mContext;//上下文指针
    private String[] content;//传进来的文字

    public ControlAdapter(Context mContext, String[] content) {
        this.mContext = mContext;
        this.content = content;
    }

    @Override
    public int getCount() {
        return content.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //控制列表项的所有显示
    static class ViewHolder{
        private TextView textView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(view == null){//如为空，就把布局加载进来
            view = LayoutInflater.from(mContext).inflate(R.layout.item_station,null);
            viewHolder.textView = view.findViewById(R.id.content);
            view.setTag(viewHolder);
        }else{//视图不为空，直接返回
            viewHolder =(ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(content[position]);
        return view;


    }

//    private List<ControItem> list;
//
//    public ControlAdapter(List<ControItem> list) {
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_control,viewGroup,false);//绑定页面的
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.txtContent.setText(list.get(position).content);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView txtContent;
//        TextView textView;
//        ImageView imageView;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            txtContent =itemView.findViewById(R.id.content);
//            imageView = itemView.findViewById(R.id.car);
//            textView = itemView.findViewById(R.id.view);
//        }
//    }
}

