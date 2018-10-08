package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.WalletChangeBean;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 11:53
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineWalletLVAdapter extends BaseAdapter {

    private Context context;
    private List<WalletChangeBean.DataObjBean.RtListBean> been;

    public MineWalletLVAdapter(Context context, List<WalletChangeBean.DataObjBean.RtListBean> been) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_mine_wallet, viewGroup, false);
            viewHolder = new MineWalletLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineWalletLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.name.setText(been.get(i).getForeign_type_text());
        viewHolder.time.setText(been.get(i).getCreate_time_text());

        if (been.get(i).getAdd_or_sub().equals("ADD")){
            viewHolder.money.setText("+ " + been.get(i).getMoney());
            viewHolder.money.setTextColor(context.getResources().getColor(R.color.Blue));
        }else {
            viewHolder.money.setText("- " + been.get(i).getMoney());
            viewHolder.money.setTextColor(context.getResources().getColor(R.color.Orange));
        }

        return view;
    }


    class MyViewHolder {

        TextView name,time,money;

        public MyViewHolder(View view) {

            name = view.findViewById(R.id.tv_name);
            time = view.findViewById(R.id.tv_time);
            money = view.findViewById(R.id.tv_money);

        }
    }

}
