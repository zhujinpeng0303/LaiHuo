package com.example.jason_jukes.laihuo.activity.mine;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.tool.LimitTextWatcher;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.view.CommonDialog;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class AddAddressActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_name)
    EditText etName;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.tv_service_place)
    TextView tvServicePlace;
    @InjectView(R.id.et_detail_address)
    EditText etDetailAddress;
    @InjectView(R.id.tv_del)
    TextView tvDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        if (getIntent().getStringExtra("type").equals("add")) {
            tvStatusBarName.setText("添加地址");
            tvDel.setVisibility(View.GONE);
        } else {
            tvStatusBarName.setText("修改地址");
            tvDel.setVisibility(View.VISIBLE);
            etName.setText(getIntent().getStringExtra("name"));
        }

        etName.addTextChangedListener(new LimitTextWatcher(getText(etName), etName));
    }

    @OnClick({R.id.rl_back, R.id.tv_service_place, R.id.tv_commit, R.id.tv_del})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_service_place:
                break;
            case R.id.tv_commit:

                if (TextUtils.isEmpty(getText(etName))) {
                    showToast("请输入联系人姓名");
                    return;
                }

                if (TextUtils.isEmpty(getText(etPhone))) {
                    showToast("请输入联系人手机号");
                    return;
                }

                if (!StringUtil.isMobileNo(getText(etPhone))) {
                    showToast("手机号格式不正确");
                    return;
                }

                if (TextUtils.isEmpty(getText(tvServicePlace))) {
                    showToast("请选择区域");
                    return;
                }

                if (TextUtils.isEmpty(getText(etDetailAddress))) {
                    showToast("请输入详细地址");
                    return;
                }

                showToast("提交");
                break;
            case R.id.tv_del:

                CommonDialog commonDialog = new CommonDialog(this);
                commonDialog.commonDialog("提示", "确认删除此地址吗?", new CommonDialog.TvClick() {
                    @Override
                    public void okClick(AlertDialog dialog) {

                        showToast("删除");
                        dialog.dismiss();

                    }

                    @Override
                    public void cancelClick(AlertDialog dialog) {

                        dialog.dismiss();

                    }
                });

                break;
        }
    }


}
