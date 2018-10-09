package com.example.jason_jukes.laihuo.activity.home;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.NearbyPersonLVAdapter;
import com.example.jason_jukes.laihuo.bean.NearbyPersonBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @InjectView(R.id.ll_null)
    LinearLayout llNull;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;
    @InjectView(R.id.map)
    MapView map;

    private List<NearbyPersonBean.DataArrBean> been;
    private NearbyPersonLVAdapter adapter;

    private BaiduMap mBaiduMap;
    boolean isFirstLoc = true; // 是否首次定位
    private MyLocationData locData;

    private boolean flag = false;

    // 定位相关
    LocationClient mLocClient = null;
    public MyLocationListenner myListener = new MyLocationListenner();
    private MyLocationConfiguration.LocationMode mCurrentMode;
    BitmapDescriptor mCurrentMarker;
    private static final int accuracyCircleFillColor = 0xAAFFFF88;
    private static final int accuracyCircleStrokeColor = 0xAA00FF00;
    private SensorManager mSensorManager;
    private Double lastX = 0.0;
    private int mCurrentDirection = 0;
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private float mCurrentAccracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_person);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        ButterKnife.inject(this);
        initView();
        initData();

    }

    private void initView() {

        tvStatusBarName.setText("附近的能人");

        map.setVisibility(View.GONE);
        ref.setEnabled(true);


//        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
//                mCurrentMode, true, mCurrentMarker));
//        MapStatus.Builder builder1 = new MapStatus.Builder();
//        builder1.overlook(0);
//        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder1.build()));

        been = new ArrayList<>();
        adapter = new NearbyPersonLVAdapter(this, been);
        lv.setAdapter(adapter);

        Animation scale = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        scale.setRepeatCount(-1);
        scale.setRepeatMode(Animation.REVERSE);
        ivLocation.startAnimation(scale);


        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                been.clear();
                initData();
            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                boolean enable = false;
                if (lv != null && lv.getChildCount() > 0) {
                    // check if the first item of the list is visible
                    boolean firstItemVisible = lv.getFirstVisiblePosition() == 0;
                    // check if the top of the first item is visible
                    boolean topOfFirstItemVisible = lv.getChildAt(0).getTop() == 0;
                    // enabling or disabling the refresh layout
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                ref.setEnabled(enable);
            }
        });

    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            ref.setRefreshing(true);
            getData();
        } else {
            showToast("请检查网络设置");

        }

    }

    private void getData() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("px", "126.5");
        map.put("py", "45.7028007507");

        XUtil.Post(Contants.NEARBY_WORKER, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                NearbyPersonBean bean = new Gson().fromJson(result, NearbyPersonBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataArr().size() > 0) {
                        llNull.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getDataArr().size(); i++) {

                            been.add(bean.getDataArr().get(i));

                        }

                        adapter.notifyDataSetChanged();

                        tvCount.setText(bean.getDataArr().size() + "");

                    } else {
                        llNull.setVisibility(View.VISIBLE);
                    }
                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();
                ref.setRefreshing(false);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();
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
            if (location == null || map == null) {
                return;
            }
            mCurrentLat = location.getLatitude();
            mCurrentLon = location.getLongitude();

            Log.e("posion", mCurrentLat + " 和" + mCurrentLon + "");

            mCurrentAccracy = location.getRadius();
            locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
//            if (isFirstLoc) {
//                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
//            }
        }

        public void onReceivePoi(BDLocation poiLocation) {

        }
    }


    @OnClick({R.id.rl_back, R.id.tv_loc, R.id.rl_location})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_loc:

                if (!flag) {
                    map.setVisibility(View.VISIBLE);
                    llNull.setVisibility(View.GONE);
                    lv.setVisibility(View.GONE);
                    ref.setEnabled(false);
                    flag = !flag;


                    mBaiduMap = map.getMap();
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);


                    // 开启定位图层
                    mBaiduMap.setMyLocationEnabled(true);
                    mLocClient = new LocationClient(getApplicationContext());
                    mLocClient.registerLocationListener(myListener);
                    LocationClientOption option = new LocationClientOption();
                    option.setOpenGps(true); // 打开gps
                    option.setCoorType("bd09ll"); // 设置坐标类型
                    option.setScanSpan(1000);
                    mLocClient.setLocOption(option);
                    mLocClient.start();

                } else {
                    map.setVisibility(View.GONE);
//                    llNull.setVisibility(View.GONE);
                    lv.setVisibility(View.VISIBLE);
                    ref.setEnabled(true);
                    flag = !flag;
                }

                break;
            case R.id.rl_location:


                break;
        }
    }


    @Override
    protected void onPause() {
        map.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
//取消注册传感器监听
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        map.onDestroy();
        map = null;
        super.onDestroy();
    }
}
