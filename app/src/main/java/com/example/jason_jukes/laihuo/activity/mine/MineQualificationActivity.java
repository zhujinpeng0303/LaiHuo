package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MineQualificationLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 14:00
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineQualificationActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private View headerView;

    private List<String> been;
    private MineQualificationLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_qualification);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        tvStatusBarName.setText("我的资历");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_top_text,null);
        ((TextView)headerView.findViewById(R.id.tv_top_text)).setText("您的资历信息会被其他用户看到,完善您的资历信息会提高您的接单率哦");


        lv.addHeaderView(headerView);

        been = new ArrayList<>();
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://a.hiphotos.baidu.com/image/pic/item/574e9258d109b3dee4caf07ac1bf6c81800a4cae.jpg");

        adapter = new MineQualificationLVAdapter(this,been);
        lv.setAdapter(adapter);
        lv.setVerticalScrollBarEnabled(false);



    }

    private void initData() {

    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
