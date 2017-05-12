package com.example.sww.testdemo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sww on 2017/3/6 14:30.
 */

public class Utils {

    /**
     * 判断网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetConnectAvailable(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();

    }
}
