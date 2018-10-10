package com.example.jason_jukes.laihuo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.MessageDetailActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
import com.example.jason_jukes.laihuo.adapter.MessageMarketLVAdapter;
import com.example.jason_jukes.laihuo.bean.MessageMarketBean;
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

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 11:55
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MyPartakeMessageFragment extends BaseFragment {

    @InjectView(R.id.lv)
    ListView lv;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;
    private MessageMarketLVAdapter adapter;
    private List<MessageMarketBean.DataObjBean.RtListBean> been;

    private View view;

    private String url = "";

    public static Fragment createFragment(String url, String sign) {
        Fragment fragment = new MyPartakeMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("sign", sign);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_partake_work, container, false);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;

    }

    private void initView() {

        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                been.clear();
                initData();
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

    private void initData() {

        Bundle bundle = getArguments();
        url = bundle.getString("url");

        been = new ArrayList<>();
        adapter = new MessageMarketLVAdapter(context, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

//        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_message_market_lv, null);
//        lv.addFooterView(footerView);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(context, MessageDetailActivity.class)
                        .putExtra("id", been.get(i).getId()));
            }
        });

        if (IsNetWork.isNetWork(context)) {
            showPro();
            ref.setRefreshing(true);
            getData();
        } else {
            showToast("请检查网络设置");
        }

    }

    private void getData() {
        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", SPTool.getInstance().getShareDataStr(Contants.USER_ID));
        map.put("token", "gggg");
        XUtil.Post(url, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageMarketBean bean = new Gson().fromJson(result, MessageMarketBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataObj().getRtList().size(); i++) {

                        been.add(bean.getDataObj().getRtList().get(i));

                    }

                    adapter.notifyDataSetChanged();

                }else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());
                }

                hidePro();
                ref.setRefreshing(false);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hidePro();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
