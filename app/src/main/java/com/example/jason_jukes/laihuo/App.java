package com.example.jason_jukes.laihuo;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.example.jason_jukes.laihuo.activity.home.NearbyPersonActivity;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.Singleton;

import org.xutils.x;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 作者：Jason_Jukes on 2018/9/20 0020 16:39
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class App extends Application {

    private static Map<String, Activity> destoryMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        //XUtils3 初始化
        x.Ext.init(this);
        SPTool.getInstance().setApp(this);

        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);



    }



    /**
     * 添加待销毁Activity
     */
    public static void addDestoryActivity(Activity activity, String activityName) {
        destoryMap.put(activityName, activity);
    }

    /**
     * 销毁指定Activity
     */
    public static void destoryActivity(String activityName) {
        Set<String> keySet = destoryMap.keySet();
        for (String key : keySet) {
            destoryMap.get(key).finish();
        }
    }

}
