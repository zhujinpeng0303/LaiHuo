package com.example.jason_jukes.laihuo.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.jason_jukes.laihuo.R;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 11:48
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDetailPopupwindow {

    private Context context;
    private PopupWindow popupWindow;

    public WorkDetailPopupwindow(Context context) {
        this.context = context;
    }

    public void show(View v){

        View view = LayoutInflater.from(context).inflate(R.layout.popup_window_worke_detail,null);

        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        // 刷新状态
        popupWindow.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        popupWindow.setBackgroundDrawable(dw);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        popupWindow.setAnimationStyle(R.style.dialog_bottom_in);

        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);


    }

}
