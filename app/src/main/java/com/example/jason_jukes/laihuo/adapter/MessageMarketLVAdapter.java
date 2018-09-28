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
 * Created by Administrator on 2018/9/23 0023.
 */

public class MessageMarketLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public MessageMarketLVAdapter(Context context, List<String> been) {
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

        viewHolder.nineGridlayout.setImagesData(been);

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
