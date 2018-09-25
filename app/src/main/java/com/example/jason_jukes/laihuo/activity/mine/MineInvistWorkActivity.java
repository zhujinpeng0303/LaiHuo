package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 11:23
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineInvistWorkActivity extends BaseActivity {

    @InjectView(R.id.rl_back)
    RelativeLayout rlBack;
    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_invist_work);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        tvStatusBarName.setText("邀请我的活");
    }

    private void initData() {
    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
    }
}
