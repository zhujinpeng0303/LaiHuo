package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MessageMarketLVAdapter;
import com.example.jason_jukes.laihuo.bean.MessageMarketBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.XListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/23 0023.
 */

public class MessageMarketActivity extends BaseActivity implements XListView.IXListViewListener {
    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    XListView lv;

    private MessageMarketLVAdapter adapter;
    private List<MessageMarketBean.DataObjBean.RtListBean> been = new ArrayList<>();
    private List<MessageMarketBean.DataObjBean.RtListBean> been1 = new ArrayList<>();

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_market);
        ButterKnife.inject(this);
        initView();
//        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        page = 1;
        been.clear();
        initData();
    }

    private void initView() {

        tvStatusBarName.setText("信息市场");

        lv.setPullRefreshEnable(true);
        lv.setPullLoadEnable(true);
        lv.setAutoLoadEnable(false);
        lv.setXListViewListener(this);
        lv.setRefreshTime(getTime());

        been = new ArrayList<>();
        adapter = new MessageMarketLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_message_market_lv, null);
        lv.addFooterView(footerView, null, false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MessageMarketActivity.this, MessageDetailActivity.class)
                        .putExtra("id", been.get(i - 1).getId() + ""));
            }
        });

    }

    private void initData() {


        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
//            ref.setRefreshing(true);
            lv.setPullRefreshEnable(true);
            getData();
        } else {
            showToast("请检查网络设置");

        }
    }


    @Override
    public void onRefresh() {

        page = 1;
        lv.setPullRefreshEnable(true);
        lv.setPullLoadEnable(true);
        onResume();

    }

    @Override
    public void onLoadMore() {

        page++;
        been1.clear();
        lv.setPullLoadEnable(true);
        loadData();

    }

    private void loadData() {

        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", SPTool.getInstance().getShareDataStr(Contants.USER_ID));
        map.put("token", "gggg");
        map.put("page", page + "");
        map.put("rows", "10");
        XUtil.Post(Contants.MESSAGE_MARKET, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageMarketBean bean = new Gson().fromJson(result, MessageMarketBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataObj().getRtList().size() > 0) {

                        for (int i = 0; i < bean.getDataObj().getRtList().size(); i++) {

                            been1.add(bean.getDataObj().getRtList().get(i));

                        }
                        adapter.addBeen1(been1);
                    } else {
                        showToast("没有数据了");
                        lv.setPullLoadEnable(false);
                    }

                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
//                ref.setRefreshing(false);
                onLoad();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();
                onLoad();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    private void getData() {

        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", SPTool.getInstance().getShareDataStr(Contants.USER_ID));
        map.put("token", "gggg");
        map.put("page", page + "");
        map.put("rows", "10");
        XUtil.Post(Contants.MESSAGE_MARKET, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageMarketBean bean = new Gson().fromJson(result, MessageMarketBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataObj().getRtList().size(); i++) {

                        been.add(bean.getDataObj().getRtList().get(i));

                    }

                    adapter.notifyDataSetChanged();

                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
                onLoad();
//                ref.setRefreshing(false);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();
                onLoad();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @OnClick({R.id.rl_back, R.id.tv_post_message, R.id.tv_mine_part})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_post_message:
                startIntent(PostMessageActivity.class);
                break;
            case R.id.tv_mine_part:
                startIntent(MyPartakeMessageActivity.class);
                break;
        }
    }

    private void onLoad() {
        lv.stopRefresh();
        lv.stopLoadMore();
//        lv.setPullRefreshEnable(false);
//        lv.setPullLoadEnable(false);
        lv.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }


}
