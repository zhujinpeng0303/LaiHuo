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
import com.example.jason_jukes.laihuo.bean.PartWorkBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class MinePartWorkAdapter extends BaseAdapter {

    private Context context;
    private List<PartWorkBean.DataObjBean.RtListBean> been;
    private String type;

    public MinePartWorkAdapter(Context context, List<PartWorkBean.DataObjBean.RtListBean> been, String type) {
        this.context = context;
        this.been = been;
        this.type = type;
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
        MinePartWorkAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_find_work, viewGroup, false);
            viewHolder = new MinePartWorkAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MinePartWorkAdapter.MyViewHolder) view.getTag();
        }

        Glide.with(context).load(Contants.URL_IMG_BASE + been.get(i).getClassify_photo_path()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(viewHolder.img);
        viewHolder.name.setText(been.get(i).getOrder_title());
        viewHolder.content.setText(been.get(i).getOrder_desc());
        if (type.equals("1")) {
            viewHolder.date.setVisibility(View.VISIBLE);
            viewHolder.v.setVisibility(View.VISIBLE);
            viewHolder.date.setText(been.get(i).getOrder_create_time_day() + " " + been.get(i).getOrder_create_time_second());
        } else {
            viewHolder.date.setVisibility(View.GONE);
            viewHolder.v.setVisibility(View.GONE);
        }
//        viewHolder.work_status.setText(been.get(i).getOrder_status_text());
        viewHolder.work_status.setVisibility(View.GONE);
        viewHolder.address.setText(been.get(i).getArea_name_two());
//        if (been.get(i).getOrder_status_text().equals("待支付") || been.get(i).getOrder_status_text().equals("询价中") || been.get(i).getOrder_status_text().equals("未抢单")) {
//            viewHolder.work_status.setBackgroundResource(R.drawable.bg_red_big_corner);
//        } else if (been.get(i).getOrder_status_text().equals("进行中") || been.get(i).getOrder_status_text().equals("已抢单") || been.get(i).getOrder_status_text().equals("已完成")) {
//            viewHolder.work_status.setBackgroundResource(R.drawable.bg_green_big_corner);
//        } else {
//            viewHolder.work_status.setBackgroundResource(R.drawable.bg_grey_big_corner);
//        }

        if (been.get(i).getOrder_type().equals("fixed_price")) {

            viewHolder.jiage_status.setText("一口价: " + been.get(i).getOrder_price() + "元");

        } else if (been.get(i).getOrder_type().equals("talk_price")) {
            viewHolder.jiage_status.setText("竞价: " + been.get(i).getBid_count() + "人");
        }

        return view;
    }


    class MyViewHolder {


        TextView date, content, name, work_status, jiage_status, address;
        ImageView img;
        View v;

        public MyViewHolder(View view) {

            date = (TextView) view.findViewById(R.id.tv_time);
            name = (TextView) view.findViewById(R.id.tv_name);
            work_status = (TextView) view.findViewById(R.id.tv_status);
            jiage_status = (TextView) view.findViewById(R.id.tv_jiage_status);
            address = (TextView) view.findViewById(R.id.tv_address);
            content = (TextView) view.findViewById(R.id.tv_content);
            img = (ImageView) view.findViewById(R.id.iv_img);
            v = view.findViewById(R.id.v);

        }
    }


}
