package com.example.jason_jukes.laihuo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.fragment.HomeFragment;
import com.example.jason_jukes.laihuo.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    Fragment[] mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;


    @BindView(R.id.content)
    RelativeLayout content;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.add)
    ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {

        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        mFragments = new Fragment[]{homeFragment, mineFragment};
        mFragmentManager = getSupportFragmentManager();

//        showFragment(0);

    }

    @OnClick({R.id.tv_home, R.id.tv_mine, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                showToast("嗯了");
                showFragment(0);
                break;
            case R.id.tv_mine:
                showFragment(1);
                break;
            case R.id.add:
                break;
        }
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
