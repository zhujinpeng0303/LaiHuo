package com.example.jason_jukes.laihuo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.CountActivity;
import com.example.jason_jukes.laihuo.activity.home.FindWorkActivity;
import com.example.jason_jukes.laihuo.activity.home.MessageMarketActivity;
import com.example.jason_jukes.laihuo.activity.home.NearbyPersonActivity;
import com.example.jason_jukes.laihuo.activity.home.SendScoreActivity;
import com.example.jason_jukes.laihuo.activity.home.findWorker.ChooseClassifyActivity;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.view.glide.GlideRoundTransform;

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
    @InjectView(R.id.iv_top)
    ImageView ivTop;
    @InjectView(R.id.iv_middle)
    ImageView ivMiddle;
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
        initData();
        return view;

    }

    private void initView(View view) {
        rlBack.setVisibility(View.GONE);
        Glide.with(context).load(Contants.HOME_TOP_PIC).into(ivTop);
        Glide.with(context).load(Contants.HOME_MIDDLE_PIC).transform(new GlideRoundTransform(context, 10)).into(ivMiddle);
    }

    private void initData() {

        if (IsNetWork.isNetWork(context)) {
//            showPro();
//            getPic();
        } else {
            showToast("请检查网络设置");

        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.iv_top, R.id.iv_middle, R.id.ll_message, R.id.rl_find_worker, R.id.rl_find_work,R.id.rl_count})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_top:
                showToast("詳情");
                break;
            case R.id.iv_middle:
                showToast("開發");
                break;
            case R.id.ll_message:
                showToast("信息市场");
                startIntent(MessageMarketActivity.class);
                break;
            case R.id.rl_find_worker:
                showToast("找工人");
                startIntent(ChooseClassifyActivity.class);
                break;
            case R.id.rl_find_work:
                showToast("找活干");
                startIntent(FindWorkActivity.class);
                break;
            case R.id.rl_count:

                startIntent(NearbyPersonActivity.class);

                break;
        }
    }

}
