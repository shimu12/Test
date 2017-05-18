package com.example.sww.testdemo.net;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
}
