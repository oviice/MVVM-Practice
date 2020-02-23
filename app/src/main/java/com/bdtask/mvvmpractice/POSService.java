package com.bdtask.mvvmpractice;


import com.bdtask.mvvmpractice.model.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface POSService {
    @GET("api")
    Call<UserResponse> getUser();
}
