package com.example.jason_jukes.laihuo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.TousuBean;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 16:28
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class FeedbackLVAdapter extends BaseAdapter {

    private Activity context;
    private List<TousuBean.DataArrBean> been;
    private int pos;
    private int temp = -1;//记录每次点击的按钮的Id

    private HashMap<String, Boolean> states = new HashMap<String, Boolean>();//记录所有radiobutton被点击的状态

    public void setPos(int pos) {
        this.pos = pos;
        notifyDataSetChanged();
    }

    public FeedbackLVAdapter(Activity context, List<TousuBean.DataArrBean> been) {
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
        FeedbackLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_feedback_content_lv, viewGroup, false);
            viewHolder = new FeedbackLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (FeedbackLVAdapter.MyViewHolder) view.getTag();
        }

        viewHolder.content.setText(been.get(i).getName());
        boolean res = false;
        if (getStates(i) == null || getStates(i) == false)//判断当前位置的radiobutton点击状态
        {
            res = false;
            setStates(i, false);

        } else {
            res = true;
        }

        viewHolder.rb.setChecked(res);

        return view;
    }

    //用于在activity中重置所有的radiobutton的状态
    public void clearStates(int position) {
        // 重置，确保最多只有一项被选中
        for (String key : states.keySet()) {
            states.put(key, false);
        }
        states.put(String.valueOf(position), true);
    }

    //用于获取状态值
    public Boolean getStates(int position) {
        return states.get(String.valueOf(position));
    }

    //设置状态值
    public void setStates(int position, boolean isChecked) {
        states.put(String.valueOf(position), false);
    }

    class MyViewHolder {

        TextView content;
        RadioButton rb;


        public MyViewHolder(View view) {

            content = (TextView) view.findViewById(R.id.tv_content);
            rb = (RadioButton) view.findViewById(R.id.rb);

        }
    }

}
