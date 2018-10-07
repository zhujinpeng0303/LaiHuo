package com.example.jason_jukes.laihuo.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2018/10/2 0002.
 */

public class ClassifyPopupWindow extends PopupWindow {

    private Context context;
    private PopupWindow popupWindow;

    public  ClassifyPopupWindow(Activity activity,PopupWindow popupWindow1) {

        popupWindow = popupWindow1;
        context = activity;
//        View inflate = activity.getLayoutInflater().inflate(R.layout.layout_gethos_window, null);

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        // 刷新状态
        popupWindow.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        popupWindow.setBackgroundDrawable(dw);
        // 设置SelectPicPopupWindow弹出窗体动画效果

    }
}
