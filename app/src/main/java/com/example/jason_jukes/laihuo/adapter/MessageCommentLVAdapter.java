package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.MessageDetailBean;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MessageCommentLVAdapter extends BaseAdapter {

    private Context context;
    private List<MessageDetailBean.DataObjBean.SreplyListBean> been;

    public MessageCommentLVAdapter(Context context, List<MessageDetailBean.DataObjBean.SreplyListBean> been) {
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
        MessageCommentLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_message_comment, viewGroup, false);
            viewHolder = new MessageCommentLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MessageCommentLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.content.setText(been.get(i).getContents());
        viewHolder.name.setText(been.get(i).getUsername());
        viewHolder.date.setText(been.get(i).getCreate_time());
        Glide.with(context).load(been.get(i).getHead_url()).transform(new GlideCircleTransform(context)).into(viewHolder.avatar);


        return view;
    }


    class MyViewHolder {


        TextView date, content, name;
        ImageView avatar;


        public MyViewHolder(View view) {

            date = (TextView) view.findViewById(R.id.tv_date);
            name = (TextView) view.findViewById(R.id.tv_name);
            content = (TextView) view.findViewById(R.id.tv_content);
            avatar = (ImageView) view.findViewById(R.id.iv_avatar);

        }
    }

}
