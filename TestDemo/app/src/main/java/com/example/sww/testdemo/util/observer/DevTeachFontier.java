package com.example.sww.testdemo.util.observer;

import java.util.Observable;

/**
 * 被观察者
 * Created by sww on 2017/3/3 16:55.
 */

public class DevTeachFontier extends Observable{


    public void postNewPublication(String content){

        setChanged();
        notifyObservers(content);
    }

}
