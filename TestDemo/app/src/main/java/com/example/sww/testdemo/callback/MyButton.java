package com.example.sww.testdemo.callback;

import com.example.sww.testdemo.server.MyClickListener;

/**
 * Created by sww on 2016/11/1 09:04.
 */

public class MyButton {

    private MyClickListener listener;

    public void setOnClickListener (MyClickListener listener)
    {
        this.listener = listener;
    }

    public void doClick()
    {
        listener.onClick("123");
    }

}
