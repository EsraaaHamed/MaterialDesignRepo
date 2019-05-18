package com.example.countriesslider.model.NetworkServices;

import android.os.Handler;
import android.os.Message;

import com.example.countriesslider.model.Country;
import com.example.countriesslider.screens.MainActivity;
import com.example.countriesslider.screens.MainContract;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyHandler  extends Handler {
    List<Country> returnCountryList;
    MainContract.MainPresenter presenter;
    public MyHandler( MainContract.MainPresenter presenter) {
        this.presenter=presenter;
    }

    public List<Country> getReturnCountryList() {
        return returnCountryList;
    }

    public void setReturnCountryList(List<Country> returnCountryList) {
        this.returnCountryList = returnCountryList;
    }

    @Override
    public void handleMessage(Message msg) {

        returnCountryList = new ArrayList<>();
        returnCountryList = (List<Country>) msg.obj;
        presenter.setCountrieList(returnCountryList);

    }
}
