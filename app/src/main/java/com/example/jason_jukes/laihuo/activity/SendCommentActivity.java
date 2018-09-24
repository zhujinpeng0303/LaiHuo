package com.example.jason_jukes.laihuo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class SendCommentActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_comment)
    EditText etComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_comment);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        tvStatusBarName.setText("信息市场");

    }

    @OnClick({R.id.rl_back, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_commit:
                showToast("确认");
                break;
        }
    }
}
