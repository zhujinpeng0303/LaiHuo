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
 * 作者：Jason_Jukes on 2018/9/26 0026 08:49
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class AddressManagerLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public AddressManagerLVAdapter(Context context, List<String> been) {
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
        AddressManagerLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_address_manager, viewGroup, false);
            viewHolder = new AddressManagerLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (AddressManagerLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.name.setText(been.get(i));

        return view;
    }


    class MyViewHolder {


        TextView name, address,phone;


        public MyViewHolder(View view) {

            name = (TextView) view.findViewById(R.id.tv_name);
            address = (TextView) view.findViewById(R.id.tv_address);
            phone = (TextView) view.findViewById(R.id.tv_phone);


        }
    }

}
