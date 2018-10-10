package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.App;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.WorkDetailActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
import com.example.jason_jukes.laihuo.bean.ImgPostBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.Singleton;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.IdentifyDialog;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.iv1)
    ImageView iv1;
    @InjectView(R.id.iv2)
    ImageView iv2;
    @InjectView(R.id.iv3)
    ImageView iv3;
    @InjectView(R.id.iv4)
    ImageView iv4;
    @InjectView(R.id.iv_play)
    ImageView ivPlay;

    private String url = "";

    private MediaPlayer mPlayer = new MediaPlayer();

    private boolean isPlaying = false;

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
        tvTitle.setText("第四步·请确认您的提交内容");
        iv1.setBackgroundResource(R.mipmap.img_dui);
        iv2.setBackgroundResource(R.mipmap.img_dui);
        iv3.setBackgroundResource(R.mipmap.img_dui);
        iv4.setBackgroundResource(R.mipmap.img_four_choose);

        tvWorkKind.setText(Singleton.instance.getClassify_name());
        tvWorkAddress.setText(Singleton.instance.getAddress());

        if (Singleton.instance.getStatus().equals("0")) {
            tvJiageType.setText("心里预期价格");
            url = Contants.POST_HUANJIA;
        } else {
            tvJiageType.setText("一口价价格");
            url = Contants.POST_YIKOU;
        }
        if (TextUtils.isEmpty(Singleton.instance.getPrice())) {
            tvJiage.setText("面议");
        } else {
            tvJiage.setText(Singleton.instance.getPrice() + "元");
        }

        if (TextUtils.isEmpty(Singleton.instance.getData())) {
            tvWorkTime.setText("面议");
        } else {
            tvWorkTime.setText(Singleton.instance.getData() + " " + Singleton.instance.getTime());
        }

        if (TextUtils.isEmpty(Singleton.instance.getLuyinPath())) {
            rlLuyin.setVisibility(View.GONE);
        } else {
            rlLuyin.setVisibility(View.VISIBLE);
        }

        tvName.setText(Singleton.instance.getName());
        tvPhone.setText(Singleton.instance.getPhone());
        tvDetailAddress.setText(Singleton.instance.getDetailAddress());
        tvWorkDesc.setText(Singleton.instance.getDesc_text());

    }

    private void initData() {

        int dimension = (int) getResources().getDimension(R.dimen.x50);
        int dimension1 = (int) getResources().getDimension(R.dimen.y20);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        String[] arr = Singleton.instance.getImgPath().split(",");//分割字符串得到数组
        List<String> list = Arrays.asList(arr);//字符数组转list

        for (int i = 0; i < list.size(); i++) {

            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(dimension, 0, dimension, dimension);
            imageView.setLayoutParams(params);
            Glide.with(context).load(Contants.URL_IMG_BASE + list.get(i)).into(imageView);

            llImg.addView(imageView);

        }

    }

    private void post() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("base_user_certification_classify_id", Singleton.instance.getClassify_id());
        map.put("order_desc", Singleton.instance.getDesc_text());
        map.put("order_desc_sounds", Singleton.instance.getLuyinPath());
        if (!TextUtils.isEmpty(Singleton.instance.getImgPath())) {
            map.put("order_desc_pics", Singleton.instance.getImgPath());
        }
        map.put("address_id", Singleton.instance.getAddress_id());
        map.put("must_arrive_date", Singleton.instance.getData());
        map.put("must_arrive_time", Singleton.instance.getTime());
        map.put("use_contract", "1");
        map.put("use_insurance", "1");
        map.put("city_value", "haerbin");
        if (Singleton.instance.getStatus().equals("0")) {
            map.put("order_price_range", Singleton.instance.getPrice());
        } else {
            map.put("order_price", Singleton.instance.getPrice());
        }

        Log.e("aaaaaaaaaa", map.toString());
        Log.e("url", url);

        XUtil.Post(url, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result", result);

                ImgPostBean bean = new Gson().fromJson(result, ImgPostBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());

                    App.destoryActivity("classify");
                    App.destoryActivity("desc");
                    App.destoryActivity("address");
                    finish();
                    startActivity(new Intent(SurePostActivity.this, WorkDetailActivity.class)
                            .putExtra("id", bean.getDataObj().getOrder_id()));

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @OnClick({R.id.rl_back, R.id.tv_sure, R.id.iv_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_play:

                if (!isPlaying) {
                    ivPlay.setBackgroundResource(R.mipmap.img_luyin_stop);
                    try {
                        isPlaying = true;
                        mPlayer = new MediaPlayer();
                        mPlayer.setDataSource(Singleton.instance.getLuyin());
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                        // 通过异步的方式装载媒体资源
                        mPlayer.prepareAsync();
                        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // 装载完毕回调
                                mPlayer.start();
                            }
                        });
//                        mPlayer.prepare();
//                        mPlayer.start();

                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                isPlaying = false;
                                ivPlay.setBackgroundResource(R.mipmap.img_luyin_play);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    ivPlay.setBackgroundResource(R.mipmap.img_luyin_play);

                    if (mPlayer != null) {
                        isPlaying = false;
                        mPlayer.pause();
                    }

                }

                break;
            case R.id.tv_sure:

                if (SPTool.getInstance().getShareDataStr(Contants.ID_STATUS).equals("0")) {
                    IdentifyDialog dialog = new IdentifyDialog(this);
                    dialog.commonDialog();

                    return;
                } else {

                    post();

                }

                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

}
