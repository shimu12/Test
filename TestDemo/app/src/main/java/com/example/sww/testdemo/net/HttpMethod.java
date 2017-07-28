package com.example.sww.testdemo.net;

import android.content.Context;
import android.util.Log;

import com.example.sww.testdemo.common.Constant;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private  Context context;

    //构造方法私有
    private HttpMethod(Context context) {

        this.context = context;
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .cookieJar(new CookieManger(context));

        retrofit = new Retrofit.Builder()
                .client(builder.build())
//                .addConverterFactory(GsonConverterFactory.create())
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


    public void getVersrionCode(Map<String,String> valueMap, Subscriber subscriber){
        ApiService testService = retrofit.create(ApiService.class);
        testService
                .getVersionCode(valueMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 挑货网登陆
     * @param userName
     * @param valueMap
     * @param subscriber
     */
    public void loginTiaohuo(String userName, Map<String,String> valueMap, Subscriber subscriber){

        ApiService testService = retrofit.create(ApiService.class);
        testService
                .loginTiaohuo(valueMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


//    class SaveCookiesInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Response originalResponse = chain.proceed(chain.request());
//
//            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
//                HashSet<String> cookies = new HashSet<>();
//
//                for (String header : originalResponse.headers("Set-Cookie")) {
//                    cookies.add(header);
//                }
//
//                Preferences.getDefaultPreferences().edit()
//                        .putStringSet(Preferences.PREF_COOKIES, cookies)
//                        .apply();
//            }
//
//            return originalResponse;
//        }
//    }
//
//
//    class LogginInterceptor implements Interceptor{
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            Request.Builder builder = chain.request().newBuilder();
//            HashSet<String> preferences = (HashSet) Preferences.getDefaultPreferences().getStringSet(Preferences.PREF_COOKIES, new HashSet<>());
//            for (String cookie : preferences) {
//                builder.addHeader("Cookie", cookie);
//                Log.v("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
//            }
//
//            return chain.proceed(builder.build());
//        }
//    }



    //获取单例
    public static HttpMethod getInstance(Context context) {
        if (instance == null) {
            instance = new HttpMethod(context);
        }


        return instance;
    }

}
