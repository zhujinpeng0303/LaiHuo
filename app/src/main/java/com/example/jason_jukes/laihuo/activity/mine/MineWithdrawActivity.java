package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MineWithdrawLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/28 0028.
 */

public class MineWithdrawActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private View headerView;
    private List<String> been;
    private MineWithdrawLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {

        tvStatusBarName.setText("余额提现");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_withdraw_lv, null);
        final EditText et_money = headerView.findViewById(R.id.et_withdraw_count);
        headerView.findViewById(R.id.tv_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(getText(et_money))) {
                    showToast("请输入提现金额");
                    return;
                }

                showToast("确认");

            }
        });

        headerView.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("取消");
            }
        });

        lv.addHeaderView(headerView);


        been = new ArrayList<>();
        been.add("52");
        been.add("110");
        been.add("445");
        been.add("44");
        been.add("4545");

        adapter = new MineWithdrawLVAdapter(this, been);
        lv.setAdapter(adapter);

    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
