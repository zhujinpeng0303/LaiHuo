package com.example.jason_jukes.laihuo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作者：Jason_Jukes on 2018/9/20 0020 16:51
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class BaseFragment extends Fragment {

    protected Context context;
    private Dialog dialogProgress;
    private Toast toast;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //判断当前设备版本号是否为4.4以上，如果是，则通过调用setTranslucentStatus让状态栏变透明
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_progressbar, null);
        dialogProgress = new Dialog(context);
        dialogProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogProgress.setContentView(view);
        dialogProgress.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialogProgress.setCanceledOnTouchOutside(false);

    }

    public void startIntent(Class clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    public void showToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
        } else {
            toast.setText(string);
        }
        toast.show();
    }

    public String getText(TextView v) {
        return v.getText().toString().trim();
    }


    public void showPro() {

        dialogProgress.show();

    }

    public void hidePro() {

        dialogProgress.dismiss();

    }

}
