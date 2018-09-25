package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MineFocusListLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineFocusListActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private List<String> been;
    private MineFocusListLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_focus_list);
        ButterKnife.inject(this);
        initView();
        inntData();
    }

    private void initView() {

        tvStatusBarName.setText("我的关注列表");

        been = new ArrayList<>();
        been.add("张三");
        been.add("李四");
        been.add("王二毛");
        been.add("王麻子");

        adapter = new MineFocusListLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

    }

    private void inntData() {


    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
