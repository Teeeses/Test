package com.example.test;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by develop on 18.05.2016.
 */
public interface ServiceAPI {


    //http://api.prostor-sms.ru/messages/v2/send/?phone=%2B79056471378&text=test&login=ap136013&password=756379

    @GET("/messages/v2/send/")
    Call<Object> sendRequest(@Query("phone") String phone, @Query("text") String text, @Query("login") String login, @Query("password") String password);

    /*@GET("/messages/v2/send/")
    Call<Object> sendRequest(@FieldMap Map<String, String> map);*/
}
