package com.example.jason_jukes.laihuo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.activity.home.FindWorkActivity;
import com.example.jason_jukes.laihuo.activity.home.findWorker.ChooseClassifyActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineInvistWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePartWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePostWorkActivity;
import com.example.jason_jukes.laihuo.fragment.HomeFragment;
import com.example.jason_jukes.laihuo.fragment.MineFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @InjectView(R.id.tv_home)
    TextView tvHome;
    @InjectView(R.id.tv_mine)
    TextView tvMine;
    @InjectView(R.id.img_add)
    ImageView imgAdd;
    @InjectView(R.id.rl_post_yikoujia)
    RelativeLayout rlPostYikoujia;
    @InjectView(R.id.rl_jie_yikoujia)
    RelativeLayout rlJieYikoujia;
    @InjectView(R.id.rl_shangban)
    RelativeLayout rlShangban;
    @InjectView(R.id.rl_mine_post)
    RelativeLayout rlMinePost;
    @InjectView(R.id.rl_mine_jiehou)
    RelativeLayout rlMineJiehou;
    @InjectView(R.id.rl_mine_invist)
    RelativeLayout rlMineInvist;
    @InjectView(R.id.ll_popUp_box)
    LinearLayout llPopUpBox;
    @InjectView(R.id.iv_yellow)
    ImageView ivYellow;
    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    Fragment[] mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initFragment();
    }

    private void initFragment() {

        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        mFragments = new Fragment[]{homeFragment, mineFragment};
        mFragmentManager = getSupportFragmentManager();

        showFragment(0);
        tvHome.setSelected(true);
    }


    @OnClick({R.id.tv_home, R.id.tv_feature, R.id.img_add, R.id.tv_mine, R.id.rl_post_yikoujia, R.id.rl_jie_yikoujia, R.id.rl_shangban, R.id.rl_mine_post, R.id.rl_mine_jiehou, R.id.rl_mine_invist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                showFragment(0);
                tvHome.setSelected(true);
                tvMine.setSelected(false);
                break;
            case R.id.tv_mine:
                showFragment(1);
                tvMine.setSelected(true);
                tvHome.setSelected(false);
                break;
            case R.id.tv_feature:

                showToast("菜单");
                Animation rotateAnimation = null;
                if (flag) {
                    rotateAnimation = new RotateAnimation(0, -315, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    showBox();
                } else {
                    rotateAnimation = new RotateAnimation(-315, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    hideBox();
                }
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setDuration(500);
                imgAdd.startAnimation(rotateAnimation);
                flag = !flag;

                break;
            case R.id.img_add:
                Animation rotateAnimation1 = null;
                if (flag) {
                    rotateAnimation1 = new RotateAnimation(0, -315, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    showBox();
                } else {
                    rotateAnimation1 = new RotateAnimation(-315, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    hideBox();
                }

                rotateAnimation1.setFillAfter(true);
                rotateAnimation1.setDuration(500);
                imgAdd.startAnimation(rotateAnimation1);
                flag = !flag;

                break;
            case R.id.rl_post_yikoujia:
                startIntent(ChooseClassifyActivity.class);
                break;
            case R.id.rl_jie_yikoujia:
                startIntent(FindWorkActivity.class);
                break;
            case R.id.rl_shangban:

                break;
            case R.id.rl_mine_post:
                startIntent(MinePostWorkActivity.class);
                break;
            case R.id.rl_mine_jiehou:
                startIntent(MinePartWorkActivity.class);
                break;
            case R.id.rl_mine_invist:
                startIntent(MineInvistWorkActivity.class);
                break;

        }
    }

    //遮罩开启
    private void showBox() {
        rlJieYikoujia.setClickable(true);
        rlMineInvist.setClickable(true);
        rlMineJiehou.setClickable(true);
        rlMinePost.setClickable(true);
        rlPostYikoujia.setClickable(true);
        rlShangban.setClickable(true);

        Animation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        llPopUpBox.startAnimation(alphaAnimation);

        Animation alphaAnimation1 = new AlphaAnimation(1, 0);
        alphaAnimation1.setDuration(500);
        alphaAnimation1.setFillAfter(true);
        ivYellow.startAnimation(alphaAnimation1);

        Animation tra1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra1.setDuration(500);
        tra1.setFillAfter(true);
        rlJieYikoujia.startAnimation(tra1);

        Animation tra2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra2.setDuration(500);
        tra2.setFillAfter(true);
        rlPostYikoujia.startAnimation(tra2);

        Animation tra3 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra3.setDuration(500);
        tra3.setFillAfter(true);
        rlShangban.startAnimation(tra3);

        Animation tra4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra4.setDuration(500);
        tra4.setFillAfter(true);
        rlMinePost.startAnimation(tra4);

        Animation tra5 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra5.setDuration(500);
        tra5.setFillAfter(true);
        rlMineJiehou.startAnimation(tra5);

        Animation tra6 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra6.setDuration(500);
        tra6.setFillAfter(true);
        rlMineInvist.startAnimation(tra6);


        llPopUpBox.setVisibility(View.VISIBLE);
        llPopUpBox.setClickable(true);

    }

    //遮罩关闭
    private void hideBox() {
        llPopUpBox.setVisibility(View.GONE);
        llPopUpBox.setClickable(false);
        rlJieYikoujia.setClickable(false);
        rlMineInvist.setClickable(false);
        rlMineJiehou.setClickable(false);
        rlMinePost.setClickable(false);
        rlPostYikoujia.setClickable(false);
        rlShangban.setClickable(false);
        Animation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        llPopUpBox.startAnimation(alphaAnimation);

        Animation alphaAnimation1 = new AlphaAnimation(0, 1);
        alphaAnimation1.setDuration(500);
        alphaAnimation1.setFillAfter(true);

        ivYellow.startAnimation(alphaAnimation1);

        Animation tra1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -0.5f);
        tra1.setDuration(500);
        tra1.setFillAfter(true);
        rlJieYikoujia.startAnimation(tra1);

        Animation tra2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -0.5f);
        tra2.setDuration(500);
        tra2.setFillAfter(true);
        rlPostYikoujia.startAnimation(tra2);

        Animation tra3 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -0.5f);
        tra3.setDuration(500);
        tra3.setFillAfter(true);
        rlShangban.startAnimation(tra3);

        Animation tra4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        tra4.setDuration(500);
        tra4.setFillAfter(true);
        rlMinePost.startAnimation(tra4);

        Animation tra5 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        tra5.setDuration(500);
        tra5.setFillAfter(true);
        rlMineJiehou.startAnimation(tra5);

        Animation tra6 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        tra6.setDuration(500);
        tra6.setFillAfter(true);
        rlMineInvist.startAnimation(tra6);


    }

    private void showFragment(int index) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(mFragmentTransaction);
        switch (index) {
            case 0:
                if (!mFragments[0].isAdded()) {
                    mFragmentTransaction.add(R.id.content, mFragments[0]);
                    mFragmentTransaction.show(mFragments[0]);
                } else {
                    mFragmentTransaction.remove(mFragments[0]);
                    mFragments[0] = new HomeFragment();
                    mFragmentTransaction.add(R.id.content, mFragments[0]);
                    mFragmentTransaction.show(mFragments[0]);
                }

                break;
            case 1:
                if (!mFragments[1].isAdded()) {
                    mFragmentTransaction.add(R.id.content, mFragments[1]);
                    mFragmentTransaction.show(mFragments[1]);
                } else {
                    mFragmentTransaction.remove(mFragments[1]);
                    mFragments[1] = new MineFragment();
                    mFragmentTransaction.add(R.id.content, mFragments[1]);
                    mFragmentTransaction.show(mFragments[1]);
                }
                break;

        }
        mFragmentTransaction.commit();
    }


    public void hideFragment(FragmentTransaction ft) {
        //如果不为空，就先隐藏起来
        if (mFragments[0] != null) {
            ft.hide(mFragments[0]);
        }
        if (mFragments[1] != null) {
            ft.hide(mFragments[1]);
        }

    }

}
