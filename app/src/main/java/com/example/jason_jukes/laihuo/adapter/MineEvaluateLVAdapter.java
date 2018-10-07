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
import com.example.jason_jukes.laihuo.bean.HomeBean;
import com.example.jason_jukes.laihuo.bean.MineEvaluateBean;
import com.example.jason_jukes.laihuo.bean.PersonHomeBean;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class MineEvaluateLVAdapter extends BaseAdapter {

    private Context context;
    private List<MineEvaluateBean.DataObjBean.RtListBean> been;

    public MineEvaluateLVAdapter(Context context, List<MineEvaluateBean.DataObjBean.RtListBean> been) {
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
        MineEvaluateLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_worker_evaluate_lv, viewGroup, false);
            viewHolder = new MineEvaluateLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineEvaluateLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.content.setText(been.get(i).getRanking_text());
        viewHolder.name.setText(been.get(i).getUsername());
        viewHolder.date.setText(been.get(i).getCreate_time_text());
        viewHolder.score.setText(been.get(i).getRanking_last() + "");
        Glide.with(context).load(been.get(i).getHead_url()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(viewHolder.avatar);


        return view;
    }


    class MyViewHolder {


        TextView date, content, name, score;
        ImageView avatar;


        public MyViewHolder(View view) {

            date = (TextView) view.findViewById(R.id.tv_time);
            name = (TextView) view.findViewById(R.id.tv_name);
            content = (TextView) view.findViewById(R.id.tv_content);
            score = (TextView) view.findViewById(R.id.tv_score);
            avatar = (ImageView) view.findViewById(R.id.iv_avatar);

        }
    }


}
