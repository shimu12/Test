package com.example.sww.testdemo.factory;

import com.example.sww.testdemo.server.Provider;
import com.example.sww.testdemo.server.Sender;

/**
 * Created by sww on 2016/10/25 17:31.
 */

public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
