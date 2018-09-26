package com.example.jason_jukes.laihuo.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.AddressManagerLVAdapter;

import java.util.ArrayList;
import java.util.List;

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

    private List<String> been;
    private AddressManagerLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("地址管理");

        been = new ArrayList<>();
        been.add("测试");
        been.add("测试12");
        been.add("测试1132321");
        been.add("测试7987234654");

        adapter = new AddressManagerLVAdapter(this, been);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class)
                        .putExtra("name", been.get(i))
                        .putExtra("type", "change")

                );

            }
        });


    }

    private void initData() {
    }

    @OnClick({R.id.rl_back, R.id.tv_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_add_address:
                startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class)
                        .putExtra("type","add"));
                break;
        }
    }


}
