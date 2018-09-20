package com.example.jason_jukes.laihuo;

import android.app.Activity;
import android.app.Application;

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

public class App extends Application{

    private static Map<String, Activity> destoryMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        //XUtils3 初始化
        x.Ext.init(this);


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
