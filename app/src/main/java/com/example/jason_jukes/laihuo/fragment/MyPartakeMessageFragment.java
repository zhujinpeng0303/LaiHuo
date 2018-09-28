package com.example.jason_jukes.laihuo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.MessageDetailActivity;
import com.example.jason_jukes.laihuo.activity.home.MessageMarketActivity;
import com.example.jason_jukes.laihuo.adapter.MessageMarketLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 11:55
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MyPartakeMessageFragment extends BaseFragment {

    @InjectView(R.id.lv)
    ListView lv;
    private MessageMarketLVAdapter adapter;
    private List<String> been;
    private List<String> imgList;

    private View view;

    public static Fragment createFragment(String url, String sign) {
        Fragment fragment = new MyPartakeMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("sign", sign);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_partake_work, container, false);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;

    }

    private void initView() {

    }

    private void initData() {

        been = new ArrayList<>();
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        been.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        been.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        been.add("http://a.hiphotos.baidu.com/image/pic/item/574e9258d109b3dee4caf07ac1bf6c81800a4cae.jpg");
        adapter = new MessageMarketLVAdapter(context, been);
        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_message_market_lv, null);
        lv.addFooterView(footerView);

        imgList = new ArrayList<>();
        imgList.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgList.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        imgList.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        imgList.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgList.add("http://a.hiphotos.baidu.com/image/pic/item/574e9258d109b3dee4caf07ac1bf6c81800a4cae.jpg");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(context, MessageDetailActivity.class)
                        .putStringArrayListExtra("list", (ArrayList<String>) been));
            }
        });

    }

}
