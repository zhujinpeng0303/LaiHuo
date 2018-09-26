package com.example.jason_jukes.laihuo.tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2017/11/23 0023.
 */


//  判断网络状态
public class IsNetWork {

    public static boolean isNetWork(Context context) {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        } else {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            // networkInfo.isConnectedOrConnecting();
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            return true;
        }
    }

}
