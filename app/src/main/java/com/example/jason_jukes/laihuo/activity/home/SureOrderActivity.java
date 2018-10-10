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
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
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

public class SureOrderActivity extends BaseActivity {

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
        setContentView(R.layout.activity_sure_order);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        tvStatusBarName.setText("确认接单");
        tvJiage.setText(getIntent().getStringExtra("jiage"));
        tvWorkTime.setText(getIntent().getStringExtra("time"));
    }

    @OnClick({R.id.rl_back, R.id.tv_sure, R.id.tv_biaozhun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_sure:

                if (TextUtils.isEmpty(getText(etPrice))) {
                    showToast("请输入最终接单价格");
                    return;
                }

                showProgressDialog();
                sureOrder();

                break;
            case R.id.tv_biaozhun:
                startActivity(new Intent(SureOrderActivity.this, WebviewActivity.class)
                        .putExtra("url", Contants.XINZI_BIAOZHUN));
                break;
        }
    }

    private void sureOrder() {

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));
        map.put("bid_id", getIntent().getStringExtra("bid_id"));
        map.put("last_price", getText(etPrice));

        XUtil.Post(Contants.SURE_ORDER_PRICE, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    finish();
                }else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                }  else {
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
