package com.example.sww.testdemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sww on 2016/10/25 15:04.
 */

public class ToastUtil {

    public static void showToast(Context context,String message)
    {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
