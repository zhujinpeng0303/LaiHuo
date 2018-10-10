package com.example.jason_jukes.laihuo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.MainActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.tool.Singleton;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Jason_Jukes on 2018/10/10 0010 09:23
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class SplashActivity extends BaseActivity {

    LocationClient mLocClient = null;
    public MyLocationListenner myListener = new MyLocationListenner();
    @InjectView(R.id.ll_splash)
    LinearLayout llSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        llSplash.setVisibility(View.GONE);

        mLocClient = new LocationClient(getApplicationContext());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(100000000);
        mLocClient.setLocOption(option);

        //判断用户是否已经授权
        if (ContextCompat.checkSelfPermission(SplashActivity.this, "Manifest.permission.ACCESS_FINE_LOCATION") != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(SplashActivity.this, "Manifest.permission.ACCESS_COARSE_LOCATION") != PackageManager.PERMISSION_GRANTED) {
            //注意第二个参数没有双引号
            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        } else {

            loc();

        }

    }

    /**
     * 启动动画
     */

    private void startAnim() {
        // 渐变动画,从完全透明到完全不透明
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        // 持续时间 2 秒
        alpha.setDuration(1500);
        // 动画结束后，保持动画状态
        alpha.setFillAfter(true);

        // 设置动画监听器
        alpha.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            // 动画结束时回调此方法
            @Override
            public void onAnimationEnd(Animation animation) {
                // 跳转到下一个页面
                startIntent(MainActivity.class);

            }
        });

        // 启动动画
        llSplash.startAnimation(alpha);
    }

    private void loc() {

        mLocClient.start();

    }


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null) {

                startIntent(MainActivity.class);

                return;
            }

            Singleton.instance.setPy(location.getLatitude() + "");
            Singleton.instance.setPx(location.getLongitude() + "");

            Log.e("posion", location.getLatitude() + " 和" + location.getLongitude() + "");

            llSplash.setVisibility(View.VISIBLE);
            startAnim();

        }

        public void onReceivePoi(BDLocation poiLocation) {

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 原来的敏感操作代码：发短信或者收短信

                    loc();

                } else {
                    showToast("您拒绝了该权限");
                    llSplash.setVisibility(View.VISIBLE);
                    startAnim();
                }
                break;
        }

    }


}
