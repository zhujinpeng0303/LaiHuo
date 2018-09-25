package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.view.RatingBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineScoreActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_score);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {

        tvStatusBarName.setText("我的评分");
        ratingBarAll.setStar(2.0f);
        ratingBarJishi.setStar(3.0f);
        ratingBarZhiliang.setStar(4.0f);
        ratingBarAttitude.setStar(5.0f);
        ratingBarAll.setClickable(false);
        ratingBarJishi.setClickable(false);
        ratingBarZhiliang.setClickable(false);
        ratingBarAttitude.setClickable(false);

    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
