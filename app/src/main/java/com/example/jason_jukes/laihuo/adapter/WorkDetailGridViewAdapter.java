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
import com.example.jason_jukes.laihuo.bean.WorkDetailBean;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 09:29
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDetailGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<WorkDetailBean.DataObjBean.GetWorkerBidListBean> been;
    private moreClick moreClick;
    private phoneClick phoneClick;


    public WorkDetailGridViewAdapter(Context context, List<WorkDetailBean.DataObjBean.GetWorkerBidListBean> been, WorkDetailGridViewAdapter.moreClick moreClick, WorkDetailGridViewAdapter.phoneClick phoneClick) {
        this.context = context;
        this.been = been;
        this.moreClick = moreClick;
        this.phoneClick = phoneClick;
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
        WorkDetailGridViewAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_work_detail_gridview, viewGroup, false);
            viewHolder = new WorkDetailGridViewAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (WorkDetailGridViewAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context).load(been.get(i).getHead_url()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(viewHolder.avatar);
        viewHolder.name.setText(been.get(i).getUsername());
        if (been.get(i).getBid_status() == 1) {
            viewHolder.jiage_status.setText("最终报价:");
            viewHolder.status.setBackgroundResource(R.drawable.bg_red_big_corner);
            viewHolder.money.setTextColor(context.getResources().getColor(R.color.redDark));
            viewHolder.yuan.setTextColor(context.getResources().getColor(R.color.red));
        } else if (been.get(i).getBid_status() == 0) {
            viewHolder.jiage_status.setText("预估价格:");
            viewHolder.status.setBackgroundResource(0);
            viewHolder.money.setTextColor(context.getResources().getColor(R.color.colorBlack));
            viewHolder.yuan.setTextColor(context.getResources().getColor(R.color.colorGray));
        } else if (been.get(i).getBid_status() == 2) {
            viewHolder.jiage_status.setText("预估价格:");
            viewHolder.status.setBackgroundResource(R.drawable.bg_orange_big_corner);
            viewHolder.money.setTextColor(context.getResources().getColor(R.color.colorBlack));
            viewHolder.yuan.setTextColor(context.getResources().getColor(R.color.colorGray));
        }
        viewHolder.money.setText(been.get(i).getBid_price_max() + "");
        viewHolder.score.setText(been.get(i).getRanking_last());

        viewHolder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreClick.MoreClick(i);
            }
        });

        viewHolder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneClick.PhoneClick(i);
            }
        });

        return view;
    }


    class MyViewHolder {

        TextView name, jiage_status, money, score, yuan;
        ImageView avatar, more, status;

        public MyViewHolder(View view) {

            name = view.findViewById(R.id.tv_name);
            yuan = view.findViewById(R.id.tv_yuan);
            jiage_status = view.findViewById(R.id.tv_jiage_status);
            money = view.findViewById(R.id.tv_jiage);
            score = view.findViewById(R.id.tv_score);
            avatar = view.findViewById(R.id.iv_avatar);
            more = view.findViewById(R.id.iv_more);
            status = view.findViewById(R.id.iv_status);

        }
    }

    public interface moreClick{
        void  MoreClick(int pos);
    }

     public interface phoneClick{
        void  PhoneClick(int pos);
    }

}
