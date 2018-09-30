package com.example.jason_jukes.laihuo.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.AddressManagerLVAdapter;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
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

public class AddressManageActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;

    private List<AddressBean.DataArrBean> been;
    private AddressManagerLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();

        been.clear();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("地址管理");

        been = new ArrayList<>();
        adapter = new AddressManagerLVAdapter(this, been);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class)
                        .putExtra("name", been.get(i).getUsername())
                        .putExtra("phone", been.get(i).getTel())
                        .putExtra("place", been.get(i).getArea_name_top() + "-" + been.get(i).getArea_name())
                        .putExtra("address", been.get(i).getAddress())
                        .putExtra("id", been.get(i).getId())
                        .putExtra("type", "change")
                );

            }
        });

    }

    private void initData() {
        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getAddress();
        } else {
            showToast("请检查网络设置");

        }
    }

    private void getAddress() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("city_id", "236");

        XUtil.Post(Contants.MY_ADDRESS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                AddressBean bean = new Gson().fromJson(result, AddressBean.class);
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

    @OnClick({R.id.rl_back, R.id.tv_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_add_address:
                startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class)
                        .putExtra("type", "add"));
                break;
        }
    }


}
