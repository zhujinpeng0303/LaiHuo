package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.FeedbackLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 15:35
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class FeedbackActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private View headerView;
    private View footerView;
    private EditText et_feedback_content, et_phone;
    private TextView submit;

    private List<String> been;
    private FeedbackLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("平台建议");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_feedback_lv, null);
        footerView = LayoutInflater.from(context).inflate(R.layout.footer_feedback_lv, null);
        et_feedback_content = footerView.findViewById(R.id.et_feedback);
        et_phone = footerView.findViewById(R.id.et_phone);
        submit = footerView.findViewById(R.id.tv_commit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lv.addHeaderView(headerView, null, false);
        lv.addFooterView(footerView, null, false);

        been = new ArrayList<>();
        been.add("异常处理");
        been.add("完善");
        been.add("卡健身房里看见放假");

        adapter = new FeedbackLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setVerticalScrollBarEnabled(false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setPos(i);
            }
        });

    }

    private void initData() {


    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
    }
}
