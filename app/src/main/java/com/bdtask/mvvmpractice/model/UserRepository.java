package com.bdtask.mvvmpractice.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bdtask.mvvmpractice.AppConfig;
import com.bdtask.mvvmpractice.POSService;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    POSService posService;
    private String TAG = "Testing";

    public UserRepository() {
        posService = AppConfig.getRetrofit().create(POSService.class);
    }

    public LiveData<UserResponse> getUserData() {
        final MutableLiveData<UserResponse> data = new MutableLiveData<>();
            posService.getUser().enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    Log.d(TAG, "onResponse: " + new Gson().toJson(response.body()));
                    data.setValue(response.body());
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                }
            });
        return data;
    }
}
