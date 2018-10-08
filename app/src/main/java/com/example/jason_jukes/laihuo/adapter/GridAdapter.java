package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.glide.GlideRoundTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/10/3 0003.
 */

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public GridAdapter(Context context, List<String> been) {
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
        GridAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_grid, viewGroup, false);
            viewHolder = new GridAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (GridAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context)
                .load(been.get(i))
                .apply(RequestOptions.bitmapTransform(new GlideRoundTransform(context,6)))
                .into(viewHolder.iv);

        return view;
    }


    class MyViewHolder {

        ImageView iv;

        public MyViewHolder(View view) {

            iv = view.findViewById(R.id.iv);


        }
    }


}
