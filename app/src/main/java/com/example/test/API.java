package com.example.test;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface API {

    @FormUrlEncoded
    @GET("/user/edit")
    Call<Object> translate(@FieldMap Map<String, String> map);

}
