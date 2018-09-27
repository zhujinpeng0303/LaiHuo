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
import com.example.jason_jukes.laihuo.adapter.FindWorkLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 11:12
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MinePartWorkFragment extends BaseFragment {

    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.lv)
    ListView lv;
    private View view;

    private List<String> been = new ArrayList<>();
    private FindWorkLVAdapter adapter;

    public static Fragment createFragment(String url, String sign) {
        Fragment fragment = new MinePartWorkFragment();
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
        view = inflater.inflate(R.layout.fragment_mine_part_work, container, false);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;

    }

    private void initView() {
        Bundle bundle = getArguments();
        tv.setText(bundle.getString("sign"));

        been = new ArrayList<>();
        been.add("道理-瓦匠");
        been.add("道外-砖工");
        been.add("南岗-砌砖");
        been.add("群力-装卸工");
        been.add("平房-力工");

        adapter = new FindWorkLVAdapter(context, been);
        lv.setAdapter(adapter);

    }

    private void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
