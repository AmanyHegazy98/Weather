package com.example.weather.ui.viewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weather.data.WhetherClient;
import com.example.weather.data.WhetherInterface;
import com.example.weather.data.models.ListModel;
import com.example.weather.data.models.WhetherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WhetherViewModel extends ViewModel {
    MutableLiveData<WhetherModel> mutableLiveData=new MutableLiveData<>();
    WhetherClient whetherClient;

    public WhetherViewModel() {
        WhetherClient.getInstance().getWhether().enqueue(new Callback<WhetherModel>() {
            @Override
            public void onResponse(Call<WhetherModel> call, Response<WhetherModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WhetherModel> call, Throwable t) {

                Log.d("amany", "onFailure: "+t.getMessage());

            }
        });


    }

    public MutableLiveData<WhetherModel> getWhether() {
        return  mutableLiveData;
    }
}
