package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.FeedbackActivity;
import com.example.jason_jukes.laihuo.adapter.MineEvaluateLVAdapter;
import com.example.jason_jukes.laihuo.adapter.MineQualificationLVAdapter;
import com.example.jason_jukes.laihuo.adapter.PostWorkLVAdapter;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.bean.MineEvaluateBean;
import com.example.jason_jukes.laihuo.bean.MineQuaBean;
import com.example.jason_jukes.laihuo.bean.PersonHomeBean;
import com.example.jason_jukes.laihuo.bean.PostWorkBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.ClassifyPopupWindow;
import com.example.jason_jukes.laihuo.view.RatingBar;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
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
    @InjectView(R.id.tv_score_all)
    TextView tvScoreAll;
    @InjectView(R.id.tv_score_jishi)
    TextView tvScoreJishi;
    @InjectView(R.id.tv_score_zhiliang)
    TextView tvScoreZhiliang;
    @InjectView(R.id.tv_score_attitude)
    TextView tvScoreAttitude;
    @InjectView(R.id.ll_pingjia_null)
    LinearLayout llPingjiaNull;
    @InjectView(R.id.ll_zizhi_null)
    LinearLayout llZizhiNull;
    //    @InjectView(R.id.tv_top_card_status)
//    TextView tvTopCardStatus;
//    @InjectView(R.id.tv_top_phone_status)
//    TextView tvTopPhoneStatus;
    @InjectView(R.id.tv_focus)
    TextView tvFocus;
    @InjectView(R.id.lv_pingjia)
    ListView lvPingjia;
    @InjectView(R.id.lv_zizhi)
    ListView lvZizhi;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;
    @InjectView(R.id.rootView)
    RelativeLayout rootView;
    @InjectView(R.id.tv_invist)
    TextView tvInvist;

    private RatingBar ratingBarAll, ratingBarJishi, ratingBarZhiliang, ratingBarAttitude;

    private MineEvaluateLVAdapter evaluateLVAdapter;
    private MineQualificationLVAdapter qualificationLVAdapter;

    private List<MineEvaluateBean.DataObjBean.RtListBean> pingjiaBeen;
    private List<MineQuaBean.DataArrBean> zizhiBeen;

    private int focusStatus = 0;

    private PopupWindow popupWindow;
    private ClassifyPopupWindow classifyPopupWindow;
    private View popView;
    private ImageView close;
    private ListView lv;
    private TextView cancel;
    private LinearLayout ll_null;

    private List<PostWorkBean.DataArrBean> been;
    private PostWorkLVAdapter adapter;


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

        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pingjiaBeen.clear();
                zizhiBeen.clear();
                initData();
            }
        });

        popView = LayoutInflater.from(this).inflate(R.layout.popup_window_mine_post, null);
        lv = popView.findViewById(R.id.lv);
        close = popView.findViewById(R.id.iv_close);
        cancel = popView.findViewById(R.id.tv_cancel);
        ll_null = popView.findViewById(R.id.ll_null);

        been = new ArrayList<>();
        adapter = new PostWorkLVAdapter(context, been);
        lv.setAdapter(adapter);


    }

    private void initData() {
        ratingBarAll = findViewById(R.id.ratingBar_all);
        ratingBarJishi = findViewById(R.id.ratingBar_jishi);
        ratingBarZhiliang = findViewById(R.id.ratingBar_zhiliang);
        ratingBarAttitude = findViewById(R.id.ratingBar_attitude);

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            ref.setRefreshing(true);
            getData();
            getWork();
        } else {
            showToast("请检查网络设置");
        }
    }


    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("work_user_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.SEE_OTHER_HOME, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                PersonHomeBean bean = new Gson().fromJson(result, PersonHomeBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    Glide.with(PersonalHomeActivity.this).load(bean.getDataObj().getHead_url()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(ivAvatar);

                    if (bean.getDataObj().getIsMySubscribe() == 0) {
                        tvFocus.setText("关注TA");
                        tvFocus.setBackgroundResource(R.drawable.bg_blue_big_corner);
                        focusStatus = 0;
                    } else {
                        tvFocus.setText("取消关注");
                        tvFocus.setBackgroundResource(R.drawable.bg_grey_big_corner);
                        focusStatus = 1;
                    }

//                    if (bean.getDataObj().getMerid() == null) {
//                        tvTopCardStatus.setText("未开户");
//                        tvTopCardStatus.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
//                    } else {
//                        tvTopCardStatus.setText("已开户");
//                        tvTopCardStatus.setBackgroundResource(R.drawable.bg_grey_alpha_corner);
//                    }
//
//                    if (bean.getDataObj().getPhoneno() == null) {
//                        tvTopPhoneStatus.setText("未认证");
//                        tvTopPhoneStatus.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
//                    } else {
//                        tvTopPhoneStatus.setText("已认证");
//                        tvTopPhoneStatus.setBackgroundResource(R.drawable.bg_grey_alpha_corner);
//                    }

                    tvGuanzhu.setText(bean.getDataObj().getNum_subscribe() + "");
                    tvScore.setText(bean.getDataObj().getRanking_last() + "");
                    tvFans.setText(bean.getDataObj().getNum_funs() + "");

                    String score = bean.getDataObj().getRanking_text();
                    ratingBarAll.setStar(Float.valueOf(StringUtil.splitStr(score).get(0)));
                    ratingBarJishi.setStar(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(1)));
                    ratingBarZhiliang.setStar(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(2)));
                    ratingBarAttitude.setStar(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(3)));

                    tvScoreAll.setText(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(0)) + "分");
                    tvScoreJishi.setText(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(1)) + "分");
                    tvScoreZhiliang.setText(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(2)) + "分");
                    tvScoreAttitude.setText(Float.valueOf(StringUtil.splitStr(bean.getDataObj().getRanking_text()).get(3)) + "分");


                    pingjiaBeen = new ArrayList<MineEvaluateBean.DataObjBean.RtListBean>();

                    for (int i = 0; i < bean.getDataObj().getRankingList().size(); i++) {

                        pingjiaBeen.add(bean.getDataObj().getRankingList().get(i));
                    }

                    if (bean.getDataObj().getRankingList().size() > 0) {
                        llPingjiaNull.setVisibility(View.GONE);
//                        pingjiaBeen.addAll(bean.getDataObj().getRankingList());
                        evaluateLVAdapter = new MineEvaluateLVAdapter(PersonalHomeActivity.this, pingjiaBeen);
                        lvPingjia.setAdapter(evaluateLVAdapter);
                        setListViewHeightBasedOnChildren(lvPingjia);
                    } else {
                        llPingjiaNull.setVisibility(View.VISIBLE);
                    }

                    zizhiBeen = new ArrayList<MineQuaBean.DataArrBean>();
                    for (int i = 0; i < bean.getDataObj().getUserCustomCertList().size(); i++) {

                        zizhiBeen.add(bean.getDataObj().getUserCustomCertList().get(i));

                    }

                    if (bean.getDataObj().getUserCustomCertList().size() > 0) {
                        llZizhiNull.setVisibility(View.GONE);
                        qualificationLVAdapter = new MineQualificationLVAdapter(PersonalHomeActivity.this, zizhiBeen, "no");
                        lvZizhi.setAdapter(qualificationLVAdapter);
                        setListViewHeightBasedOnChildren(lvZizhi);
                    } else {
                        llZizhiNull.setVisibility(View.VISIBLE);
                    }

                } else {
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

    private void getWork() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("order_status", "1");

        XUtil.Post(Contants.MINE_POST_WORK, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                PostWorkBean bean = new Gson().fromJson(result, PostWorkBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    if (bean.getDataArr().size() > 0) {
                        ll_null.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getDataArr().size(); i++) {

                            been.add(bean.getDataArr().get(i));

                        }

                        adapter.notifyDataSetChanged();

                    } else {
                        ll_null.setVisibility(View.VISIBLE);
                    }
                } else {
                    showToast(bean.getErrorMsg());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void focus() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("to_user_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.FOCUS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());
                    tvFocus.setText("取消关注");
                    tvFocus.setBackgroundResource(R.drawable.bg_grey_big_corner);
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

    private void cancelFocus() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("to_user_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.CANCEL_FOCUS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());
                    tvFocus.setText("关注TA");
                    tvFocus.setBackgroundResource(R.drawable.bg_blue_big_corner);
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


    @OnClick({R.id.rl_back, R.id.tv_invist, R.id.tv_focus, R.id.tv_jubao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_invist:

                popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                classifyPopupWindow = new ClassifyPopupWindow(PersonalHomeActivity.this, popupWindow);

                popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        showToast(been.get(i).getId() + "");

                        invist(popupWindow, been.get(i).getId() + "");

                    }
                });

                break;
            case R.id.tv_focus:
                if (focusStatus == 0) {
                    focus();
                } else {
                    cancelFocus();
                }
                break;
            case R.id.tv_jubao:
                startActivity(new Intent(PersonalHomeActivity.this, FeedbackActivity.class)
                        .putExtra("type", "user"));
                break;
        }
    }

    private void invist(final PopupWindow popupWindow, String order_id) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("order_id", order_id);
        map.put("to_user_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.MY_ADDRESS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    popupWindow.dismiss();

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


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        try {
            // 获取ListView对应的Adapter
            ListAdapter listAdapter = listView.getAdapter();
            if (listAdapter == null) {
                return;
            }

            int totalHeight = 0;
            for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
                // listAdapter.getCount()返回数据项的数目
                View listItem = listAdapter.getView(i, null, listView);
                // 计算子项View 的宽高
                listItem.measure(0, 0);
                // 统计所有子项的总高度
                totalHeight += listItem.getMeasuredHeight();
            }

            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
            // listView.getDividerHeight()获取子项间分隔符占用的高度
            // params.height最后得到整个ListView完整显示需要的高度
            listView.setLayoutParams(params);
        } catch (Exception e) {

        }
    }


}
