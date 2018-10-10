package com.example.jason_jukes.laihuo.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.PersonalHomeActivity;
import com.example.jason_jukes.laihuo.adapter.MineFocusListLVAdapter;
import com.example.jason_jukes.laihuo.bean.FocusBean;
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
 * Created by Administrator on 2018/9/24 0024.
 */

public class MineFocusListActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;
    @InjectView(R.id.ll_null)
    LinearLayout llNull;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;

    private List<FocusBean.DataObjBean.RtListBean> been;
    private MineFocusListLVAdapter adapter;
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_focus_list);
        ButterKnife.inject(this);
        initView();
//        initData();
    }

    private void initView() {

        if (getIntent().getStringExtra("type").equals("focus")) {
            tvStatusBarName.setText("我的关注列表");
            url = Contants.MINE_FOCUS;
        } else {
            tvStatusBarName.setText("我的粉丝列表");
            url = Contants.MINE_FANS;
        }

        been = new ArrayList<>();
        adapter = new MineFocusListLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (getIntent().getStringExtra("type").equals("focus")) {
                    startActivity(new Intent(MineFocusListActivity.this, PersonalHomeActivity.class)
                            .putExtra("id", been.get(i).getTo_user_id() + ""));
                } else {
                    startActivity(new Intent(MineFocusListActivity.this, PersonalHomeActivity.class)
                            .putExtra("id", been.get(i).getFrom_user_id() + ""));
                }
            }
        });


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
        been.clear();
        initData();
        super.onResume();
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
//        map.put("city_id", "236");

        XUtil.Post(url, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                FocusBean bean = new Gson().fromJson(result, FocusBean.class);
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
                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                }else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
                ref.setRefreshing(false);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();
                ref.setRefreshing(false);

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
