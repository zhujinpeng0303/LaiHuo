package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.view.IdentifyDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/27 0027 13:33
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class SurePostActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_work_kind)
    TextView tvWorkKind;
    @InjectView(R.id.tv_work_address)
    TextView tvWorkAddress;
    @InjectView(R.id.tv_jiage_type)
    TextView tvJiageType;
    @InjectView(R.id.tv_jiage)
    TextView tvJiage;
    @InjectView(R.id.tv_work_time)
    TextView tvWorkTime;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.tv_detail_address)
    TextView tvDetailAddress;
    @InjectView(R.id.ll_work_address)
    LinearLayout llWorkAddress;
    @InjectView(R.id.tv_work_desc)
    TextView tvWorkDesc;
    @InjectView(R.id.rl_luyin)
    RelativeLayout rlLuyin;
    @InjectView(R.id.ll_img)
    LinearLayout llImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_post);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {

        tvStatusBarName.setText("确认发布内容");

    }

    private void initData() {

        List<String> imgs = new ArrayList<>();
        imgs.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        imgs.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgs.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");

        int dimension = (int) getResources().getDimension(R.dimen.x50);
        int dimension1 = (int) getResources().getDimension(R.dimen.y20);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < imgs.size(); i++) {

            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(dimension, 0, dimension, dimension);
            imageView.setLayoutParams(params);
            Glide.with(context).load(imgs.get(i)).placeholder(R.mipmap.ic_launcher).into(imageView);

            llImg.addView(imageView);

        }

    }

    @OnClick({R.id.rl_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_sure:
                IdentifyDialog dialog = new IdentifyDialog(this);
                dialog.commonDialog();
                break;
        }
    }
}
