package com.example.jason_jukes.laihuo.activity.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
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
    @InjectView(R.id.tv_dai_pingjia)
    TextView tvDaiPingjia;
    @InjectView(R.id.tv_finished)
    TextView tvFinished;

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

        Fragment all = MinePostWorkFragment.createFragment("", "");
        Fragment zhifu = MinePostWorkFragment.createFragment("", "0,2");
        Fragment jinxing = MinePostWorkFragment.createFragment("", "1");
        Fragment wancheng = MinePostWorkFragment.createFragment("", "6,7,3,10,11");
        Fragment pingjia = MinePostWorkFragment.createFragment("", "4");
        Fragment finish = MinePostWorkFragment.createFragment("", "5,12");
        mFragments = new ArrayList<>();
        mFragments.add(all);
        mFragments.add(zhifu);
        mFragments.add(jinxing);
        mFragments.add(wancheng);
        mFragments.add(pingjia);
        mFragments.add(finish);
        mFragmentManager = getSupportFragmentManager();

        showFragment(0);

    }

    private void initView() {
        tvStatusBarName.setText("我发布的活");
    }

    @OnClick({R.id.rl_back, R.id.tv_all, R.id.tv_dai_zhifu, R.id.tv_dai_jinxing, R.id.tv_dai_wancheng, R.id.tv_dai_pingjia, R.id.tv_finished})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_all:
                tvAll.setTextColor(getResources().getColor(R.color.white));
                tvAll.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiPingjia.setBackground(null);
                tvFinished.setTextColor(getResources().getColor(R.color.colorBlack));
                tvFinished.setBackground(null);

                showFragment(0);

                break;
            case R.id.tv_dai_zhifu:
                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.white));
                tvDaiZhifu.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiPingjia.setBackground(null);
                tvFinished.setTextColor(getResources().getColor(R.color.colorBlack));
                tvFinished.setBackground(null);
                showFragment(1);

                break;
            case R.id.tv_dai_jinxing:

                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.white));
                tvDaiJinxing.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiPingjia.setBackground(null);
                tvFinished.setTextColor(getResources().getColor(R.color.colorBlack));
                tvFinished.setBackground(null);
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
                tvDaiWancheng.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiPingjia.setBackground(null);
                tvFinished.setTextColor(getResources().getColor(R.color.colorBlack));
                tvFinished.setBackground(null);
                showFragment(3);

                break;

            case R.id.tv_dai_pingjia:

                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.white));
                tvDaiPingjia.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                tvFinished.setTextColor(getResources().getColor(R.color.colorBlack));
                tvFinished.setBackground(null);
                showFragment(4);

                break;
            case R.id.tv_finished:
                tvAll.setTextColor(getResources().getColor(R.color.colorBlack));
                tvAll.setBackground(null);
                tvDaiZhifu.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiZhifu.setBackground(null);
                tvDaiJinxing.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiJinxing.setBackground(null);
                tvDaiWancheng.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiWancheng.setBackground(null);
                tvDaiPingjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaiPingjia.setBackground(null);
                tvFinished.setTextColor(getResources().getColor(R.color.white));
                tvFinished.setBackground(getResources().getDrawable(R.drawable.bg_dark_grey_big_corner));
                showFragment(5);

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
            case 4:
                if (!mFragments.get(4).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(4));
                    mFragmentTransaction.show(mFragments.get(4));
                } else {
                    mFragmentTransaction.show(mFragments.get(4));
                }
                break;
            case 5:
                if (!mFragments.get(5).isAdded()) {
                    mFragmentTransaction.add(R.id.frame, mFragments.get(5));
                    mFragmentTransaction.show(mFragments.get(5));
                } else {
                    mFragmentTransaction.show(mFragments.get(5));
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
        if (mFragments.get(4) != null) {
            ft.hide(mFragments.get(4));
        }
        if (mFragments.get(5) != null) {
            ft.hide(mFragments.get(5));
        }

    }


}
