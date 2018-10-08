package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.App;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.ClassifyExpLVAdapter;
import com.example.jason_jukes.laihuo.bean.ClassifyBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.Singleton;
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
 * 作者：Jason_Jukes on 2018/9/26 0026 09:57
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class ChooseClassifyActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.exp_lv)
    ExpandableListView expLv;

    private List<ClassifyBean.DataArrBean> groups;
    private List<List<ClassifyBean.DataArrBean.ChildsBean>> items;

    private ClassifyExpLVAdapter adapter;
    private View headerView;

    private ClassifyExpLVAdapter.itemClick itemClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_classify);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {
        tvStatusBarName.setText("发布");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_find_post_exp, null);

        expLv.addHeaderView(headerView, null, false);

        groups = new ArrayList<>();

//        groups.add("分类3");
        items = new ArrayList<>();

        itemClick = new ClassifyExpLVAdapter.itemClick() {
            @Override
            public void ItemClick(int pos, int p) {

                startActivity(new Intent(context, WorkDescActivity.class));
                SPTool.getInstance().setShareData(Contants.CLASSIFY_ID, items.get(pos).get(p).getId() + "");

                Singleton.instance.setClassify_id(items.get(pos).get(p).getId() + "");
                Singleton.instance.setClassify_name(groups.get(pos).getCertification_classify_name() + "-" + items.get(pos).get(p).getCertification_classify_name() + "");

                App.addDestoryActivity(ChooseClassifyActivity.this, "classify");


            }
        };

        adapter = new ClassifyExpLVAdapter(this, groups, items, itemClick);
        expLv.setAdapter(adapter);

        for (int i = 0; i < groups.size(); i++) {
            expLv.expandGroup(i);
        }

        expLv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return true;
            }
        });

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

                        expLv.expandGroup(i);
                    }
                    adapter.notifyDataSetChanged();

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
