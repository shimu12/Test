package com.example.sww.testdemo.factory;

import com.example.sww.testdemo.server.Provider;
import com.example.sww.testdemo.server.Sender;

/**
 * Created by sww on 2016/10/25 17:30.
 */

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }



}
