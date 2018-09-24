package com.example.jason_jukes.laihuo.activity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineScoreActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.ratingBar)
    com.example.jason_jukes.laihuo.view.RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_score);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {

        ratingBar.setStar(2.4f);


    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
    }
}
