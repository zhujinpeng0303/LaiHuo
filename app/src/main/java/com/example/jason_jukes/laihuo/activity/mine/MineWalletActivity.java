package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MineWalletLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 11:36
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineWalletActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private MineWalletLVAdapter adapter;
    private List<String> been;
    private TextView tv_yue;

    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_wallet);
        ButterKnife.inject(this);
        initView();
        initdata();
    }

    private void initView() {
        tvStatusBarName.setText("我的钱包");
        headerView = LayoutInflater.from(context).inflate(R.layout.header_lv_mine_wallet, null);
        tv_yue = headerView.findViewById(R.id.tv_yue);
        headerView.findViewById(R.id.tv_withdraw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(MineWithdrawActivity.class);
            }
        });

        lv.addHeaderView(headerView);

        been = new ArrayList<>();
        been.add("0");
        been.add("1");
        been.add("1");
        been.add("0");
        adapter = new MineWalletLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setVerticalScrollBarEnabled(false);

    }


    private void initdata() {
    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
