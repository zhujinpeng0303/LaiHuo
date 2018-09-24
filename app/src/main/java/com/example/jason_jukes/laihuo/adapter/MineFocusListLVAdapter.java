package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.nineImage.NineGridlayout;

import java.util.List;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineFocusListLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public MineFocusListLVAdapter(Context context, List<String> been) {
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
        MineFocusListLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_focus_list, viewGroup, false);
            viewHolder = new MineFocusListLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineFocusListLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.name.setText(been.get(i));

        return view;
    }


    class MyViewHolder {

        TextView name, count;
        ImageView avatar, card, phone;

        public MyViewHolder(View view) {

            name = view.findViewById(R.id.tv_name);
            count = view.findViewById(R.id.tv_star_count);
            avatar = view.findViewById(R.id.iv_avatar);
            card = view.findViewById(R.id.iv_card);
            phone = view.findViewById(R.id.iv_phone);

        }
    }


}
