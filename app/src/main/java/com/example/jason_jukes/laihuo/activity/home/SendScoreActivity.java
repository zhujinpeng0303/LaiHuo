package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.RatingBar;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/28 0028.
 */

public class SendScoreActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.ratingBar_all)
    RatingBar ratingBarAll;
    @InjectView(R.id.tv_score_desc)
    TextView tvScoreDesc;
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
    @InjectView(R.id.et_evaluate)
    EditText etEvaluate;

    private String all = "4", jishi = "4", zhiliang = "4", attitude = "4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_score);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        tvStatusBarName.setText("评分");

        ratingBarAll.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                all = Math.round(ratingCount) + "";
                tvScoreDesc.setText(Math.round(ratingCount) + " 分 比较满意,服务周到");
            }
        });

        ratingBarJishi.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                tvScoreJishi.setText(Math.round(ratingCount) + " 分");
                jishi = Math.round(ratingCount) + "";

            }
        });

        ratingBarZhiliang.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                tvScoreZhiliang.setText(Math.round(ratingCount) + " 分");
                zhiliang = Math.round(ratingCount) + "";

            }
        });

        ratingBarAttitude.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                tvScoreAttitude.setText(Math.round(ratingCount) + " 分");
                attitude = Math.round(ratingCount) + "";

            }
        });

    }

    @OnClick({R.id.rl_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_sure:
                showProgressDialog();
                sendScore();
                break;
        }
    }

    private void sendScore() {

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));
        map.put("ranking_quick", jishi);
        map.put("ranking_quality", zhiliang);
        map.put("ranking_attitude",attitude);
        map.put("ranking_last", all);
        map.put("ranking_text", getText(etEvaluate));


        XUtil.Post(Contants.SEND_RANKING, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    finish();

                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
