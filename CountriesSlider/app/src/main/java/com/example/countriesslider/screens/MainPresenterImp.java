package com.example.countriesslider.screens;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.example.countriesslider.model.Country;
import com.example.countriesslider.model.NetworkServices.NetworkServiceImp;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImp implements MainContract.MainPresenter {
    MainContract.MainView mainActivityRef;
    List<Country> returnCountryList;
    List<Bitmap> countriesImg;
    Bitmap flagImg;
    public final static String TAG="presenter";
    NetworkServiceImp networkServiceImp;

    public MainPresenterImp(MainContract.MainView mainView) {
        networkServiceImp=new NetworkServiceImp(this);
        returnCountryList= new ArrayList<>();
        mainActivityRef=mainView;
        Log.i(TAG,"constructor");
    }

    @Override


    public void setCountrieList(List<Country> countrieList)
    {
        Log.i(TAG,"setCountriesList");
        this.returnCountryList=countrieList;
        setFirstCountry();
        getCountryImg(0);

    }
    public Country getCountry(int countryPosition)
    {
        Log.i(TAG,"getCountry");
        if(returnCountryList.size()==0)
            return null;
        return returnCountryList.get(countryPosition);
    }
    public void getCountryImg(int countryPosition)
    {
       networkServiceImp.getCountryImg(countryPosition);
    }
    public void setFirstCountry()
    {
        mainActivityRef.setCountry(returnCountryList.get(0));
    }
    public void setBitmapImge(Bitmap img)
    {
        mainActivityRef.setBitmapImg(img);
    }


}
