package com.example.sww.testdemo.util.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 * Created by sww on 2017/3/3 16:40.
 */

public class Coder implements Observer{

    public String name;
    public Coder(String aName){
        name = aName;
    }

    @Override
    public void update(Observable observable, Object data) {

        System.out.println("Hi" + name+", 更新啦，内容：" + data);
    }

    @Override
    public String toString() {
        return "码农：" + name;
    }
}
