package com.example.jason_jukes.laihuo.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.WorkDetailGridViewAdapter;
import com.example.jason_jukes.laihuo.view.BindCardDialog;
import com.example.jason_jukes.laihuo.view.MyGridView;
import com.example.jason_jukes.laihuo.view.RatingBar;
import com.example.jason_jukes.laihuo.view.WorkDetailPopupwindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/28 0028 08:41
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDetailActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_jiage_status)
    TextView tvJiageStatus;
    @InjectView(R.id.tv_post_time)
    TextView tvPostTime;
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
    @InjectView(R.id.tv_shenqing)
    TextView tvShenqing;
    @InjectView(R.id.tv_kejian)
    TextView tvKejian;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.tv_detail_address)
    TextView tvDetailAddress;
    @InjectView(R.id.ll_work_address)
    LinearLayout llWorkAddress;
    @InjectView(R.id.rl_work_address)
    RelativeLayout rlWorkAddress;
    @InjectView(R.id.ll_zhuizong)
    LinearLayout llZhuizong;
    @InjectView(R.id.tv_work_desc)
    TextView tvWorkDesc;
    @InjectView(R.id.rl_luyin)
    RelativeLayout rlLuyin;
    @InjectView(R.id.ll_img)
    LinearLayout llImg;
    @InjectView(R.id.gridView)
    MyGridView gridView;
    @InjectView(R.id.ratingBar_all)
    RatingBar ratingBarAll;
    @InjectView(R.id.tv_score_all)
    TextView tvScoreAll;
    @InjectView(R.id.ratingBar_jishi)
    RatingBar ratingBarJishi;
    @InjectView(R.id.tv_score_jishi)
    TextView tvScoreJishi;
    @InjectView(R.id.ratingBar_zhiliang)
    RatingBar ratingBarZhiliang;
    @InjectView(R.id.tv_score_zhiliang)
    TextView tvScoreZhiliang;
    @InjectView(R.id.ratingBar_attitude)
    RatingBar ratingBarAttitude;
    @InjectView(R.id.tv_score_attitude)
    TextView tvScoreAttitude;
    @InjectView(R.id.tv_evaluate)
    TextView tvEvaluate;
    @InjectView(R.id.iv_zhiding_avatar)
    ImageView ivZhidingAvatar;
    @InjectView(R.id.tv_zhiding_name)
    TextView tvZhidingName;
    @InjectView(R.id.tv_zhiding_score)
    TextView tvZhidingScore;
    @InjectView(R.id.tv_zhiding_phone)
    TextView tvZhidingPhone;
    @InjectView(R.id.tv_zhiding_jiage_status)
    TextView tvZhidingJiageStatus;
    @InjectView(R.id.rootView)
    LinearLayout rootView;
    @InjectView(R.id.iv_play)
    ImageView ivPlay;

    private WorkDetailGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_detail);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        tvStatusBarName.setText("详情");
    }

    private void initData() {

        List<String> imgs = new ArrayList<>();
        imgs.add("http://e.hiphotos.baidu.com/image/pic/item/b03533fa828ba61e8480853f4c34970a304e59b7.jpg");
        imgs.add("http://f.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f90a220479282dd42a2834a4ed.jpg");
        imgs.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
        imgs.add("http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91723e93522c43d70cf3ac757c6.jpg");
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

        final List<String> texts = new ArrayList<>();
        texts.add("讲述了肯德基卡了");
        texts.add("可怜见覅器");
        texts.add("动一期货论坛功能联合");
        texts.add("爱U盾推过去我看了");
        texts.add("我后花鼓看见");

        for (int i = 0; i < texts.size(); i++) {

            View v = LayoutInflater.from(context).inflate(R.layout.item_ll_view, null);
            TextView tv = v.findViewById(R.id.tv_name);
            tv.setText(texts.get(i));

            llZhuizong.addView(v);

        }

        adapter = new WorkDetailGridViewAdapter(this, imgs);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                WorkDetailPopupwindow popupwindow = new WorkDetailPopupwindow(WorkDetailActivity.this);
                popupwindow.show(rootView);

            }
        });


    }

    @OnClick({R.id.rl_back, R.id.tv_shenqing, R.id.rl_luyin,R.id.iv_play, R.id.rl_zhiding_avatar, R.id.iv_zhiding_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_shenqing:
                BindCardDialog dialog = new BindCardDialog(this);
                dialog.commonDialog();
                break;
            case R.id.rl_luyin:
                break;
            case R.id.iv_play:
                break;
            case R.id.rl_zhiding_avatar:
                break;
            case R.id.iv_zhiding_more:
                break;
        }
    }

}
