package com.example.jason_jukes.laihuo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 09:57
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MinePostWorkFragment extends BaseFragment {

    @InjectView(R.id.lv)
    ListView lv;
    @InjectView(R.id.tv)
    TextView tv;
    private View view;

    public static Fragment createFragment(String url, String sign) {
        Fragment fragment = new MinePostWorkFragment();
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
        view = inflater.inflate(R.layout.fragment_mine_post_work, container, false);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;

    }

    private void initView() {
        Bundle bundle = getArguments();
        tv.setText(bundle.getString("sign"));

    }

    private void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
