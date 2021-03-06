package com.example.jason_jukes.laihuo.activity.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.BindCardActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneCertificationActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
import com.example.jason_jukes.laihuo.adapter.ClassifyExpLVAdapter;
import com.example.jason_jukes.laihuo.adapter.FindWorkLVAdapter;
import com.example.jason_jukes.laihuo.bean.ClassifyBean;
import com.example.jason_jukes.laihuo.bean.FindWorkBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.ClassifyPopupWindow;
import com.example.jason_jukes.laihuo.view.CommonDialog;
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
 * Created by Administrator on 2018/9/25 0025.
 */

public class FindWorkActivity extends BaseActivity implements XListView.IXListViewListener {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_fenlei)
    TextView tvFenlei;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_work_status)
    TextView tvWorkStatus;
    @InjectView(R.id.lv)
    XListView lv;
    @InjectView(R.id.ll_null)
    LinearLayout llNull;
    @InjectView(R.id.rootView)
    LinearLayout rootView;

    private List<FindWorkBean.DataObjBean.RtListBean> been = new ArrayList<>();
    private List<FindWorkBean.DataObjBean.RtListBean> been1 = new ArrayList<>();
    private FindWorkLVAdapter adapter;
    private String classifyId = "";

    private List<ClassifyBean.DataArrBean> groups = new ArrayList<>();
    private List<List<ClassifyBean.DataArrBean.ChildsBean>> items = new ArrayList<>();

    private PopupWindow popupWindow;
    private ClassifyPopupWindow classifyPopupWindow;
    private View popView, headerView;
    private ImageView close;
    private RelativeLayout rl_all;
    private ExpandableListView expandableListView;

    private ClassifyExpLVAdapter.itemClick itemClick;

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_work);
        ButterKnife.inject(this);
        initView();
        initData();
        initWorkStatus();
    }


    private void initWorkStatus() {

        if (SPTool.getInstance().getShareDataStr(Contants.SHANGBAN).equals("1")) {

            tvWorkStatus.setText("我要下班");
            Drawable img = context.getResources().getDrawable(R.mipmap.img_mine_work_status_yes);
            img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
            tvWorkStatus.setCompoundDrawables(img, null, null, null);

        } else {

            tvWorkStatus.setText("我要上班");
            Drawable img = context.getResources().getDrawable(R.mipmap.img_mine_work_status_no);
            img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
            tvWorkStatus.setCompoundDrawables(img, null, null, null);

        }

    }

    private void initView() {


        tvStatusBarName.setText("找活干");

        lv.setPullRefreshEnable(true);
        lv.setPullLoadEnable(true);
        lv.setAutoLoadEnable(false);
        lv.setXListViewListener(this);
        lv.setRefreshTime(getTime());


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(FindWorkActivity.this, WorkDetailActivity.class)
                        .putExtra("id", been.get(i - 1).getId() + "")
                        .putExtra("type", been.get(i - 1).getOrder_type()));
            }
        });

        popView = LayoutInflater.from(this).inflate(R.layout.popup_window_choose_classify, null);
        expandableListView = popView.findViewById(R.id.exp_lv);
        close = popView.findViewById(R.id.iv_close);
        headerView = LayoutInflater.from(context).inflate(R.layout.header_classify_explv, null);
        rl_all = headerView.findViewById(R.id.rl_all);

        expandableListView.addHeaderView(headerView);

        getCalssify();


    }


    private void initData() {
        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
//            ref.setRefreshing(true);
//            been.clear();
//            groups.clear();
//            items.clear();
            been = new ArrayList<>();
            adapter = new FindWorkLVAdapter(this, been);
            lv.setAdapter(adapter);

            page = 1;
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
        initData();

    }

    @Override
    public void onLoadMore() {

        been1.clear();
        page++;
        lv.setPullLoadEnable(true);
        loadData();

    }


    private void getCalssify() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("id", "0");

        XUtil.Post(Contants.GET_CLASSIFY, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                ClassifyBean bean = new Gson().fromJson(result, ClassifyBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataArr().size(); i++) {

                        groups.add(bean.getDataArr().get(i));

                        List<ClassifyBean.DataArrBean.ChildsBean> childs = new ArrayList<ClassifyBean.DataArrBean.ChildsBean>();

                        for (int i1 = 0; i1 < bean.getDataArr().get(i).getChilds().size(); i1++) {

                            childs.add(bean.getDataArr().get(i).getChilds().get(i1));

                        }

                        items.add(childs);

                    }

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());
                }

//                hideProgressDialog();

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

    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("base_user_certification_classify_id", classifyId);
        map.put("page", page + "");
        map.put("rows", "10");

        Log.e("map", map.toString());

        XUtil.Post(Contants.FIND_WORK, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                FindWorkBean bean = new Gson().fromJson(result, FindWorkBean.class);
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
//                ref.setRefreshing(false);
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


    private void loadData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("base_user_certification_classify_id", classifyId);
        map.put("page", page + "");
        map.put("rows", "10");

        Log.e("map", map.toString());

        XUtil.Post(Contants.FIND_WORK, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                FindWorkBean bean = new Gson().fromJson(result, FindWorkBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataObj().getRtList().size() > 0) {
                        llNull.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getDataObj().getRtList().size(); i++) {

                            been1.add(bean.getDataObj().getRtList().get(i));

                        }

                        adapter.addBeen1(been1);

                    } else {
                        showToast("没有数据了");
                        lv.setPullLoadEnable(false);
                    }
                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
//                ref.setLoading(false);
                onLoad();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();
//                ref.setLoadMoreEnabled(false);
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


    @OnClick({R.id.rl_back, R.id.ll_fenlei, R.id.ll_work_status})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_fenlei:

                itemClick = new ClassifyExpLVAdapter.itemClick() {
                    @Override
                    public void ItemClick(int pos, int p) {

                        classifyId = items.get(pos).get(p).getId() + "";
                        tvName.setText(groups.get(pos).getCertification_classify_name() + "-" + items.get(pos).get(p).getCertification_classify_name());
                        initData();
                        popupWindow.dismiss();
                    }
                };

                final ClassifyExpLVAdapter adapter = new ClassifyExpLVAdapter(this, groups, items, itemClick);
                expandableListView.setAdapter(adapter);

                for (int i = 0; i < groups.size(); i++) {
                    expandableListView.expandGroup(i);
                }

                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                        return true;
                    }
                });

                popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                classifyPopupWindow = new ClassifyPopupWindow(FindWorkActivity.this, popupWindow);

                popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);

                rl_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        classifyId = "";
                        tvName.setText("全部分类");
                        initData();
                        popupWindow.dismiss();
                    }
                });

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                break;
            case R.id.ll_work_status:

                if (SPTool.getInstance().getShareDataStr(Contants.PHONE_STATUS).equals("0")) {
                    bindPhone();
                    return;
                }
                if (SPTool.getInstance().getShareDataStr(Contants.CARD_STATUS).equals("0")) {
                    bindCard();
                    return;
                }

                if (SPTool.getInstance().getShareDataStr(Contants.SHANGBAN).equals("0")) {
                    shangban();
                } else {
                    xiaban();
                }

                break;
        }
    }


    private void xiaban() {
        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "开启下班状态后,系统将清空您的实时位置信息,您将在附近的能人列表中消失", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                work("0");

                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void shangban() {

        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "开启上班状态后,系统将获取您的实时位置,以便系统为您推荐任务单并且您将出现在附近的能人列表中", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                work("1");

                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void work(final String status) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("is_worker", status);

        XUtil.Post(Contants.SHANGBAN_STATUS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());

                    SPTool.getInstance().setShareData(Contants.SHANGBAN, status);
                    initWorkStatus();
                    initData();

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
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


    private void bindCard() {

        CommonDialog commonDialog = new CommonDialog(context);
        commonDialog.commonDialog("提示", "您还没有进行绑卡开户,还不能进行上下班操作!", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {
                startIntent(BindCardActivity.class);
                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void bindPhone() {

        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.commonDialog("提示", "您还没有进行手机认证,还不能进行上下班操作!", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {
                startIntent(PhoneCertificationActivity.class);
                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }


    private void onLoad() {
        lv.stopRefresh();
        lv.stopLoadMore();
        lv.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }


}
