package com.example.weather.data;

import com.example.weather.data.models.WhetherModel;

import retrofit2.Call;
import retrofit2.http.GET;
public interface WhetherInterface {
    @GET("/data/2.5/forecast?id=360630&appid=10a90bee4ffb717043f2053fa2acd2a8")
    Call <WhetherModel>getWhether();

}
