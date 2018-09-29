package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.NearbyPersonLVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/29 0029 16:38
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class NearbyPersonActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_loc)
    TextView tvLoc;
    @InjectView(R.id.iv_location)
    ImageView ivLocation;
    @InjectView(R.id.tv_count)
    TextView tvCount;
    @InjectView(R.id.lv)
    ListView lv;

    private List<String> been;
    private NearbyPersonLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_person);
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("附近的能人");

        been = new ArrayList<>();
        been.add("张三");
        been.add("李四");
        been.add("王二毛");
        been.add("前四");

        adapter = new NearbyPersonLVAdapter(this, been);
        lv.setAdapter(adapter);

        Animation scale = new ScaleAnimation( 1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        scale.setRepeatCount(-1);
        scale.setRepeatMode(Animation.REVERSE);
        ivLocation.startAnimation(scale);

    }

    private void initData() {

    }

    @OnClick({R.id.rl_back, R.id.tv_loc, R.id.rl_location})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                break;
            case R.id.tv_loc:
                break;
            case R.id.rl_location:
                break;
        }
    }
}
