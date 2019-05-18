package com.example.countriesretrofit.Model.networkServices;

import com.example.countriesretrofit.Model.JsonResp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitResponseInterface {
    @GET("tutorial/jsonparsetutorial.txt")
    Call<JsonResp> getList();
}
