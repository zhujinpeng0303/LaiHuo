package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.App;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.AddAddressActivity;
import com.example.jason_jukes.laihuo.activity.mine.AddressManageActivity;
import com.example.jason_jukes.laihuo.adapter.AddressManagerLVAdapter;
import com.example.jason_jukes.laihuo.bean.AddressBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
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
 * 作者：Jason_Jukes on 2018/9/27 0027 12:00
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkAddressActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;
    private List<AddressBean.DataArrBean> been;
    private AddressManagerLVAdapter adapter;

    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_address);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {

        tvStatusBarName.setText("发布");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_find_post_exp, null);
        TextView title = headerView.findViewById(R.id.tv_title);
        ImageView iv1 = headerView.findViewById(R.id.iv1);
        ImageView iv2 = headerView.findViewById(R.id.iv2);
        ImageView iv3 = headerView.findViewById(R.id.iv3);

        title.setText("第三步·请选择服务地址");
        iv1.setBackgroundResource(R.mipmap.img_dui);
        iv2.setBackgroundResource(R.mipmap.img_dui);
        iv3.setBackgroundResource(R.mipmap.img_three_choose);

        lv.addHeaderView(headerView,null,false);

        been = new ArrayList<>();
        adapter = new AddressManagerLVAdapter(this, been);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Singleton.instance.setAddress_id(been.get(i - 1).getId() + "");
                Singleton.instance.setAddress(been.get(i - 1).getArea_name_top() + "-" + been.get(i - 1).getArea_name());
                Singleton.instance.setDetailAddress(been.get(i - 1).getAddress() + "");
                Singleton.instance.setName(been.get(i - 1).getUsername() + "");
                Singleton.instance.setPhone(been.get(i - 1).getTel() + "");

                startIntent(SurePostActivity.class);
                App.addDestoryActivity(WorkAddressActivity.this,"address");

            }
        });

    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getAddress();
        }else {
            showToast("请检查网络设置");

        }
    }


    private void getAddress() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("city_id", "1");

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

                startActivity(new Intent(WorkAddressActivity.this, AddAddressActivity.class)
                        .putExtra("type", "add"));
                break;
        }
    }
}
