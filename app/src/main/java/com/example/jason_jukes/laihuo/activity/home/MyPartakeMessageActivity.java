package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.fragment.MinePartWorkFragment;
import com.example.jason_jukes.laihuo.fragment.MyPartakeMessageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 11:51
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MyPartakeMessageActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_my_post)
    TextView tvMyPost;
    @InjectView(R.id.tv_my_partake)
    TextView tvMyPartake;
    @InjectView(R.id.frame)
    FrameLayout frame;

    private List<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_partake_message);
        ButterKnife.inject(this);
        initView();
        initFragment();
    }

    private void initFragment() {

        Fragment post = MyPartakeMessageFragment.createFragment("", "");
        Fragment partake = MyPartakeMessageFragment.createFragment("", "");

        mFragments = new ArrayList<>();
        mFragments.add(post);
        mFragments.add(partake);
        mFragmentManager = getSupportFragmentManager();

        showFragment(0);
    }

    private void initView() {
        tvStatusBarName.setText("我参与的");

    }

    @OnClick({R.id.rl_back, R.id.tv_my_post, R.id.tv_my_partake})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_my_post:

                tvMyPost.setTextColor(getResources().getColor(R.color.colorBlack));
                tvMyPost.setTextSize(16);
                tvMyPartake.setTextColor(getResources().getColor(R.color.colorGray));
                tvMyPartake.setTextSize(14);

                showFragment(0);

                break;
            case R.id.tv_my_partake:

                tvMyPost.setTextColor(getResources().getColor(R.color.colorGray));
                tvMyPost.setTextSize(14);
                tvMyPartake.setTextColor(getResources().getColor(R.color.colorBlack));
                tvMyPartake.setTextSize(16);

                showFragment(1);

                break;
        }
    }


    private void showFragment(int index) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(mFragmentTransaction);
        switch (index) {
            case 0:
                if (!mFragments.get(0).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(0));
                    mFragmentTransaction.show(mFragments.get(0));
                } else {
                    mFragmentTransaction.show(mFragments.get(0));
                }

                break;
            case 1:
                if (!mFragments.get(1).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(1));
                    mFragmentTransaction.show(mFragments.get(1));
                } else {
                    mFragmentTransaction.show(mFragments.get(1));
                }
                break;

        }
        mFragmentTransaction.commit();
    }

    public void hideFragment(FragmentTransaction ft) {
        //如果不为空，就先隐藏起来
        if (mFragments.get(0) != null) {
            ft.hide(mFragments.get(0));
        }
        if (mFragments.get(1) != null) {
            ft.hide(mFragments.get(1));
        }

    }

}
