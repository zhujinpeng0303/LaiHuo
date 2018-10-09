package com.example.jason_jukes.laihuo.activity.home;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.FeedbackActivity;
import com.example.jason_jukes.laihuo.adapter.MineEvaluateLVAdapter;
import com.example.jason_jukes.laihuo.adapter.WorkDetailGridViewAdapter;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.bean.MineEvaluateBean;
import com.example.jason_jukes.laihuo.bean.PersonHomeBean;
import com.example.jason_jukes.laihuo.bean.WorkDetailBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.BindCardDialog;
import com.example.jason_jukes.laihuo.view.ClassifyPopupWindow;
import com.example.jason_jukes.laihuo.view.CommonDialog;
import com.example.jason_jukes.laihuo.view.MyGridView;
import com.example.jason_jukes.laihuo.view.RatingBar;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 08:41
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDetailActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_jiage_status)
    TextView tvJiageStatus;
    @InjectView(R.id.tv_post_time)
    TextView tvPostTime;
    @InjectView(R.id.tv_work_kind)
    TextView tvWorkKind;
    @InjectView(R.id.tv_work_address)
    TextView tvWorkAddress;
    @InjectView(R.id.tv_jiage_type)
    TextView tvJiageType;
    @InjectView(R.id.tv_jiage)
    TextView tvJiage;
    @InjectView(R.id.tv_work_time)
    TextView tvWorkTime;
    @InjectView(R.id.tv_shenqing)
    TextView tvShenqing;
    @InjectView(R.id.tv_kejian)
    TextView tvKejian;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.tv_detail_address)
    TextView tvDetailAddress;
    @InjectView(R.id.ll_work_address)
    LinearLayout llWorkAddress;
    @InjectView(R.id.rl_work_address)
    RelativeLayout rlWorkAddress;
    @InjectView(R.id.ll_zhuizong)
    LinearLayout llZhuizong;
    @InjectView(R.id.tv_work_desc)
    TextView tvWorkDesc;
    @InjectView(R.id.rl_luyin)
    RelativeLayout rlLuyin;
    @InjectView(R.id.ll_img)
    LinearLayout llImg;
    @InjectView(R.id.gridView)
    MyGridView gridView;
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
    @InjectView(R.id.tv_evaluate)
    TextView tvEvaluate;
    @InjectView(R.id.iv_zhiding_avatar)
    ImageView ivZhidingAvatar;
    @InjectView(R.id.tv_zhiding_name)
    TextView tvZhidingName;
    @InjectView(R.id.tv_zhiding_score)
    TextView tvZhidingScore;
    @InjectView(R.id.tv_zhiding_phone)
    TextView tvZhidingPhone;
    @InjectView(R.id.tv_zhiding_jiage_status)
    TextView tvZhidingJiageStatus;
    @InjectView(R.id.rootView)
    LinearLayout rootView;
    @InjectView(R.id.iv_play)
    ImageView ivPlay;
    @InjectView(R.id.tv_cancel)
    TextView tvCancel;
    @InjectView(R.id.ll_pingjia)
    LinearLayout llPingjia;
    @InjectView(R.id.ll_kaimen_mima)
    LinearLayout llKaimenMima;
    @InjectView(R.id.ll_yi_zhiding)
    LinearLayout llYiZhiding;
    @InjectView(R.id.ll_jing_jia_list)
    LinearLayout llJingJiaList;
    @InjectView(R.id.ll_service_address)
    LinearLayout llServiceAddress;
    @InjectView(R.id.tv_zhuyi)
    TextView tvZhuyi;
    @InjectView(R.id.ll_renwu_zhuizong)
    LinearLayout llRenwuZhuizong;
    @InjectView(R.id.tv_zhiding_money)
    TextView tvZhidingMoney;
    @InjectView(R.id.tv_mima1)
    TextView tvMima1;
    @InjectView(R.id.tv_mima2)
    TextView tvMima2;
    @InjectView(R.id.tv_mima3)
    TextView tvMima3;
    @InjectView(R.id.tv_mima4)
    TextView tvMima4;
    @InjectView(R.id.tv_yugu_price)
    TextView tvYuguPrice;
    @InjectView(R.id.tv_jiedan_tishi)
    TextView tvJiedanTishi;
    @InjectView(R.id.ll_jiedan_message)
    LinearLayout llJiedanMessage;
    @InjectView(R.id.iv_service_call)
    ImageView ivServiceCall;
    @InjectView(R.id.ll_null)
    LinearLayout llNull;
    @InjectView(R.id.ll_content)
    LinearLayout llContent;


    private WorkDetailGridViewAdapter adapter;
    private List<WorkDetailBean.DataObjBean.GetWorkerBidListBean> been = new ArrayList<>();
    private List<WorkDetailBean.DataObjBean.OrderRecordListBean> recordBeen = new ArrayList<>();

    private String status = "", type = "";   //type 判断是一口价还是还价
    private WorkDetailGridViewAdapter.moreClick moreClick;
    private WorkDetailGridViewAdapter.phoneClick phoneClick;

    private PopupWindow popupWindow;
    private ClassifyPopupWindow classifyPopupWindow;
    private View popView;

    private ImageView iv_avatar, avatar;
    private TextView tv_score, tv_phone, tv_cancel, tv_xuanze, tv_money, tv_name, name, score, content, date;
    private LinearLayout ll_detail_more, ll_detail_zuizhong, ll_null, ll_evaluate, ll_pingjia;
    private RelativeLayout rl_user;

    private MineEvaluateLVAdapter evaAdapter;
    private List<MineEvaluateBean.DataObjBean.RtListBean> evaBeen = new ArrayList<>();

    private MediaPlayer mPlayer = new MediaPlayer();

    private boolean isPlaying = false;

    private String luyin = "";

    private String zhidingUserId = "", zhidingPhone = "", servicePhone = "", listPhone = "", callType = "";    //callType  判断是制定电话  还是列表电话

    private String quanxian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_detail);
        ButterKnife.inject(this);
        initView();
//        initData();
    }

    private void initView() {
        tvStatusBarName.setText("详情");
        type = getIntent().getStringExtra("type");

        llJiedanMessage.setVisibility(View.GONE);
        llPingjia.setVisibility(View.GONE);
        llKaimenMima.setVisibility(View.GONE);
        llYiZhiding.setVisibility(View.GONE);
        llJingJiaList.setVisibility(View.GONE);
        tvShenqing.setVisibility(View.GONE);
        tvCancel.setVisibility(View.GONE);
        llServiceAddress.setVisibility(View.GONE);
        llWorkAddress.setVisibility(View.GONE);


    }


    @Override
    protected void onResume() {
        super.onResume();
        been.clear();
        llZhuizong.removeAllViews();
        llImg.removeAllViews();
        initData();
    }

    private void initData() {
        popView = LayoutInflater.from(this).inflate(R.layout.popup_window_worke_detail, null);
        iv_avatar = popView.findViewById(R.id.iv_detail_avatar);
        tv_score = popView.findViewById(R.id.tv_detail_score);
        tv_phone = popView.findViewById(R.id.tv_phone);
        tv_cancel = popView.findViewById(R.id.tv_detail_cancel);
        tv_xuanze = popView.findViewById(R.id.tv_detail_xuanze);
        tv_money = popView.findViewById(R.id.tv_detail_money);
        tv_name = popView.findViewById(R.id.tv_detail_name);


        ll_detail_more = popView.findViewById(R.id.ll_detail_more);
        ll_detail_zuizhong = popView.findViewById(R.id.ll_detail_zuizong);
        ll_null = popView.findViewById(R.id.ll_null);
        ll_evaluate = popView.findViewById(R.id.ll_evaluate);
        ll_pingjia = popView.findViewById(R.id.ll_pinglun);
        rl_user = popView.findViewById(R.id.rl_user);


        moreClick = new WorkDetailGridViewAdapter.moreClick() {
            @Override
            public void MoreClick(final int pos) {

                showWorkerDetail(pos);

            }
        };

        phoneClick = new WorkDetailGridViewAdapter.phoneClick() {
            @Override
            public void PhoneClick(int pos) {

                callType = "list";
                listPhone = been.get(pos).getPhoneno();
                callPhone(been.get(pos).getPhoneno());

            }
        };

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getData();
        } else {
            showToast("请检查网络设置");

        }

    }

    //竞价列表投资者选择或者邀请输入价格
    private void postChoose(String url, String bid) {

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));
        map.put("bid_id", bid);
        map.put("token", "gggg");

        Log.e("uuuuu", url);

        XUtil.Post(url, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    popupWindow.dismiss();
                    onResume();
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

    private void showWorkerDetail(final int pos) {

        showProgressDialog();
        evaBeen.clear();
        ll_pingjia.removeAllViews();

        getUserPinglun(been.get(pos).getBid_user_id() + "");

        String url = "";

        Glide.with(WorkDetailActivity.this)
                .load(been.get(pos).getHead_url())
                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                .into(iv_avatar);
        tv_name.setText(been.get(pos).getUsername());
        tv_score.setText(been.get(pos).getRanking_last());
        tv_phone.setText(been.get(pos).getPhoneno());

        if (been.get(pos).getBid_status() == 0) {
            tv_xuanze.setText("请TA输入最终报价");
            tv_xuanze.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
            ll_detail_zuizhong.setVisibility(View.GONE);
            url = Contants.PLEASE_INPUT_PRICE;
        } else if (been.get(pos).getBid_status() == 1) {
            tv_xuanze.setText("选择TA");
            tv_xuanze.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
            ll_detail_zuizhong.setVisibility(View.VISIBLE);
            tv_money.setText("最终报价: " + been.get(pos).getBid_price_last() + "元");
            url = Contants.CHOOSE_IT;
        } else if (been.get(pos).getBid_status() == 2) {
            tv_xuanze.setText("等待TA输入最终价格");
            tv_xuanze.setBackgroundResource(R.drawable.bg_et_grey_corner);
            tv_xuanze.setClickable(false);
            ll_detail_zuizhong.setVisibility(View.GONE);
        }

        rl_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkDetailActivity.this, PersonalHomeActivity.class)
                        .putExtra("id", been.get(pos).getBid_user_id() + ""));
            }
        });

        ll_detail_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkDetailActivity.this, PersonalHomeActivity.class)
                        .putExtra("id", been.get(pos).getBid_user_id() + ""));
            }
        });

        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        classifyPopupWindow = new ClassifyPopupWindow(WorkDetailActivity.this, popupWindow);
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        final String finalUrl = url;
        tv_xuanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showProgressDialog();
                postChoose(finalUrl, been.get(pos).getBid_user_id() + "");

            }
        });

    }

    //获取弹出框用户的评价
    private void getUserPinglun(String id) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("work_user_id", id);

        Log.e("map", map.toString());

        XUtil.Post(Contants.SEE_OTHER_HOME, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                PersonHomeBean bean = new Gson().fromJson(result, PersonHomeBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataObj().getRankingList().size() > 0) {
                        ll_null.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getDataObj().getRankingList().size(); i++) {

                            evaBeen.add(bean.getDataObj().getRankingList().get(i));

                        }

                        for (int i = 0; i < evaBeen.size(); i++) {

                            if (i > 2) {

                            } else {
                                View v = LayoutInflater.from(context).inflate(R.layout.item_worker_evaluate_lv, null);
                                avatar = v.findViewById(R.id.iv_avatar);
                                name = v.findViewById(R.id.tv_name);
                                score = v.findViewById(R.id.tv_score);
                                content = v.findViewById(R.id.tv_content);
                                date = v.findViewById(R.id.tv_time);

                                Glide.with(context).load(evaBeen.get(i)
                                        .getHead_url())
                                        .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context)))
                                        .into(avatar);
                                name.setText(evaBeen.get(i).getUsername());
                                score.setText(evaBeen.get(i).getRanking_last() + "");
                                content.setText(evaBeen.get(i).getRanking_text());
                                date.setText(evaBeen.get(i).getCreate_time_text());

                                ll_pingjia.addView(v);
                            }
                        }

                    } else {
                        ll_null.setVisibility(View.VISIBLE);
                        ll_detail_more.setVisibility(View.GONE);
                    }
                } else {
                    ll_detail_more.setVisibility(View.GONE);
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

    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("order_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.ORDER_DETAIL, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                final WorkDetailBean bean = new Gson().fromJson(result, WorkDetailBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    tvTitle.setText(bean.getDataObj().getOrderDetail().getOrder_title());
                    tvJiageStatus.setText(bean.getDataObj().getOrderDetail().getOrder_status_text());
                    tvPostTime.setText("发布时间: " + bean.getDataObj().getOrderDetail().getCreate_time_day() + " " + bean.getDataObj().getOrderDetail().getCreate_time_second());
                    tvWorkKind.setText(bean.getDataObj().getOrderBase().getBase_user_certification_classify_name());
                    tvWorkAddress.setText(bean.getDataObj().getOrderBase().getBase_area_name());

                    if (TextUtils.isEmpty(bean.getDataObj().getOrderDetail().getOrder_desc_sounds())) {
                        rlLuyin.setVisibility(View.GONE);
                    } else {
                        rlLuyin.setVisibility(View.VISIBLE);
                        luyin = Contants.URL_BASE + bean.getDataObj().getOrderDetail().getOrder_desc_sounds();
                    }

                    if (bean.getDataObj().getOrderType().equals("talk_price")) {
                        tvJiageType.setText("心理预期价格");
                        tvJiage.setTextColor(getResources().getColor(R.color.colorBlack));
                        if (TextUtils.isEmpty(bean.getDataObj().getOrderBase().getOrder_price_range())) {
                            tvJiage.setText("面议");
                        } else {
                            tvJiage.setText(bean.getDataObj().getOrderBase().getOrder_price_range() + "元");
                        }
                    } else if (bean.getDataObj().getOrderType().equals("fixed_price")) {
                        tvJiageType.setText("服务一口价");
                        tvJiage.setTextColor(getResources().getColor(R.color.red));
                        if (TextUtils.isEmpty(bean.getDataObj().getOrderBase().getOrder_price())) {
                            tvJiage.setText("面议");
                        } else {
                            tvJiage.setText(bean.getDataObj().getOrderBase().getOrder_price() + "元");
                        }

                    }
                    if (TextUtils.isEmpty(bean.getDataObj().getOrderDetail().getMust_arrive_date())) {
                        tvWorkTime.setText("面议");
                    } else {
                        tvWorkTime.setText(bean.getDataObj().getOrderDetail().getMust_arrive_date() + " " + bean.getDataObj().getOrderDetail().getMust_arrive_time());

                    }

                    tvWorkKind.setText(bean.getDataObj().getOrderBase().getBase_user_certification_classify_name());
                    tvWorkKind.setText(bean.getDataObj().getOrderBase().getBase_user_certification_classify_name());

                    for (int i = 0; i < bean.getDataObj().getOrderRecordList().size(); i++) {

                        View v = LayoutInflater.from(context).inflate(R.layout.item_ll_view, null);
                        TextView tv = v.findViewById(R.id.tv_name);
                        TextView time = v.findViewById(R.id.tv_time);
                        tv.setText(bean.getDataObj().getOrderRecordList().get(i).getRecord_content());
                        time.setText(bean.getDataObj().getOrderRecordList().get(i).getCreate_time_text());

                        llZhuizong.addView(v);

                    }


                    int dimension = (int) getResources().getDimension(R.dimen.x50);
                    int dimension1 = (int) getResources().getDimension(R.dimen.y20);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    String str = bean.getDataObj().getOrderDetail().getOrder_desc_pics();
                    String[] arr = str.split(",");//分割字符串得到数组
                    List<String> list = Arrays.asList(arr);//字符数组转list
                    List<String> imgs = new ArrayList<>();
                    for (int i1 = 0; i1 < list.size(); i1++) {
                        imgs.add(Contants.URL_IMG_BASE + list.get(i1));
                    }

                    for (int i = 0; i < imgs.size(); i++) {

                        ImageView imageView = new ImageView(WorkDetailActivity.this);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setPadding(dimension, 0, dimension, dimension);
                        imageView.setLayoutParams(params);
                        Glide.with(context).load(imgs.get(i)).into(imageView);

                        llImg.addView(imageView);

                    }

                    tvWorkDesc.setText(bean.getDataObj().getOrderDetail().getOrder_desc());

                    if (!bean.getDataObj().getUserRole().equals("worker")) {
                        ivServiceCall.setBackgroundResource(0);
                        ivServiceCall.setClickable(false);
                    }


                    status = bean.getDataObj().getShowType();

                    showToast(status);

                    //以下判断为可还价和一口价都有的订单的判断  到if ordertype  判断为止

                    if (status.equals("creator.orderCancel")) {                       //creator.orderCancel 创建者 取消订单 Q1
                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());


                    }

                    if (status.equals("worker.orderCancel")) {                       //worker.orderCancel 工作者  取消订单 Q3
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.GONE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);

                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                    }


                    if (status.equals("creator.waiPayDeposit")) {   //创建者，待支付押金 ①  (去支付押金（顶部显示文字不需要换行） 关闭订单)

                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.GONE);
                        llRenwuZhuizong.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.VISIBLE);
                        tvZhuyi.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        tvShenqing.setText("去支付押金");

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, PayDepositActivity.class)
                                        .putExtra("money", bean.getDataObj().getOrderBase().getOrder_price_range()));      //暂时不知道传哪个值
                            }
                        });

                        tvCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showDia(Contants.ORDER_CANCEL_XUNJIA);
                            }
                        });

                    }

                    if (status.equals("creator.waitSelectUser")) {                   //创建者，待选择工人 ② (没有满意的？去邀请更多人出价， 关闭订单)


                        //可还价返回该值的判断
                        if (bean.getDataObj().getOrderType().equals("talk_price")) {

                            llJiedanMessage.setVisibility(View.GONE);
                            llPingjia.setVisibility(View.GONE);
                            llKaimenMima.setVisibility(View.GONE);
                            llYiZhiding.setVisibility(View.GONE);
                            tvShenqing.setVisibility(View.VISIBLE);
                            tvCancel.setVisibility(View.VISIBLE);
                            llJingJiaList.setVisibility(View.VISIBLE);
                            llServiceAddress.setVisibility(View.VISIBLE);
                            llWorkAddress.setVisibility(View.VISIBLE);


                            String idCount = "";

                            for (int i = 0; i < bean.getDataObj().getGetWorkerBidList().size(); i++) {
                                been.add(bean.getDataObj().getGetWorkerBidList().get(i));
                                idCount += bean.getDataObj().getGetWorkerBidList().get(i).getBid_status() + "";
                            }


                            adapter = new WorkDetailGridViewAdapter(WorkDetailActivity.this, been, moreClick, phoneClick);
                            gridView.setAdapter(adapter);

                            if (StringUtil.countStr(idCount, "1") == 1) {

                                showWorkerDetail(idCount.indexOf("1"));

                            }

                            servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                            tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                            tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                            tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                            tvShenqing.setText("没有满意的?去邀请更多人出价");
                            tvShenqing.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startIntent(NearbyPersonActivity.class);
                                }
                            });

                            tvCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    showDia(Contants.ORDER_CANCEL_XUNJIA);
                                }
                            });

                            //一口价返回该值的判断
                        } else if (bean.getDataObj().getOrderType().equals("fixed_price")) {

                            llJiedanMessage.setVisibility(View.GONE);
                            llPingjia.setVisibility(View.GONE);
                            llKaimenMima.setVisibility(View.GONE);
                            llYiZhiding.setVisibility(View.GONE);
                            llJingJiaList.setVisibility(View.GONE);
                            tvShenqing.setVisibility(View.VISIBLE);
                            tvCancel.setVisibility(View.VISIBLE);
                            llServiceAddress.setVisibility(View.VISIBLE);
                            llWorkAddress.setVisibility(View.VISIBLE);


                            servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                            tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                            tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                            tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                            tvShenqing.setText("没有满意的?去邀请更多人出价");
                            tvShenqing.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startIntent(NearbyPersonActivity.class);
                                }
                            });

                            tvCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    showDia(Contants.ORDER_CANCEL_YIKOUJIA);
                                }
                            });

                        }

                    }

                    if (status.equals("creator.waitPay")) {                                    //创建者，待支付订单 ③ （预支付服务费）

                        //可还价返回该值的判断
                        if (bean.getDataObj().getOrderType().equals("talk_price")) {
                            llJiedanMessage.setVisibility(View.GONE);
                            llPingjia.setVisibility(View.GONE);
                            llKaimenMima.setVisibility(View.GONE);
                            llJingJiaList.setVisibility(View.GONE);
                            tvShenqing.setVisibility(View.VISIBLE);
                            tvCancel.setVisibility(View.GONE);
                            llYiZhiding.setVisibility(View.VISIBLE);
                            llServiceAddress.setVisibility(View.VISIBLE);
                            llWorkAddress.setVisibility(View.VISIBLE);

                            zhidingPhone = bean.getDataObj().getOrderAddress().getCon_tel();
                            zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                            tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                            tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                            tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                            tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                            Glide.with(WorkDetailActivity.this)
                                    .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                    .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                    .into(ivZhidingAvatar);

                            servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                            tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                            tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                            tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                            tvShenqing.setText("预支付服务费");
                            tvShenqing.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(WorkDetailActivity.this, PayDepositActivity.class)
                                            .putExtra("money", "50"));      //暂时不知道传哪个值
                                }
                            });

//                            tvCancel.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                    showDia(Contants.ORDER_CANCEL_XUNJIA);
//                                }
//                            });


                            //一口价返回该值的判断
                        } else if (bean.getDataObj().getOrderType().equals("fixed_price")) {

                            llJiedanMessage.setVisibility(View.GONE);
                            llPingjia.setVisibility(View.GONE);
                            llKaimenMima.setVisibility(View.GONE);
                            llJingJiaList.setVisibility(View.GONE);
                            tvShenqing.setVisibility(View.VISIBLE);
                            tvCancel.setVisibility(View.VISIBLE);
                            llYiZhiding.setVisibility(View.VISIBLE);
                            llServiceAddress.setVisibility(View.VISIBLE);
                            llWorkAddress.setVisibility(View.VISIBLE);

                            zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                            zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                            tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                            tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                            tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                            tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                            Glide.with(WorkDetailActivity.this)
                                    .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                    .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                    .into(ivZhidingAvatar);

                            servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                            tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                            tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                            tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                            tvShenqing.setText("预支付服务费");
                            tvShenqing.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(WorkDetailActivity.this, PayDepositActivity.class)
                                            .putExtra("money", "50"));      //暂时不知道传哪个值
                                }
                            });

                            tvCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    showDia(Contants.ORDER_CANCEL_YIKOUJIA);
                                }
                            });

                        }
                    }
                    if (status.equals("creator.waitArrivedCode")) {                     //创建者，待工人到达（此时显示开门密码）④
                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.VISIBLE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        tvMima1.setText(String.valueOf(bean.getDataObj().getCodeMap().getDoorCode().charAt(0)));
                        tvMima2.setText(String.valueOf(bean.getDataObj().getCodeMap().getDoorCode().charAt(1)));
                        tvMima3.setText(String.valueOf(bean.getDataObj().getCodeMap().getDoorCode().charAt(2)));
                        tvMima4.setText(String.valueOf(bean.getDataObj().getCodeMap().getDoorCode().charAt(3)));

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                    }
                    if (status.equals("creator.waitWorkerCommit")) {                           //creator.waitWorkerCommit 创建者，等待工人提交工作 ④⑤中间
                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                    }


                    if (status.equals("creator.waitAgree")) {   //创建者，待确认完成工作 ⑤ （确认已完成）
                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        tvShenqing.setText("确认已完成");

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showFinishDialog();
                            }
                        });

                    }
                    if (status.equals("creator.waitRanking")) {   //创建者，待评价工人 ⑥ （去评价）
                        llJiedanMessage.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        tvShenqing.setText("去评价");

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, SendScoreActivity.class)
                                        .putExtra("id", getIntent().getStringExtra("id")));
                            }
                        });

                    }
                    if (status.equals("creator.orderSuccess")) {   //创建者已评价完成 ⑦
                        llJiedanMessage.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.VISIBLE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());


                        ratingBarAll.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_last()));
                        ratingBarJishi.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_quick()));
                        ratingBarZhiliang.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_quality()));
                        ratingBarAttitude.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_attitude()));

                        tvScoreAll.setText(bean.getDataObj().getRankingInfo().getRanking_last() + "分");
                        tvScoreJishi.setText(bean.getDataObj().getRankingInfo().getRanking_quick() + "分");
                        tvScoreZhiliang.setText(bean.getDataObj().getRankingInfo().getRanking_quality() + "分");
                        tvScoreAttitude.setText(bean.getDataObj().getRankingInfo().getRanking_attitude() + "分");
                        tvEvaluate.setText(bean.getDataObj().getRankingInfo().getRanking_text());

                    }
                    if (status.equals("bider.waitBid")) {                               //投标者，待投标 （黑①） （申请报价）

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.GONE);

                        tvShenqing.setText("申请报价");


                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, ApplyPriceActivity.class)
                                        .putExtra("jiage", getText(tvJiage))
                                        .putExtra("time", getText(tvWorkTime))
                                        .putExtra("id", getIntent().getStringExtra("id")));
                            }
                        });

                    }
                    if (status.equals("bider.waitCreatorAgree")) {   //投标者，待创建者允许投标者出最终价 （黑②）

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);


                        tvJiedanTishi.setText("已申请,请等待用户联系您");
                        tvYuguPrice.setText("¥" + bean.getDataObj().getBidDetail().getBid_price_max());


                    }
                    if (status.equals("bider.waitAgreeBid")) {                            //投标者，待出最终价  （黑③） （确认接单价格）

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        tvShenqing.setText("确认接单价格");

                        tvJiedanTishi.setText("请等待用户联系您");
                        tvYuguPrice.setText("¥" + bean.getDataObj().getBidDetail().getBid_price_max());

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, SureOrderActivity.class)
                                        .putExtra("jiage", getText(tvJiage))
                                        .putExtra("time", getText(tvWorkTime))
                                        .putExtra("bid_id", bean.getDataObj().getBidDetail().getId() + ""));
                            }
                        });

                    }
                    if (status.equals("bider.alreadyBid")) {                                     //投标者，已完成投标  （黑④ ）

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);

                        tvJiedanTishi.setText("用户确认后自动开始合作");
                        tvYuguPrice.setText("¥" + bean.getDataObj().getBidDetail().getBid_price_last());

                    }
                    if (status.equals("worker.waitPay")) {                                     //worker.waitPay, 工人等待发单人支付服务费 (黑⑤)

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.GONE);
                        llWorkAddress.setVisibility(View.GONE);
                        llServiceAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                    }

                    if (status.equals("worker.waitArrivedCode")) {                                   //工作者，待到达创建者家里 A （确认到达）
                        llJiedanMessage.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        tvShenqing.setText("确认到达");

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, SureArriveActivity.class)
                                        .putExtra("id", getIntent().getStringExtra("id")));
                            }
                        });

                    }
                    if (status.equals("worker.waitCommit")) {                                    //工作者，待提交工作 B （提交工作）

                        llJiedanMessage.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.VISIBLE);
                        tvCancel.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        tvShenqing.setText("提交工作");

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());

                        tvShenqing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(WorkDetailActivity.this, FindWorkActivity.class));
                            }
                        });

                    }

                    if (status.equals("worker.waitAgree")) {                                    //worker.waitAgree   工人等待发单人确认已完成 B1

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.GONE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());


                    }

                    if (status.equals("worker.waitRanking")) {                                    //worker.waitRanking  工人等待发单人评价 B2

                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.GONE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llJiedanMessage.setVisibility(View.GONE);
                        llWorkAddress.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());


                    }

                    if (status.equals("worker.orderSuccess")) {                            //工作者，已评价完成 C

                        llJiedanMessage.setVisibility(View.GONE);
                        llJingJiaList.setVisibility(View.GONE);
                        llKaimenMima.setVisibility(View.GONE);
                        tvShenqing.setVisibility(View.GONE);
                        tvCancel.setVisibility(View.GONE);
                        llPingjia.setVisibility(View.VISIBLE);
                        llYiZhiding.setVisibility(View.VISIBLE);
                        llServiceAddress.setVisibility(View.VISIBLE);
                        llWorkAddress.setVisibility(View.VISIBLE);

                        zhidingUserId = bean.getDataObj().getWorkUserDetail().getId() + "";
                        zhidingPhone = bean.getDataObj().getWorkUserDetail().getPhoneno();
                        tvZhidingName.setText(bean.getDataObj().getWorkUserDetail().getUsername());
                        tvZhidingPhone.setText(bean.getDataObj().getWorkUserDetail().getPhoneno());
                        tvZhidingScore.setText(bean.getDataObj().getWorkUserDetail().getRanking_last());
                        tvZhidingMoney.setText(bean.getDataObj().getWorkUserDetail().getOrder_price() + "元");
                        Glide.with(WorkDetailActivity.this)
                                .load(bean.getDataObj().getWorkUserDetail().getHead_url())
                                .apply(RequestOptions.bitmapTransform(new GlideCircleTransform(WorkDetailActivity.this)))
                                .into(ivZhidingAvatar);

                        servicePhone = bean.getDataObj().getOrderAddress().getCon_tel();
                        tvName.setText(bean.getDataObj().getOrderAddress().getCon_username());
                        tvPhone.setText(bean.getDataObj().getOrderAddress().getCon_tel());
                        tvDetailAddress.setText(bean.getDataObj().getOrderAddress().getCon_address());


                        ratingBarAll.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_last()));
                        ratingBarJishi.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_quick()));
                        ratingBarZhiliang.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_quality()));
                        ratingBarAttitude.setStar(Float.valueOf(bean.getDataObj().getRankingInfo().getRanking_attitude()));

                        tvScoreAll.setText(bean.getDataObj().getRankingInfo().getRanking_last() + "分");
                        tvScoreJishi.setText(bean.getDataObj().getRankingInfo().getRanking_quick() + "分");
                        tvScoreZhiliang.setText(bean.getDataObj().getRankingInfo().getRanking_quality() + "分");
                        tvScoreAttitude.setText(bean.getDataObj().getRankingInfo().getRanking_attitude() + "分");
                        tvEvaluate.setText(bean.getDataObj().getRankingInfo().getRanking_text());

                    }

                    //一口价订单的判断
                    if (bean.getDataObj().getOrderType().equals("fixed_price")) {

                        if (status.equals("bider.waitFixed")) {                    //bider.waitFixed  立即抢单 黑①（一口价）订单详情新增状态

                            llJingJiaList.setVisibility(View.GONE);
                            llKaimenMima.setVisibility(View.GONE);
                            llPingjia.setVisibility(View.GONE);
                            llYiZhiding.setVisibility(View.GONE);
                            llJiedanMessage.setVisibility(View.GONE);
                            tvShenqing.setVisibility(View.VISIBLE);
                            tvCancel.setVisibility(View.GONE);
                            llServiceAddress.setVisibility(View.VISIBLE);
                            llWorkAddress.setVisibility(View.GONE);

                            tvShenqing.setText("立即抢单");

                            tvShenqing.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    showFixedQiangDan();

                                }
                            });

                        }


                    }

                } else {
                    llNull.setVisibility(View.VISIBLE);
                    llContent.setVisibility(View.GONE);
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


    //一口价抢单dialog
    private void showFixedQiangDan() {

        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "平台会收取成交额的 9% 手续费! 是否接单?", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                fixedQiangDan(dialog);

            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }


    //一口价抢单接口
    private void fixedQiangDan(final AlertDialog dialog) {

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.FIXED_PRICE_GET_ORDER, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    dialog.dismiss();
                    onResume();
                    showSucessDialog();

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

    private void showSucessDialog() {

        CommonDialog commonDialog = new CommonDialog(WorkDetailActivity.this);
        commonDialog.commonDialog("抢单成功", "上门服务时，必须需向业主索取开门密码，点击确认到达按钮，输入开门密码，进行到达签到！", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {
                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {
                dialog.dismiss();
            }
        });

    }


    //确认完成dialog
    private void showFinishDialog() {

        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "确认后我们会将款项转账给工人\n请您确认工人已完成工作\n确认后即表示本单服务结束", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                sureFinish(dialog);

            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    //确认完成接口
    private void sureFinish(final Dialog dialog) {

        Map<String, Object> map = new HashMap<>();
//        map.put("token", "gggg");
        map.put("order_id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.ORDER_SURE_FINISH, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    dialog.dismiss();
                    onResume();

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

    //关闭订单dialog
    private void showDia(final String url) {

        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "关闭订单后,相关费用会在1-3天个工作日退还至账户钱包内!是否关闭订单?", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                cancel(url);

            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    //取消订单
    private void cancel(String url) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("order_id", getIntent().getStringExtra("id"));

//        if (type.equals("fixed_price")) {           //一口价
//            url = Contants.ORDER_CANCEL_YIKOUJIA;
//        } else {                                     //还价
//            url = Contants.ORDER_CANCEL_XUNJIA;
//        }

        XUtil.Post(url, map, new Callback.CommonCallback<String>() {
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

    @OnClick({R.id.rl_back, R.id.tv_shenqing, R.id.tv_cancel, R.id.rl_luyin, R.id.iv_play, R.id.rl_zhiding_avatar, R.id.iv_zhiding_more, R.id.tv_jubao, R.id.iv_service_call})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_shenqing:
                if (SPTool.getInstance().getShareDataStr(Contants.CARD_STATUS).equals("0")) {
                    BindCardDialog dialog = new BindCardDialog(this);
                    dialog.commonDialog();

                    return;
                } else {
                    showToast("申请");
                }
                break;

            case R.id.iv_play:

                if (!isPlaying) {
                    ivPlay.setBackgroundResource(R.mipmap.img_luyin_stop);
                    try {
                        isPlaying = true;
                        mPlayer = new MediaPlayer();
                        mPlayer.setDataSource(luyin);
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                        // 通过异步的方式装载媒体资源
                        mPlayer.prepareAsync();
//                        mPlayer.prepare();
                        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // 装载完毕回调
                                mPlayer.start();
                            }
                        });
//                        mPlayer.prepare();
//                        mPlayer.start();

                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                isPlaying = false;
                                ivPlay.setBackgroundResource(R.mipmap.img_luyin_play);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    MediaPlayer player = new MediaPlayer();
//                    try {
////                        Log.d(TAG, recorder.getFileName());
//                        player.setAudioStreamType(AudioManager.STREAM_RING);
//                        FileInputStream fis = new FileInputStream(new File(luyin));
//                        player.setDataSource(fis.getFD());
//                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                            @Override
//                            public void onCompletion(MediaPlayer mp) {
//                                mp.stop();
//                                mp.release();
//                            }
//                        });
//                        player.setLooping(false);
//                        player.prepare();
//                        player.setVolume(1f, 1f);
//                        player.start();
//                    } catch (IllegalArgumentException e) {
//                        e.printStackTrace();
//                    } catch (SecurityException e) {
//                        e.printStackTrace();
//                    } catch (IllegalStateException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                } else {
                    ivPlay.setBackgroundResource(R.mipmap.img_luyin_play);

                    if (mPlayer != null) {
                        isPlaying = false;
                        mPlayer.pause();
                    }

                }
                break;
            case R.id.rl_zhiding_avatar:

                callType = "zhiding";
                callPhone(zhidingPhone);

                break;
            case R.id.iv_zhiding_more:
                startActivity(new Intent(WorkDetailActivity.this, PersonalHomeActivity.class)
                        .putExtra("id", zhidingUserId));

                break;
            case R.id.iv_service_call:

                callType = "service";
                callPhone(servicePhone);

                break;
            case R.id.tv_jubao:
                startActivity(new Intent(WorkDetailActivity.this, FeedbackActivity.class)
                        .putExtra("type", "work"));
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 原来的敏感操作代码：发短信或者收短信

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);    //url:统一资源定位符    //uri:统一资源标示符（更广）
                    if (callType.equals("zhiding")) {
                        intent.setData(Uri.parse("tel:" + zhidingPhone));
                    } else if (callType.equals("service")) {
                        intent.setData(Uri.parse("tel:" + servicePhone));
                    } else {
                        intent.setData(Uri.parse("tel:" + listPhone));
                    }
                    // 开启系统拨号器
                    startActivity(intent);

                } else {
                    showToast("您拒绝了该权限");
                }
                break;
        }

    }


    private void callPhone(String number) {

        //判断用户是否已经授权
        if (ContextCompat.checkSelfPermission(WorkDetailActivity.this, "Manifest.permission.CALL_PHONE") != PackageManager.PERMISSION_GRANTED) {
            //注意第二个参数没有双引号
            ActivityCompat.requestPermissions(WorkDetailActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

        } else {
            quanxian = "1";
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);    //url:统一资源定位符    //uri:统一资源标示符（更广）
            intent.setData(Uri.parse("tel:" + number));
            // 开启系统拨号器
            startActivity(intent);

        }

    }


}
