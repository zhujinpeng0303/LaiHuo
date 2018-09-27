package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

    private View headerView;

    private List<String> been;
    private FindWorkLVAdapter adapter;

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

        headerView = LayoutInflater.from(context).inflate(R.layout.header_top_text,null);
        TextView textView = headerView.findViewById(R.id.tv_top_text);
        textView.setText("本页面显示的是您收到的邀请信息,用户在发起订单并支付押金后可以发起邀请,如果您为''下班状态'',用户将无法主动邀请您,可在个人中心页面切换为上班状态!");

        been = new ArrayList<>();
        been.add("道理-瓦匠");
        been.add("道外-砖工");
        been.add("南岗-砌砖");
        been.add("群力-装卸工");
        been.add("平房-力工");

        adapter = new FindWorkLVAdapter(context, been);
        lv.setAdapter(adapter);

        lv.addHeaderView(headerView);

    }

    private void initData() {
    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
    }
}
