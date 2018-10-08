package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.NearbyPersonBean;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 16:36
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class NearbyPersonLVAdapter extends BaseAdapter {

    private Context context;
    private List<NearbyPersonBean.DataArrBean> been;

    public NearbyPersonLVAdapter(Context context, List<NearbyPersonBean.DataArrBean> been) {
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
        NearbyPersonLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_nearby_person, viewGroup, false);
            viewHolder = new NearbyPersonLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (NearbyPersonLVAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context).load(been.get(i).getHead_url()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(viewHolder.avatar);
        viewHolder.name.setText(been.get(i).getName());
        viewHolder.juli.setText("距离" + been.get(i).getJuli() + "米");
        viewHolder.score.setText(been.get(i).getScore() + "");

        return view;
    }


    class MyViewHolder {

        TextView name, score, juli;
        ImageView avatar;

        public MyViewHolder(View view) {

            name = (TextView) view.findViewById(R.id.tv_name);
            score = (TextView) view.findViewById(R.id.tv_score);
            juli = (TextView) view.findViewById(R.id.tv_juli);
            avatar = (ImageView) view.findViewById(R.id.iv_avatar);


        }
    }


}
