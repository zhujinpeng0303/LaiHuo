package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.FindWorkLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/25 0025.
 */

public class FindWorkActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_fenlei)
    TextView tvFenlei;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_work_status)
    TextView tvWorkStatus;
    @InjectView(R.id.lv)
    ListView lv;

    private List<String> been = new ArrayList<>();
    private FindWorkLVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_work);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {

        tvStatusBarName.setText("找活干");

        been = new ArrayList<>();
        been.add("道理-瓦匠");
        been.add("道外-砖工");
        been.add("南岗-砌砖");
        been.add("群力-装卸工");
        been.add("平房-力工");

        adapter = new FindWorkLVAdapter(this,been);
        lv.setAdapter(adapter);

    }

    private void initData() {

    }

    @OnClick({R.id.rl_back, R.id.ll_fenlei, R.id.ll_work_status})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_fenlei:
                break;
            case R.id.ll_work_status:
                break;
        }
    }
}
