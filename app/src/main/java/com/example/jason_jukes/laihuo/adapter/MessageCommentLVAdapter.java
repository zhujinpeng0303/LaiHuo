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
 * Created by Administrator on 2018/9/24 0024.
 */

public class MessageCommentLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public MessageCommentLVAdapter(Context context, List<String> been) {
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

        viewHolder.content.setText(been.get(i));

        return view;
    }


    class MyViewHolder {


        TextView date, content, name;
        ImageView avatar;


        public MyViewHolder(View view) {

            date = view.findViewById(R.id.tv_date);
            content = view.findViewById(R.id.tv_content);
            avatar = view.findViewById(R.id.iv_avatar);

        }
    }

}
