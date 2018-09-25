package com.example.jason_jukes.laihuo.view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.R;


/**
 * 作者：Jason_Jukes on 2018/1/24 0024 09:48
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 *
 * 通用dialog
 *
 */

public class CommonDialog {

    private AlertDialog dialog;
    private TvClick tvClick;
    private Context context;

    public CommonDialog(Context context) {
        this.context = context;
    }

    public void commonDialog(String title, String content, final TvClick tvClick) {

        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        dialog = adb.create();
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_common, null);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setView(view);

        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        TextView tv_ok = (TextView) view.findViewById(R.id.tv_ok);
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);

        tv_title.setText(title);
        tv_content.setText(content);

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvClick.okClick(dialog);
//                dialog.dismiss();
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvClick.cancelClick(dialog);
//                dialog.dismiss();

            }
        });

        dialog.show();

    }


    public interface TvClick {
        void okClick(AlertDialog dialog);

        void cancelClick(AlertDialog dialog);
    }


}
