package com.example.jason_jukes.laihuo.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IdCardUtil;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 15:24
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class BindCardDialog {

    private Context context;
    private AlertDialog dialog;
    private boolean flag = false;
    private int time = 60;
    private TextView tvGetCode;

    private EditText et_num, et_name, et_card, et_phone, et_code;
    private TextView tv_ok;

    public BindCardDialog(Context context) {
        this.context = context;
    }

    public void commonDialog() {

        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        dialog = adb.create();
        View view = LayoutInflater.from(context).inflate(R.layout.bind_card_dailog_view, null);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setView(view);

        et_num = view.findViewById(R.id.et_card_num);
        et_name = view.findViewById(R.id.et_real_name);
        et_card = view.findViewById(R.id.et_id_num);
        et_phone = view.findViewById(R.id.et_phone);
        et_code = view.findViewById(R.id.et_code);
        tvGetCode = view.findViewById(R.id.tv_get_code);

        tv_ok = view.findViewById(R.id.tv_commit);
        TextView tv_cancel = view.findViewById(R.id.tv_cancel);

        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取验证码

                if (!StringUtil.isMobileNo(et_phone.getText().toString())) {
                    Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }

                codeState();

            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(et_num.getText().toString())) {
                    Toast.makeText(context, "请输入银行卡号", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!StringUtil.checkBankCard(et_num.getText().toString())) {
                    Toast.makeText(context, "银行卡号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_name.getText().toString())) {
                    Toast.makeText(context, "请输入真实姓名", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (new IdCardUtil(et_card.getText().toString()).isCorrect() != 0) {
                    Toast.makeText(context, "身份证号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!StringUtil.isMobileNo(et_phone.getText().toString())) {
                    Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(et_code.getText().toString())) {
                    Toast.makeText(context, "请输入短信验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                tv_ok.setClickable(false);
                post();
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }

    private void post() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("bank_code", et_num.getText().toString());
        map.put("user_name", et_name.getText().toString());
        map.put("id_card", et_card.getText().toString());
        map.put("phoneno", et_phone.getText().toString());
        map.put("sms_code", et_code.getText().toString());
        map.put("code_type", "bindIdcard");


        XUtil.Post(Contants.BIND_CARD, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                AddressBean bean = new Gson().fromJson(result, AddressBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    Toast.makeText(context, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    SPTool.getInstance().setShareData(Contants.CARD_STATUS,"1");
                } else {
                    Toast.makeText(context, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
                }

                tv_ok.setClickable(true);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                tv_ok.setClickable(true);

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }


    //验证码倒计时

    public void codeState() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    time--;
                    try {
                        Thread.sleep(1000);
                        tvGetCode.post(new Runnable() {
                            @Override
                            public void run() {
                                tvGetCode.setText(time + "s后重新获取");
                                tvGetCode.setClickable(false);
//                                tvGetCode.setTextSize(13);
//                                tvGetCode.setTextColor(Color.parseColor("#5a5a5a"));

                            }
                        });

                        if (time <= 1) {
                            flag = false;
                            tvGetCode.post(new Runnable() {
                                @Override
                                public void run() {
                                    tvGetCode.setText("获取短信验证码");
                                    tvGetCode.setClickable(true);
//                                    tvGetCode.setTextSize(11);
//                                    tvGetCode.setTextColor(Color.parseColor("#5a5a5a"));
                                }
                            });

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = true;
                time = 60;
            }
        }).start();

    }


}
