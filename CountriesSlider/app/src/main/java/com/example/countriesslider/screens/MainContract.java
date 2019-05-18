package com.example.countriesslider.screens;

import android.graphics.Bitmap;

import com.example.countriesslider.model.Country;

import java.util.List;

public interface MainContract {
     interface MainView {
         void setCountry(Country country);

         void showToastMsg(String s);

         void setBitmapImg(Bitmap img);
     }
     interface MainPresenter {
         void setCountrieList(List<Country> countrieList);
         Country getCountry(int countryPosition);
         void getCountryImg(int countryPosition);
         void setBitmapImge(Bitmap img);
     }

}
