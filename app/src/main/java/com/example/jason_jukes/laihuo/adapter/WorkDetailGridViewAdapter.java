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

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 09:29
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDetailGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public WorkDetailGridViewAdapter(Context context, List<String> been) {
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
        WorkDetailGridViewAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_work_detail_gridview, viewGroup, false);
            viewHolder = new WorkDetailGridViewAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (WorkDetailGridViewAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context).load(been.get(i)).transform(new GlideCircleTransform(context)).into(viewHolder.avatar);

        viewHolder.name.setText("测试");

        return view;
    }


    class MyViewHolder {

        TextView name, jiage_status, money, score;
        ImageView avatar, more, status;

        public MyViewHolder(View view) {

            name = view.findViewById(R.id.tv_name);
            jiage_status = view.findViewById(R.id.tv_jiage_status);
            money = view.findViewById(R.id.tv_jiage);
            score = view.findViewById(R.id.tv_score);
            avatar = view.findViewById(R.id.iv_avatar);
            more = view.findViewById(R.id.iv_more);
            status = view.findViewById(R.id.iv_status);

        }
    }


}
