package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.WebviewActivity;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/7 0007.
 */

public class ApplyPriceActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_jiage_type)
    TextView tvJiageType;
    @InjectView(R.id.tv_jiage)
    TextView tvJiage;
    @InjectView(R.id.tv_work_time)
    TextView tvWorkTime;
    @InjectView(R.id.et_price)
    EditText etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_price);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        tvStatusBarName.setText("申请报价");
        tvJiage.setText(getIntent().getStringExtra("jiage"));
        tvWorkTime.setText(getIntent().getStringExtra("time"));

    }

    @OnClick({R.id.rl_back, R.id.tv_shenqing, R.id.tv_biaozhun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_shenqing:
                if (TextUtils.isEmpty(getText(etPrice))) {
                    showToast("请输入预估价格");
                    return;
                }
                showProgressDialog();
                applyPrice();
                break;
            case R.id.tv_biaozhun:
                startActivity(new Intent(ApplyPriceActivity.this, WebviewActivity.class)
                        .putExtra("url", Contants.XINZI_BIAOZHUN));
                break;
        }
    }

    private void applyPrice() {

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));
        map.put("price_min", getText(etPrice));
        map.put("price_max", getText(etPrice));

        XUtil.Post(Contants.APPLY_PRICE, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    finish();
                } else {
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
}
