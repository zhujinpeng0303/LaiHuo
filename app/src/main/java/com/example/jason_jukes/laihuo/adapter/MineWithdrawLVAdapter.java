package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.WithdrawBean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28 0028.
 */

public class MineWithdrawLVAdapter extends BaseAdapter {

    private Context context;
    private List<WithdrawBean.DataArrBean> been;

    public MineWithdrawLVAdapter(Context context, List<WithdrawBean.DataArrBean> been) {
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
        MineWithdrawLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_withdraw_lv, viewGroup, false);
            viewHolder = new MineWithdrawLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineWithdrawLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.money.setText(been.get(i).getMoney());


        return view;
    }


    class MyViewHolder {

        TextView name, time, money;

        public MyViewHolder(View view) {

            name = view.findViewById(R.id.tv_name);
            time = view.findViewById(R.id.tv_time);
            money = view.findViewById(R.id.tv_money);

        }
    }

}
