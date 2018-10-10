package com.example.jason_jukes.laihuo.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.FindWorkActivity;
import com.example.jason_jukes.laihuo.activity.home.MessageMarketActivity;
import com.example.jason_jukes.laihuo.activity.home.NearbyPersonActivity;
import com.example.jason_jukes.laihuo.activity.home.findWorker.ChooseClassifyActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
import com.example.jason_jukes.laihuo.bean.HomeBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.Singleton;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.RandomTextView;
import com.example.jason_jukes.laihuo.view.glide.GlideRoundTransform;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:25
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class HomeFragment extends BaseFragment {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.rl_find_work)
    RelativeLayout rlFindWork;
    @InjectView(R.id.rl_back)
    RelativeLayout rlBack;
    @InjectView(R.id.iv_top)
    ImageView ivTop;
    @InjectView(R.id.iv_middle)
    ImageView ivMiddle;
    @InjectView(R.id.ll)
    LinearLayout ll;
    @InjectView(R.id.tv_post1)
    RandomTextView tvPost1;
    @InjectView(R.id.tv_post2)
    RandomTextView tvPost2;
    @InjectView(R.id.tv_post3)
    RandomTextView tvPost3;
    @InjectView(R.id.tv_post4)
    RandomTextView tvPost4;
    @InjectView(R.id.tv_work1)
    RandomTextView tvWork1;
    @InjectView(R.id.tv_work2)
    RandomTextView tvWork2;
    @InjectView(R.id.tv_work3)
    RandomTextView tvWork3;
    @InjectView(R.id.tv_work4)
    RandomTextView tvWork4;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        initView(view);
        initData();
        return view;

    }

    private void initView(View view) {
        rlBack.setVisibility(View.GONE);
        Glide.with(context).load(Contants.HOME_TOP_PIC).into(ivTop);
        Glide.with(context).load(Contants.HOME_MIDDLE_PIC).apply(RequestOptions.bitmapTransform(new GlideRoundTransform(context, 10))).into(ivMiddle);

        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });


        //判断用户是否已经授权
        if (ContextCompat.checkSelfPermission(context, "Manifest.permission.ACCESS_FINE_LOCATION") != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, "Manifest.permission.ACCESS_COARSE_LOCATION") != PackageManager.PERMISSION_GRANTED) {
            //注意第二个参数没有双引号
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        } else {

            loc();

        }


    }


    //定位
    private void loc() {


    }

    private void initData() {

        if (IsNetWork.isNetWork(context)) {
            ref.setRefreshing(true);
            showPro();
            getPic();
        } else {
            showToast("请检查网络设置");
        }

    }

    private void getPic() {

        ll.removeAllViews();
        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("city_value", "haerbin");

        XUtil.Post(Contants.HOME, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                HomeBean bean = new Gson().fromJson(result, HomeBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    int dimension = (int) getResources().getDimension(R.dimen.y50);
                    int dimension1 = (int) getResources().getDimension(R.dimen.y588);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dimension1);

                    for (int i = 0; i < bean.getDataObj().getBannerList().size(); i++) {

                        ImageView imageView = new ImageView(context);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setPadding(0, dimension, 0, 0);
                        imageView.setLayoutParams(params);
                        Glide.with(context)
                                .load(Contants.URL_IMG_BASE + bean.getDataObj().getBannerList().get(i).getImg_url())
                                .apply(RequestOptions.bitmapTransform(new GlideRoundTransform(context, 10)))
                                .into(imageView);

                        ll.addView(imageView);


                        DecimalFormat df = new DecimalFormat("0000");
                        String str = df.format(bean.getDataObj().getCityIndexMap().getCount_wait_selectuser_order());

                        tvPost1.setText(String.valueOf(str.charAt(0)));
                        tvPost1.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvPost1.setMaxLine(8);
                        tvPost1.start();
                        tvPost2.setText(String.valueOf(str.charAt(1)));
                        tvPost2.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvPost2.setMaxLine(10);
                        tvPost2.start();
                        tvPost3.setText(String.valueOf(str.charAt(2)));
                        tvPost3.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvPost3.setMaxLine(12);
                        tvPost3.start();
                        tvPost4.setText(String.valueOf(str.charAt(3)));
                        tvPost4.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvPost4.setMaxLine(14);
                        tvPost4.start();

                        String str1 = df.format(bean.getDataObj().getCityIndexMap().getCount_workers());

                        tvWork1.setText(String.valueOf(str1.charAt(0)));
                        tvWork1.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvWork1.setMaxLine(8);
                        tvWork1.start();
                        tvWork2.setText(String.valueOf(str1.charAt(1)));
                        tvWork2.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvWork2.setMaxLine(10);
                        tvWork2.start();
                        tvWork3.setText(String.valueOf(str1.charAt(2)));
                        tvWork3.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvWork3.setMaxLine(12);
                        tvWork3.start();
                        tvWork4.setText(String.valueOf(str1.charAt(3)));
                        tvWork4.setPianyilian(RandomTextView.FIRSTF_FIRST);
                        tvWork4.setMaxLine(14);
                        tvWork4.start();

                    }

                } else if (bean.getErrorCode().equals(Contants.HTTP_NO_LOGIN)) {
                    showToast(bean.getErrorMsg());
                    startIntent(PhoneLoginActivity.class);
                } else {
                    showToast(bean.getErrorMsg());

                }
                ref.setRefreshing(false);
                hidePro();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hidePro();
                ref.setRefreshing(false);

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null) {
                return;
            }

            Singleton.instance.setPx(location.getLongitude() + "");
            Singleton.instance.setPy(location.getLatitude() + "");

            Log.e("posion", location.getLatitude() + " 和" + location.getLongitude());


        }

        public void onReceivePoi(BDLocation poiLocation) {

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.iv_top, R.id.iv_middle, R.id.ll_message, R.id.rl_find_worker, R.id.rl_find_work, R.id.rl_post, R.id.rl_work})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_top:
                showToast("詳情");
                break;
            case R.id.iv_middle:
                showToast("開發");
                break;
            case R.id.ll_message:
                startIntent(MessageMarketActivity.class);
                break;
            case R.id.rl_find_worker:
                startIntent(ChooseClassifyActivity.class);
                break;
            case R.id.rl_find_work:
                startIntent(FindWorkActivity.class);
                break;
            case R.id.rl_post:
                startIntent(FindWorkActivity.class);
                break;
            case R.id.rl_work:
                startIntent(NearbyPersonActivity.class);
                break;

        }
    }

}
