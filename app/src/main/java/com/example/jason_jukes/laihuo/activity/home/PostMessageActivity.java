package com.example.jason_jukes.laihuo.activity.home;

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
 * 作者：Jason_Jukes on 2018/9/28 0028 11:43
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class PostMessageActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_post)
    EditText etPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_message);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        tvStatusBarName.setText("发布信息");
    }

    @OnClick({R.id.rl_back, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                break;
            case R.id.tv_commit:
                break;
        }
    }
}
