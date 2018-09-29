package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.tool.StringUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class RegisterActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.et_code)
    EditText etCode;
    @InjectView(R.id.tv_get_code)
    TextView tvGetCode;
    @InjectView(R.id.et_yaoqing_code)
    EditText etYaoqingCode;
    @InjectView(R.id.rb)
    RadioButton rb;
    @InjectView(R.id.tv_register)
    TextView tvRegister;

    private boolean flag = true, rbFlag = true;
    private int time = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {
        tvStatusBarName.setText("免费注册");
        rb.setChecked(false);
        tvRegister.setVisibility(View.GONE);
    }

    @OnClick({R.id.rl_back, R.id.tv_get_code, R.id.tv_yaoqingma, R.id.rl_rb, R.id.tv_xieyi1, R.id.tv_xieyi2, R.id.tv_xieyi3, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_get_code:
                if (!StringUtil.isMobileNo(getText(etPhone))) {
                    showToast("手机号格式不正确");
                    return;
                }

                codeState();
                break;
            case R.id.tv_yaoqingma:
                break;
            case R.id.rl_rb:
                if (rbFlag) {
                    rb.setChecked(true);
                    tvRegister.setVisibility(View.VISIBLE);
                } else {
                    rb.setChecked(false);
                    tvRegister.setVisibility(View.GONE);
                }
                rbFlag = !rbFlag;

                break;
            case R.id.tv_xieyi1:
                break;
            case R.id.tv_xieyi2:
                break;
            case R.id.tv_xieyi3:
                break;
            case R.id.tv_register:
                if (!StringUtil.isMobileNo(getText(etPhone))) {
                    showToast("手机号格式不正确");
                    return;
                }
                if (TextUtils.isEmpty(getText(etCode))) {
                    showToast("请输入短信验证码");
                    return;
                }
                showToast("注册");
                break;
        }
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
