package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MineQualificationLVAdapter;
import com.example.jason_jukes.laihuo.bean.MineQuaBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.XUtil;
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
    @InjectView(R.id.ll_null)
    LinearLayout llNull;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;

    private View headerView;

    private List<MineQuaBean.DataArrBean> been = new ArrayList<>();
    private MineQualificationLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_qualification);
        ButterKnife.inject(this);
        initView();
//        initData();
    }

    private void initView() {
        tvStatusBarName.setText("我的资历");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_top_text, null);
        ((TextView) headerView.findViewById(R.id.tv_top_text)).setText("您的资历信息会被其他用户看到,完善您的资历信息会提高您的接单率哦");


        lv.addHeaderView(headerView, null, false);

//        been = new ArrayList<>();
//        adapter = new MineQualificationLVAdapter(this, been, "yes");
//        lv.setAdapter(adapter);
        lv.setVerticalScrollBarEnabled(false);

        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onResume();
            }
        });


        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                boolean enable = false;
                if (lv != null && lv.getChildCount() > 0) {
                    // check if the first item of the list is visible
                    boolean firstItemVisible = lv.getFirstVisiblePosition() == 0;
                    // check if the top of the first item is visible
                    boolean topOfFirstItemVisible = lv.getChildAt(0).getTop() == 0;
                    // enabling or disabling the refresh layout
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                ref.setEnabled(enable);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        been = new ArrayList<>();
        adapter = new MineQualificationLVAdapter(this, been, "yes");
        lv.setAdapter(adapter);
        initData();
    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            ref.setRefreshing(true);
            getData();
        } else {
            showToast("请检查网络设置");

        }

    }

    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");


        XUtil.Post(Contants.MINE_QUALIFICATION, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MineQuaBean bean = new Gson().fromJson(result, MineQuaBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataArr().size() > 0) {
                        llNull.setVisibility(View.GONE);


                        for (int i = 0; i < bean.getDataArr().size(); i++) {

                            been.add(bean.getDataArr().get(i));

                        }

                        adapter.notifyDataSetChanged();
                    } else {
                        llNull.setVisibility(View.VISIBLE);
                    }
                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
                ref.setRefreshing(false);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
//                hideProgressDialog();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @OnClick({R.id.rl_back, R.id.tv_add_qualification, R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_add_qualification:
                startIntent(AddQualificationActivity.class);
                break;
            case R.id.tv_add:
                startIntent(AddQualificationActivity.class);
                break;
        }
    }

}
