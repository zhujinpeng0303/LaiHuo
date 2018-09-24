package com.example.jason_jukes.laihuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.MessageMarketLVAdapter;
import com.example.jason_jukes.laihuo.view.nineImage.Image;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/23 0023.
 */

public class MessageMarketActivity extends BaseActivity {
    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;
    private MessageMarketLVAdapter adapter;
    private List<String> been;
    private List<String> imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_market);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {

        tvStatusBarName.setText("信息市场");

    }

    private void initData() {

        been = new ArrayList<>();
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://a.hiphotos.baidu.com/image/pic/item/574e9258d109b3dee4caf07ac1bf6c81800a4cae.jpg");
        adapter = new MessageMarketLVAdapter(this, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

        imgList = new ArrayList<>();
        imgList.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        imgList.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        imgList.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgList.add("http://a.hiphotos.baidu.com/image/pic/item/574e9258d109b3dee4caf07ac1bf6c81800a4cae.jpg");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MessageMarketActivity.this,MessageDetailActivity.class)
                .putStringArrayListExtra("list", (ArrayList<String>) been));
            }
        });

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
