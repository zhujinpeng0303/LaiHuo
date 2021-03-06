package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.LoginBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

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
    @InjectView(R.id.et_img_code)
    EditText etImgCode;
    @InjectView(R.id.iv_img_code)
    ImageView ivImgCode;

    private boolean flag = true, rbFlag = true;
    private int time = 60;
    private String ran = "";

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

        ran = StringUtil.getRandom(32);
        String updateTime = String.valueOf(System.currentTimeMillis());
        RequestOptions options = new RequestOptions().signature(new ObjectKey(updateTime));
        Glide.with(this).load(Contants.GET_IMG_CODE + "?imageId=" + ran).apply(options).into(ivImgCode);

    }

    @OnClick({R.id.rl_back, R.id.tv_get_code, R.id.tv_yaoqingma, R.id.rl_rb, R.id.tv_xieyi1, R.id.tv_xieyi2, R.id.tv_xieyi3, R.id.tv_register, R.id.iv_img_code})
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

                if (TextUtils.isEmpty(getText(etImgCode))) {
                    showToast("请输入图形验证码");
                    return;
                }

                getCode();


                break;

            case R.id.iv_img_code:

                ran = StringUtil.getRandom(32);
                String updateTime = String.valueOf(System.currentTimeMillis());
                RequestOptions options = new RequestOptions().signature(new ObjectKey(updateTime));
                Glide.with(this).load(Contants.GET_IMG_CODE + "?imageId=" + ran).apply(options).into(ivImgCode);

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

                if (TextUtils.isEmpty(getText(etImgCode))) {
                    showToast("请输入图形验证码");
                    return;
                }

                if (TextUtils.isEmpty(getText(etCode))) {
                    showToast("请输入短信验证码");
                    return;
                }

                register();

                break;
        }
    }


    private void register() {

        Map<String, Object> map = new HashMap<>();
        map.put("phoneno", getText(etPhone));
        map.put("code_type", "app_reg");
        map.put("sms_code", getText(etCode));
        map.put("referee_user_code", getText(etYaoqingCode));

        XUtil.Post(Contants.REGISTER, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result", result);

                LoginBean bean = new Gson().fromJson(result, LoginBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());

                    SPTool.getInstance().setShareData(Contants.USER_ID, bean.getDataObj().getToken());
                    finish();

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                }else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void getCode() {

        Map<String, Object> map = new HashMap<>();
        map.put("phoneno", getText(etPhone));
        map.put("code_type", "app_reg");
        map.put("imageId", ran);
        map.put("imageCode", getText(etImgCode));


        XUtil.Post(Contants.APP_CODE, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());
                    codeState();

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                }else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();

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
