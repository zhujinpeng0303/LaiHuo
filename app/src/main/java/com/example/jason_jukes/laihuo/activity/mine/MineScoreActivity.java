package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MessageCommentLVAdapter;
import com.example.jason_jukes.laihuo.adapter.MineEvaluateLVAdapter;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.bean.MineEvaluateBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.RatingBar;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineScoreActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;

    @InjectView(R.id.lv)
    ListView lv;
    private MineEvaluateLVAdapter adapter;
    private View headerView;
    @InjectView(R.id.ll_null)
    LinearLayout llNull;

    private List<MineEvaluateBean.DataObjBean.RtListBean> been;
    private RatingBar ratingBarAll, ratingBarJishi, ratingBarZhiliang, ratingBarAttitude;
    private TextView tvScoreAll, tvScoreJishi, tvScoreZhiliang, tvScoreAttitude;

    private String score = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_score);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("我的评分");

        score = getIntent().getStringExtra("score");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_mine_score, null);
        ratingBarAll = headerView.findViewById(R.id.ratingBar_all);
        ratingBarJishi = headerView.findViewById(R.id.ratingBar_jishi);
        ratingBarZhiliang = headerView.findViewById(R.id.ratingBar_zhiliang);
        ratingBarAttitude = headerView.findViewById(R.id.ratingBar_attitude);

        tvScoreAll = headerView.findViewById(R.id.tv_score_all);
        tvScoreJishi = headerView.findViewById(R.id.tv_score_jishi);
        tvScoreZhiliang = headerView.findViewById(R.id.tv_score_zhiliang);
        tvScoreAttitude = headerView.findViewById(R.id.tv_score_attitude);

        ratingBarAll.setStar(Float.valueOf(StringUtil.splitStr(score).get(0)));
        ratingBarJishi.setStar(Float.valueOf(StringUtil.splitStr(score).get(1)));
        ratingBarZhiliang.setStar(Float.valueOf(StringUtil.splitStr(score).get(2)));
        ratingBarAttitude.setStar(Float.valueOf(StringUtil.splitStr(score).get(3)));

        tvScoreAll.setText(Float.valueOf(StringUtil.splitStr(score).get(0)) + "分");
        tvScoreJishi.setText(Float.valueOf(StringUtil.splitStr(score).get(1)) + "分");
        tvScoreZhiliang.setText(Float.valueOf(StringUtil.splitStr(score).get(2)) + "分");
        tvScoreAttitude.setText(Float.valueOf(StringUtil.splitStr(score).get(3)) + "分");

//        lv.addHeaderView(headerView,"",false);
        lv.addHeaderView(headerView);
        been = new ArrayList<>();
        adapter = new MineEvaluateLVAdapter(this, been);
        lv.setAdapter(adapter);


    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getData();
        } else {
            showToast("请检查网络设置");

        }

    }

    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");

        XUtil.Post(Contants.GET_USER_PINGJIA, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MineEvaluateBean bean = new Gson().fromJson(result, MineEvaluateBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataObj().getRtList().size() > 0) {
                        llNull.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getDataObj().getRtList().size(); i++) {

                            been.add(bean.getDataObj().getRtList().get(i));

                        }

                        adapter.notifyDataSetChanged();

                    } else {
                        llNull.setVisibility(View.VISIBLE);
                    }
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

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }

}
