package com.example.sww.testdemo.factory;

import android.util.Log;

import com.example.sww.testdemo.server.Sender;

/**
 * Created by sww on 2016/10/25 14:45.
 */

public class SmsSender implements Sender{
    @Override
    public void Sender() {

        Log.e("------send------", "this is sms sender");
    }
}
