package com.example.jason_jukes.laihuo.activity.mine;

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
import com.example.jason_jukes.laihuo.fragment.MinePostWorkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 10:44
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MinePartWorkActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_shenqing)
    TextView tvShenqing;
    @InjectView(R.id.tv_jinxing)
    TextView tvJinxing;
    @InjectView(R.id.tv_wancheng)
    TextView tvWancheng;
    @InjectView(R.id.frame)
    FrameLayout frame;

    private List<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_part_work);
        ButterKnife.inject(this);
        initView();
        initFragment();

    }

    private void initFragment() {

        Fragment shenqing = MinePartWorkFragment.createFragment("", "第1个");
        Fragment jinxing = MinePartWorkFragment.createFragment("", "第2个");
        Fragment wancheng = MinePartWorkFragment.createFragment("", "第3个");
        mFragments = new ArrayList<>();
        mFragments.add(shenqing);
        mFragments.add(jinxing);
        mFragments.add(wancheng);
        mFragmentManager = getSupportFragmentManager();

        showFragment(0);

    }

    private void initView() {

        tvStatusBarName.setText("我参与的活");

    }

    @OnClick({R.id.rl_back, R.id.tv_shenqing, R.id.tv_jinxing, R.id.tv_wancheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_shenqing:

                tvShenqing.setTextColor(getResources().getColor(R.color.white));
                tvShenqing.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvJinxing.setBackground(null);
                tvWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvWancheng.setBackground(null);

                showFragment(0);

                break;
            case R.id.tv_jinxing:

                tvShenqing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvShenqing.setBackground(null);
                tvJinxing.setTextColor(getResources().getColor(R.color.white));
                tvJinxing.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvWancheng.setBackground(null);

                showFragment(1);

                break;
            case R.id.tv_wancheng:

                tvShenqing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvShenqing.setBackground(null);
                tvJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvJinxing.setBackground(null);
                tvWancheng.setTextColor(getResources().getColor(R.color.white));
                tvWancheng.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));

                showFragment(2);

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
            case 2:
                if (!mFragments.get(2).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(2));
                    mFragmentTransaction.show(mFragments.get(2));
                } else {
                    mFragmentTransaction.show(mFragments.get(2));
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
        if (mFragments.get(2) != null) {
            ft.hide(mFragments.get(2));
        }


    }

}
