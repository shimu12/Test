package com.example.sww.testdemo.net;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by shiweiwei on 2017/5/17.
 */

public interface ApiService {

    /**
     * 多参数表单提交
     * @param name
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/TestServlet/HelloWorld")
    Observable<Response<ResponseBody>> getLogin(@Field("name") String name, @Field("password") String password);

    /**
     * 获取验证码
     * @param map
     * @return
     */
    @GET("app/auth-get.jhtml")
    Observable<Response<ResponseBody>> getVersionCode(@QueryMap Map<String,String> map);


    /**
     * 挑货网登陆
     * @param map
     * @return
     */
    @GET("app/auth-login.jhtml")
    Observable<Response<ResponseBody>> loginTiaohuo(@QueryMap Map<String,String> map);

}
