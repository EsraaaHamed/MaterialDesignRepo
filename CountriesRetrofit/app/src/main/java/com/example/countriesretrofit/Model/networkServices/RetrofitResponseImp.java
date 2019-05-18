package com.example.countriesretrofit.Model.networkServices;

import com.example.countriesretrofit.Model.JsonResp;
import com.example.countriesretrofit.Model.Worldpopulation;
import com.example.countriesretrofit.Screens.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitResponseImp{
    MainContract.MainPresenter presenter;
    public RetrofitResponseImp(final MainContract.MainPresenter presenter) {
        this.presenter=presenter;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.androidbegin.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitResponseInterface service = retrofit.create(RetrofitResponseInterface.class);

        Call<JsonResp> responseList =service.getList();

        responseList.enqueue(new Callback<JsonResp>() {
            @Override
            public void onResponse(Call<JsonResp> call, Response<JsonResp> response) {
                JsonResp jasonResponse=new JsonResp();
                jasonResponse =response.body();
                List<Worldpopulation> worldpopulationArrayList=jasonResponse.getWorldpopulation();
                presenter.setList(worldpopulationArrayList);
            }

            @Override
            public void onFailure(Call<JsonResp> call, Throwable t) {

            }
        });
    }





}
