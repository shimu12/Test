package com.example.sww.testdemo.factory;

import android.util.Log;
import android.widget.Toast;

import com.example.sww.testdemo.server.Sender;

/**
 * 工厂模式：把创建shili，和使用实力分开
 * Created by sww on 2016/10/25 14:47.
 */

public class SendFactory {

//    public Sender produce(String type)
//    {
//        if ("mail".equals(type))
//        {
//            return new MailSender();
//        }else if ("smsMail".equals(type))
//        {
//            return new SmsSender();
//        }else
//        {
//            Log.e("----send---", "----error----");
//            return null;
//        }
//    }

    public static Sender produceMail()
    {
        return new MailSender();
    }

    public static Sender produceSms()
    {
        return new SmsSender();
    }

}
