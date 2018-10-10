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
import com.example.jason_jukes.laihuo.bean.FindWorkBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/10/2 0002.
 */

public class FindWorkLVAdapter extends BaseAdapter {

    private Context context;
    private List<FindWorkBean.DataObjBean.RtListBean> been;

    public FindWorkLVAdapter(Context context, List<FindWorkBean.DataObjBean.RtListBean> been) {
        this.context = context;
        this.been = been;
    }

    public void addBeen1(List<FindWorkBean.DataObjBean.RtListBean> been1) {
        been.addAll(been1);
        notifyDataSetChanged();
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

        Glide.with(context).load(Contants.URL_IMG_BASE + been.get(i).getClassify_photo_path()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(viewHolder.img);
        viewHolder.name.setText(been.get(i).getOrder_title());
        viewHolder.content.setText(been.get(i).getOrder_desc());
        viewHolder.date.setText(been.get(i).getCreate_time_day() + " " + been.get(i).getCreate_time_second());
        viewHolder.work_status.setText(been.get(i).getOrder_status_text());
        if (been.get(i).getOrder_status_text().equals("待支付") || been.get(i).getOrder_status_text().equals("询价中") || been.get(i).getOrder_status_text().equals("未抢单")) {
            viewHolder.work_status.setBackgroundResource(R.drawable.bg_dark_orange_big_conner);
        } else if (been.get(i).getOrder_status_text().equals("已抢单") || been.get(i).getOrder_status_text().equals("已完成")) {
            viewHolder.work_status.setBackgroundResource(R.drawable.bg_green_big_corner);
        } else if (been.get(i).getOrder_status_text().equals("进行中")) {
            viewHolder.work_status.setBackgroundResource(R.drawable.bg_orange_big_corner);
        } else {
            viewHolder.work_status.setBackgroundResource(R.drawable.bg_light_grey_big_corner);
        }

        if (been.get(i).getOrder_type().equals("fixed_price")) {

            viewHolder.jiage_status.setText("一口价: " + been.get(i).getOrder_price() + "元");
            viewHolder.jiage_status.setTextColor(context.getResources().getColor(R.color.DarkOrange));
            viewHolder.jiage_status.setBackgroundResource(R.drawable.bg_dark_orange_stroke_big_corner);

        } else if (been.get(i).getOrder_type().equals("talk_price")) {

            viewHolder.jiage_status.setText("竞价: " + been.get(i).getBid_count() + "人");
            viewHolder.jiage_status.setTextColor(context.getResources().getColor(R.color.colorGreenBottle));
            viewHolder.jiage_status.setBackgroundResource(R.drawable.bg_green_stroke_big_corner);

        }

        return view;
    }


    class MyViewHolder {


        TextView date, content, name, work_status, jiage_status, address;
        ImageView img;

        public MyViewHolder(View view) {

            date = (TextView) view.findViewById(R.id.tv_time);
            name = (TextView) view.findViewById(R.id.tv_name);
            work_status = (TextView) view.findViewById(R.id.tv_status);
            jiage_status = (TextView) view.findViewById(R.id.tv_jiage_status);
            address = (TextView) view.findViewById(R.id.tv_address);
            content = (TextView) view.findViewById(R.id.tv_content);
            img = (ImageView) view.findViewById(R.id.iv_img);

        }
    }


}
