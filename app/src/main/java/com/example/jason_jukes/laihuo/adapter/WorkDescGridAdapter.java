package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.glide.GlideRoundTransform;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/10/8 0008 10:00
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDescGridAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;
    private delClick delClick;

    public WorkDescGridAdapter(Context context, List<String> been, WorkDescGridAdapter.delClick delClick) {
        this.context = context;
        this.been = been;
        this.delClick = delClick;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        WorkDescGridAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_grid_work_desc, viewGroup, false);
            viewHolder = new WorkDescGridAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (WorkDescGridAdapter.MyViewHolder) view.getTag();
        }

        if (been.size() == 1) {
            viewHolder.iv.setBackgroundResource(0);
            viewHolder.rl_del.setVisibility(View.GONE);
            viewHolder.rladd.setVisibility(View.VISIBLE);
        } else {
            if (i == 0) {
                viewHolder.iv.setBackgroundResource(0);
                viewHolder.rl_del.setVisibility(View.GONE);
                viewHolder.rladd.setVisibility(View.VISIBLE);
            } else {
                viewHolder.rl_del.setVisibility(View.VISIBLE);
                viewHolder.rladd.setVisibility(View.GONE);
                Glide.with(context)
                        .load(been.get(i))
                        .apply(RequestOptions.bitmapTransform(new GlideRoundTransform(context)))
                        .into(viewHolder.iv);
            }
        }

        viewHolder.rl_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delClick.DelClick(i);
            }
        });

        return view;
    }

    class MyViewHolder {


        ImageView iv, del;
        RelativeLayout rl_del, rladd;

        public MyViewHolder(View view) {

            iv = (ImageView) view.findViewById(R.id.iv);
            del = (ImageView) view.findViewById(R.id.iv_del);
            rl_del = (RelativeLayout) view.findViewById(R.id.rl_del);
            rladd = (RelativeLayout) view.findViewById(R.id.rl_add);


        }
    }

    public interface delClick{

        void  DelClick(int pos);

    }

}
