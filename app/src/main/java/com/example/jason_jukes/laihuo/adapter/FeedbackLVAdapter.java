package com.example.jason_jukes.laihuo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;

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
    private List<String> been;
    private int pos;
    private int temp = -1;//记录每次点击的按钮的Id

    private HashMap<String, Boolean> states = new HashMap<String, Boolean>();//记录所有radiobutton被点击的状态

    public void setPos(int pos) {
        this.pos = pos;
        notifyDataSetChanged();
    }

    public FeedbackLVAdapter(Activity context, List<String> been) {
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

        viewHolder.content.setText(been.get(i));

//        viewHolder.rb.setId(i);
//        viewHolder.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {//如果是选中状态
//                    if (temp != -1) {//temp不为-1，说明已经进行过点击事件
//                        RadioButton tempButton = (RadioButton) context.findViewById(temp);
//                        if (tempButton != null) {
//                            tempButton.setChecked(false);//取到上一次点击的RadioButton，并设置为未选中状态
//                        }
//                    }
//                    temp = compoundButton.getId();//将temp重新赋值，记录下本次点击的RadioButton
//                }
//            }
//        });

//        if (i == pos) {
//            viewHolder.rb.setChecked(true);
//        } else {
//            viewHolder.rb.setChecked(false);
//        }

//        boolean res=false;
//        if(getStates(position)==null||
//                getStates(position)==false)//判断当前位置的radiobutton点击状态
//        {
//            res=false;
//            setStates(position, false);
//
//        }else{
//            res=true;
//        }

        return view;
    }


    class MyViewHolder {


        TextView content;
        RadioButton rb;


        public MyViewHolder(View view) {

            content = view.findViewById(R.id.tv_content);
            rb = view.findViewById(R.id.rb);

        }
    }

}
