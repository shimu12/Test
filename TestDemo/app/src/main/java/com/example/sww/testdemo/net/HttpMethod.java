package com.example.sww.testdemo.net;

import com.example.sww.testdemo.common.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shiweiwei on 2017/5/17.
 */

public class HttpMethod {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private Retrofit retrofitMall;
    private Retrofit retrofitServerFFlibray;
    private static HttpMethod instance;

    //构造方法私有
    private HttpMethod() {

        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();


    }

    /**
     * 登陆
     * @param name
     * @param password
     * @param subscriber
     */
    public void login(String name, String password, Subscriber subscriber){
        ApiService testService = retrofit.create(ApiService.class);
        testService
                .getLogin(name, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    //获取单例
    public static HttpMethod getInstance() {
        if (instance == null) {
            instance = new HttpMethod();
        }
        return instance;
    }

}
