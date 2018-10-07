package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.FeedbackLVAdapter;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.bean.TousuBean;
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
 * 作者：Jason_Jukes on 2018/9/25 0025 15:35
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class FeedbackActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private View headerView;
    private View footerView;
    private EditText et_feedback_content, et_phone;
    private TextView submit;

    private List<TousuBean.DataArrBean> been;
    private FeedbackLVAdapter adapter;

    private String content = "", causeValue = "";
    private String type = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        //分type 加载不同的接口
        if (getIntent().getStringExtra("type").equals("yijian")) {
            tvStatusBarName.setText("平台建议");
        } else if (getIntent().getStringExtra("type").equals("tousu")) {
            tvStatusBarName.setText("平台投诉");
        } else if (getIntent().getStringExtra("type").equals("user")) {
            tvStatusBarName.setText("举报用户");
        }else if (getIntent().getStringExtra("type").equals("work")) {
            tvStatusBarName.setText("举报工单");
        }

        headerView = LayoutInflater.from(context).inflate(R.layout.header_feedback_lv, null);
        footerView = LayoutInflater.from(context).inflate(R.layout.footer_feedback_lv, null);
        et_feedback_content = (EditText) footerView.findViewById(R.id.et_feedback);
        et_phone = (EditText) footerView.findViewById(R.id.et_phone);
        submit = (TextView) footerView.findViewById(R.id.tv_commit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(content)) {
                    showToast("请选择投诉原因");
                    return;
                }

                if (TextUtils.isEmpty(getText(et_feedback_content)) || getText(et_feedback_content).length() < 8) {
                    showToast("反馈内容不能小于8个字,记得说的详细些");
                    return;
                }

                if (getIntent().getStringExtra("type").equals("yijian")) {
                    type = "suggest_tipoff";
                    feedBack(type);

                } else if (getIntent().getStringExtra("type").equals("tousu")) {

                    type = "complain_tipoff";
                    feedBack(type);

                } else if (getIntent().getStringExtra("type").equals("user")) {

                    type = "user_info_tipoff";
                    feedBack(type);

                }else if (getIntent().getStringExtra("type").equals("work")) {

                    type = "work_order_tipoff";
                    feedBack(type);

                }

//                work_order_tipoff（订单详情页-举报工单）


            }
        });

        lv.addHeaderView(headerView, null, false);
        lv.addFooterView(footerView, null, false);

        been = new ArrayList<>();

        adapter = new FeedbackLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setVerticalScrollBarEnabled(false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                RadioButton mRB = (RadioButton) view.findViewById(R.id.rb);
                //每次选择一个item时都要清除所有的状态，防止出现多个被选中
                adapter.clearStates(i - 1);
                mRB.setChecked(adapter.getStates(i - 1));
                //刷新数据，调用getView刷新ListView
                adapter.notifyDataSetChanged();

                content = been.get(i - 1).getName();
                causeValue = been.get(i - 1).getValue();

            }
        });

    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            if (getIntent().getStringExtra("type").equals("yijian")) {
                type = "suggest_tipoff";
                getData(type);

            } else if (getIntent().getStringExtra("type").equals("tousu")) {

                type = "complain_tipoff";
                getData(type);

            } else if (getIntent().getStringExtra("type").equals("user")) {

                type = "user_info_tipoff";
                getData(type);

            }else if (getIntent().getStringExtra("type").equals("work")) {

                type = "work_order_tipoff";
                getData(type);

            }

//                work_order_tipoff（订单详情页-举报工单）user_info_tipoff（查看他人信息-举报用户）

        } else {

            showToast("请检查网络设置");

        }

    }

    private void getData(String type) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("type", type);

        XUtil.Post(Contants.TOUSU_CAUSE_LIST, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                TousuBean bean = new Gson().fromJson(result, TousuBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataArr().size(); i++) {

                        been.add(bean.getDataArr().get(i));

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

    private void feedBack(String type) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("user_tel", getText(et_phone));
        map.put("tipoff_type", type);
        map.put("tipoff_scope", causeValue);
        map.put("tipoff_text", getText(et_feedback_content));

        XUtil.Post(Contants.SEND_TOUSU, map, new Callback.CommonCallback<String>() {
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

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
