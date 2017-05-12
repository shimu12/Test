package com.example.sww.testdemo.util.observer;

import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;

/**
 * Created by sww on 2017/3/3 17:05.
 */

public class ObserverTest {

    public static void main(String[] args){

        //被观察者
        DevTeachFontier devTeachFontier = new DevTeachFontier();

        Coder simple = new Coder("simple");
        Coder coder1 = new Coder("code1");

        devTeachFontier.addObserver(simple);
        devTeachFontier.addObserver(coder1);

        devTeachFontier.postNewPublication("新的一期内容要发布了");
    }
}
