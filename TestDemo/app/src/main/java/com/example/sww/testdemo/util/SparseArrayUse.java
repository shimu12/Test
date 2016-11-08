package com.example.sww.testdemo.util;

import android.util.Log;
import android.util.SparseArray;

/**
 * Created by sww on 2016/10/27 14:09.
 */

public class SparseArrayUse {

    private SparseArray<String> integerSparseArray;



    private void test()
    {
        integerSparseArray = new SparseArray<>();
        for (int i = 0; i < 10; i++)
        {
            integerSparseArray.put(i,"start_1" + i);

            
        }
    }
}
