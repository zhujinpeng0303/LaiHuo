package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 11:53
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineWalletLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public MineWalletLVAdapter(Context context, List<String> been) {
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
        MineWalletLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_focus_list, viewGroup, false);
            viewHolder = new MineWalletLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineWalletLVAdapter.MyViewHolder) view.getTag();
        }


        return view;
    }


    class MyViewHolder {

        public MyViewHolder(View view) {


        }
    }

}
