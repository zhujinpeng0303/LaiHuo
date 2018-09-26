package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.example.jason_jukes.laihuo.view.nineImage.Image;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/26 0026 09:38
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class ClassifyGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public ClassifyGridViewAdapter(Context context, List<String> been) {
        this.context = context;
        this.been = been;
    }

    @Override
    public int getCount() {
        return been != null && been.size() > 0 ? been.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return been == null ? null : been.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ClassifyGridViewAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_gridview, viewGroup, false);
            viewHolder = new ClassifyGridViewAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ClassifyGridViewAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context).load(been.get(i))
                .transform(new GlideCircleTransform(context))
                .into(viewHolder.iv);

        viewHolder.name.setText("测试");

        return view;
    }


    class MyViewHolder {


        TextView name;
        ImageView iv;

        public MyViewHolder(View view) {

            name = (TextView) view.findViewById(R.id.tv_classify_name);
            iv = view.findViewById(R.id.iv_classify);


        }
    }

}
