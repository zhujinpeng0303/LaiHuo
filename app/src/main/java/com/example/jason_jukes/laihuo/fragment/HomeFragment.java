package com.example.jason_jukes.laihuo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.MessageMarketActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:25
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class HomeFragment extends BaseFragment {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.rl_find_work)
    RelativeLayout rlFindWork;
    @InjectView(R.id.rl_back)
    RelativeLayout rlBack;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        initView(view);
        return view;

    }

    private void initView(View view) {
        rlBack.setVisibility(View.GONE);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_see_detail, R.id.ll_message, R.id.rl_find_worker, R.id.rl_find_work})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_see_detail:
                showToast("查看详情");
                break;
            case R.id.ll_message:
                showToast("信息市场");
                startIntent(MessageMarketActivity.class);
                break;
            case R.id.rl_find_worker:
                showToast("找工人");
                break;
            case R.id.rl_find_work:
                showToast("找活干");
                break;
        }
    }
}
