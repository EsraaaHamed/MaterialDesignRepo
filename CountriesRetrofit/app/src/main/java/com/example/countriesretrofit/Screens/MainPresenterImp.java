package com.example.countriesretrofit.Screens;

import com.example.countriesretrofit.Model.Worldpopulation;
import com.example.countriesretrofit.Model.networkServices.RetrofitResponseImp;

import java.util.List;

public class MainPresenterImp implements MainContract.MainPresenter {
    List<Worldpopulation> worldpopulationArrayList;
    RetrofitResponseImp retrofitResponseImp;
    MainContract.MainView mainView;

    public MainPresenterImp(MainContract.MainView mainView) {
        retrofitResponseImp= new RetrofitResponseImp(this);
        this.mainView=mainView;

    }

    @Override
    public void setList(List<Worldpopulation> worldpopulationArrayList) {
        this.worldpopulationArrayList=worldpopulationArrayList;
        mainView.takeTheListAfterDownloading(worldpopulationArrayList);

    }

}
