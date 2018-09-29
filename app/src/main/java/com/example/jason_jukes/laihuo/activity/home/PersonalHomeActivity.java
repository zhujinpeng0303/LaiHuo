package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.RatingBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 15:12
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class PersonalHomeActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.iv_avatar)
    ImageView ivAvatar;
    @InjectView(R.id.tv_guanzhu)
    TextView tvGuanzhu;
    @InjectView(R.id.tv_score)
    TextView tvScore;
    @InjectView(R.id.tv_fans)
    TextView tvFans;
    @InjectView(R.id.ratingBar_all)
    RatingBar ratingBarAll;
    @InjectView(R.id.tv_score_all)
    TextView tvScoreAll;
    @InjectView(R.id.ratingBar_jishi)
    RatingBar ratingBarJishi;
    @InjectView(R.id.tv_score_jishi)
    TextView tvScoreJishi;
    @InjectView(R.id.ratingBar_zhiliang)
    RatingBar ratingBarZhiliang;
    @InjectView(R.id.tv_score_zhiliang)
    TextView tvScoreZhiliang;
    @InjectView(R.id.ratingBar_attitude)
    RatingBar ratingBarAttitude;
    @InjectView(R.id.tv_score_attitude)
    TextView tvScoreAttitude;
    @InjectView(R.id.ll_pingjia_null)
    LinearLayout llPingjiaNull;
    @InjectView(R.id.ll_zizhi_null)
    LinearLayout llZizhiNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_home);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("TA的首页");

    }

    private void initData() {

    }

    @OnClick({R.id.rl_back, R.id.tv_invist, R.id.tv_focus, R.id.tv_jubao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_invist:
                break;
            case R.id.tv_focus:
                break;
            case R.id.tv_jubao:
                break;
        }
    }
}
