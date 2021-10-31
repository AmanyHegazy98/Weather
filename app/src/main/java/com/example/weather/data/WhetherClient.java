package com.example.weather.data;

import com.example.weather.data.models.Weather;
import com.example.weather.data.models.WhetherModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WhetherClient {
    public static final String BASE_URL = "https://api.openweathermap.org";

    private WhetherInterface whetherInterface;
    public static WhetherClient INSTANCE;

    public WhetherClient() {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        whetherInterface = retrofit.create(WhetherInterface.class);


    }


    public static WhetherClient getInstance() {
        if (INSTANCE == null) {
           INSTANCE = new WhetherClient();
        }
        return INSTANCE;
    }

    public Call<WhetherModel> getWhether(){
       return   whetherInterface.getWhether();
    }


}
