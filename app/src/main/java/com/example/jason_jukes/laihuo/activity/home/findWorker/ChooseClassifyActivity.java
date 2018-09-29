package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.ClassifyExpLVAdapter;

import java.util.ArrayList;
import java.util.List;

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

    private List<String> groups;
    private List<List<String>> items;

    private List<String> itemList, itemList1;

    private ClassifyExpLVAdapter adapter;
    private View headerView;

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

        expLv.addHeaderView(headerView);

        groups = new ArrayList<>();
        groups.add("分类1");
        groups.add("分类2");
        groups.add("分类3");
        groups.add("分类4");
//        groups.add("分类3");

        itemList = new ArrayList<>();
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        itemList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");

        items = new ArrayList<>();
        items.add(itemList);
        items.add(itemList);
        items.add(itemList);
        items.add(itemList);


        adapter = new ClassifyExpLVAdapter(this, groups, items);
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

    }

    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finish();
    }
}
