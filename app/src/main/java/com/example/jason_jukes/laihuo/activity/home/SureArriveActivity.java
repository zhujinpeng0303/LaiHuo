package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/28 0028.
 */

public class SureArriveActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_top_text)
    TextView tvTopText;
    @InjectView(R.id.et_open_door_password)
    EditText etOpenDoorPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_arrive);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {
        tvStatusBarName.setText("确认到达");
        tvTopText.setText("上门服务时,必须向业主索取开门密码,进行到达签到!");
    }

    @OnClick({R.id.rl_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_sure:

                if (TextUtils.isEmpty(getText(etOpenDoorPassword))) {
                    showToast("请输入开门验证码");
                    return;
                }

                showToast("确认");

                break;
        }
    }
}
