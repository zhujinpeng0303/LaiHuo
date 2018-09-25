package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.fragment.HomeFragment;
import com.example.jason_jukes.laihuo.fragment.MineFragment;
import com.example.jason_jukes.laihuo.fragment.MinePostWorkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 09:27
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MinePostWorkActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_all)
    TextView tvAll;
    @InjectView(R.id.tv_dai_zhifu)
    TextView tvDaiZhifu;
    @InjectView(R.id.tv_dai_jinxing)
    TextView tvDaiJinxing;
    @InjectView(R.id.tv_dai_wancheng)
    TextView tvDaiWancheng;

    private List<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_post_work);
        ButterKnife.inject(this);
        initView();
        initFragment();
    }

    private void initFragment() {

        Fragment all = MinePostWorkFragment.createFragment("", "第一个");
        Fragment zhifu = MinePostWorkFragment.createFragment("", "第二个");
        Fragment jinxing = MinePostWorkFragment.createFragment("", "第三个");
        Fragment wancheng = MinePostWorkFragment.createFragment("", "第四个");
        mFragments = new ArrayList<>();
        mFragments.add(all);
        mFragments.add(zhifu);
        mFragments.add(jinxing);
        mFragments.add(wancheng);
        mFragmentManager = getSupportFragmentManager();

        showFragment(0);

    }

    private void initView() {
        tvStatusBarName.setText("我发布的活");
    }

    @OnClick({R.id.rl_back, R.id.tv_all, R.id.tv_dai_zhifu, R.id.tv_dai_jinxing, R.id.tv_dai_wancheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_all:
                tvAll.setTextColor(getResources().getColor(R.color.white));
                tvAll.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);

                showFragment(0);

                break;
            case R.id.tv_dai_zhifu:
                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.white));
                tvDaiZhifu.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);

                showFragment(1);

                break;
            case R.id.tv_dai_jinxing:

                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.white));
                tvDaiJinxing.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);

                showFragment(2);

                break;
            case R.id.tv_dai_wancheng:

                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.white));
                tvDaiWancheng.setBackground(getDrawable(R.drawable.bg_dark_grey_big_corner));

                showFragment(3);

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
//                    mFragmentTransaction.remove(mFragments.get(0));
//                    mFragments.get(0) = new HomeFragment();
//                    mFragmentTransaction.add(R.id.content, mFragments[0]);
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
            case 3:
                if (!mFragments.get(3).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(3));
                    mFragmentTransaction.show(mFragments.get(3));
                } else {
                    mFragmentTransaction.show(mFragments.get(3));
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
        if (mFragments.get(3) != null) {
            ft.hide(mFragments.get(3));
        }

    }

}
