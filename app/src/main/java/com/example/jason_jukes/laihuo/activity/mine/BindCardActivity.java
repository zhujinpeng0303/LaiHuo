package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IdCardUtil;
import com.example.jason_jukes.laihuo.tool.LimitTextWatcher;
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
 * Created by Administrator on 2018/9/24 0024.
 */

public class BindCardActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_card_num)
    EditText etCardNum;
    @InjectView(R.id.et_real_name)
    EditText etRealName;
    @InjectView(R.id.et_id_num)
    EditText etIdNum;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.et_code)
    EditText etCode;
    @InjectView(R.id.tv_get_code)
    TextView tvGetCode;
    @InjectView(R.id.tv_cancel)
    TextView tvCancel;
    private int time = 60;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_card);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        tvStatusBarName.setText("绑卡开户");
        tvCancel.setVisibility(View.GONE);
        etRealName.addTextChangedListener(new LimitTextWatcher(getText(etRealName), etRealName));

    }

    @OnClick({R.id.rl_back, R.id.tv_get_code, R.id.tv_commit})
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

                getCode();

                break;
            case R.id.tv_commit:

                if (TextUtils.isEmpty(getText(etCardNum))) {
                    showToast("请输入银行卡号");
                    return;
                }

                if (!StringUtil.checkBankCard(getText(etCardNum))) {
                    showToast("银行卡号格式不正确");
                    return;
                }

                if (TextUtils.isEmpty(getText(etRealName))) {
                    showToast("请输入真实姓名");
                    return;
                }

                if (new IdCardUtil(getText(etIdNum)).isCorrect() != 0) {
                    showToast("身份证号格式不正确");
                    return;
                }

                if (!StringUtil.isMobileNo(getText(etPhone))) {
                    showToast("手机号格式不正确");
                    return;
                }


                if (TextUtils.isEmpty(getText(etCode))) {
                    showToast("请输入短信验证码");
                    return;
                }

                bindCard();

                break;
        }
    }

    private void bindCard() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("bank_code", getText(etCardNum));
        map.put("user_name", getText(etRealName));
        map.put("id_card", getText(etIdNum));
        map.put("phoneno", getText(etPhone));
        map.put("sms_code", getText(etCode));
        map.put("code_type", "bindIdcard");

        XUtil.Post(Contants.BIND_CARD, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    SPTool.getInstance().setShareData(Contants.CARD_STATUS,"1");

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
        map.put("token", "gggg");
        map.put("phoneno", getText(etPhone));
        map.put("code_type", "bindIdcard");

        XUtil.Post(Contants.GET_CODE, map, new Callback.CommonCallback<String>() {
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
