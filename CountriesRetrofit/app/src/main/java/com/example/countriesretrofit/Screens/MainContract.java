package com.example.countriesretrofit.Screens;

import com.example.countriesretrofit.Model.Worldpopulation;

import java.util.List;

public interface MainContract {
     interface MainView
    {

        void takeTheListAfterDownloading(List<Worldpopulation> worldpopulationArrayList);
    }
     interface MainPresenter
    {

        void setList(List<Worldpopulation> worldpopulationArrayList);

    }
}
