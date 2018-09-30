package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.MessageMarketBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.example.jason_jukes.laihuo.view.glide.GlideRoundTransform;
import com.example.jason_jukes.laihuo.view.nineImage.NineGridlayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/23 0023.
 */

public class MessageMarketLVAdapter extends BaseAdapter {

    private Context context;
    private List<MessageMarketBean.DataObjBean.RtListBean> been;

    public MessageMarketLVAdapter(Context context, List<MessageMarketBean.DataObjBean.RtListBean> been) {
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
        MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_message_market, viewGroup, false);
            viewHolder = new MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        viewHolder.name.setText(been.get(i).getUsername());
        viewHolder.date.setText(been.get(i).getCreate_time());
        Glide.with(context).load(been.get(i).getHead_url()).transform(new GlideCircleTransform(context)).into(viewHolder.avatar);
        viewHolder.content.setText(been.get(i).getContents());
        List<String> imgs = new ArrayList<>();

        String str = been.get(i).getPics();
        String[] arr = str.split(",");//分割字符串得到数组
        List<String> list = java.util.Arrays.asList(arr);//字符数组转list

        for (int i1 = 0; i1 < list.size(); i1++) {
            imgs.add(Contants.URL_IMG_BASE + list.get(i1));
        }

        viewHolder.nineGridlayout.setImagesData(imgs);

        viewHolder.ll.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) context.getResources().getDimension(R.dimen.y80), ViewGroup.LayoutParams.MATCH_PARENT);

        for (int i1 = 0; i1 < been.get(i).getTopicLogList().size(); i1++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setLayoutParams(params);
            Glide.with(context).load(been.get(i).getTopicLogList().get(i1).getHead_url()).transform(new GlideCircleTransform(context)).into(imageView);
            viewHolder.ll.addView(imageView);
        }

        viewHolder.focus_count.setText(been.get(i).getClick_count() + "人");
        viewHolder.comment_count.setText(been.get(i).getSreplyList().size() + "");
        return view;
    }


    class MyViewHolder {


        TextView name, date, content, focus_count, comment_count;
        ImageView avatar;
        LinearLayout ll;
        NineGridlayout nineGridlayout;

        public MyViewHolder(View view) {

            name = (TextView) view.findViewById(R.id.tv_name);
            date = (TextView) view.findViewById(R.id.tv_date);
            content = (TextView) view.findViewById(R.id.tv_content);
            focus_count = (TextView) view.findViewById(R.id.tv_focus_count);
            comment_count = (TextView) view.findViewById(R.id.tv_comment_count);
            avatar = (ImageView) view.findViewById(R.id.iv_avatar);
            ll = (LinearLayout) view.findViewById(R.id.ll_img);
            nineGridlayout = (NineGridlayout) view.findViewById(R.id.iv_img_list);

        }
    }

}
