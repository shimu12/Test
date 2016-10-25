package com.example.sww.testdemo.factory;

import android.util.Log;

import com.example.sww.testdemo.server.Sender;

/**
 * Created by sww on 2016/10/25 14:40.
 */

public class MailSender implements Sender{


    @Override
    public void Sender() {

        Log.e("------send----","this is mailSender");
    }
}
