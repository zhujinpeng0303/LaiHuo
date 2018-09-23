package com.example.jason_jukes.laihuo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:36
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */


public class MineFragment extends BaseFragment {


    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.iv_avatar)
    ImageView ivAvatar;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_shangban)
    TextView tvShangban;
    @InjectView(R.id.tv_guanzhu)
    TextView tvGuanzhu;
    @InjectView(R.id.rl_guanzhu)
    RelativeLayout rlGuanzhu;
    @InjectView(R.id.tv_money)
    TextView tvMoney;
    @InjectView(R.id.rl_qianbao)
    RelativeLayout rlQianbao;
    @InjectView(R.id.tv_fans)
    TextView tvFans;
    @InjectView(R.id.rl_fans)
    RelativeLayout rlFans;
    @InjectView(R.id.tv_wallet_count)
    TextView tvWalletCount;
    @InjectView(R.id.tv_card_status)
    TextView tvCardStatus;
    @InjectView(R.id.tv_phone_status)
    TextView tvPhoneStatus;
    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, view);
        ivBack.setVisibility(View.GONE);
        tvStatusBarName.setText("我的");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.iv_avatar, R.id.rl_name, R.id.tv_shangban, R.id.rl_guanzhu, R.id.rl_qianbao, R.id.rl_fans, R.id.rl_mine_post_work, R.id.rl_mine_join_work, R.id.rl_mine_invist_work, R.id.rl_mine_money, R.id.rl_mine_score, R.id.rl_mine_code, R.id.rl_mine_card, R.id.rl_mine_phone, R.id.rl_mine_zili, R.id.rl_mine_address, R.id.rl_yijian, R.id.rl_tousu, R.id.tv_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                showToast("头像");
                break;
            case R.id.rl_name:
                break;
            case R.id.tv_shangban:
                break;
            case R.id.rl_guanzhu:
                break;
            case R.id.rl_qianbao:
                break;
            case R.id.rl_fans:
                break;
            case R.id.rl_mine_post_work:
                break;
            case R.id.rl_mine_join_work:
                break;
            case R.id.rl_mine_invist_work:
                break;
            case R.id.rl_mine_money:
                break;
            case R.id.rl_mine_score:
                break;
            case R.id.rl_mine_code:
                break;
            case R.id.rl_mine_card:
                break;
            case R.id.rl_mine_phone:
                break;
            case R.id.rl_mine_zili:
                break;
            case R.id.rl_mine_address:
                break;
            case R.id.rl_yijian:
                break;
            case R.id.rl_tousu:
                break;
            case R.id.tv_exit:
                break;
        }
    }
}
