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
 * Created by Administrator on 2018/9/25 0025.
 */

public class FindWorkLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public FindWorkLVAdapter(Context context, List<String> been) {
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
        FindWorkLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_find_work, viewGroup, false);
            viewHolder = new FindWorkLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (FindWorkLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.name.setText(been.get(i));

        return view;
    }


    class MyViewHolder {


        TextView date, content, name, work_status, jiage_status, address;
        ImageView img;

        public MyViewHolder(View view) {

            date = (TextView) view.findViewById(R.id.tv_date);
            name = (TextView) view.findViewById(R.id.tv_name);
            work_status = (TextView) view.findViewById(R.id.tv_status);
            jiage_status = (TextView) view.findViewById(R.id.tv_jiage_status);
            address = (TextView) view.findViewById(R.id.tv_address);
            content = (TextView) view.findViewById(R.id.tv_content);
            img = (ImageView) view.findViewById(R.id.iv_img);

        }
    }


}
