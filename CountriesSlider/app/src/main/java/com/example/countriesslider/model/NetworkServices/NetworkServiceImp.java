package com.example.countriesslider.model.NetworkServices;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.countriesslider.model.Country;
import com.example.countriesslider.screens.MainActivity;
import com.example.countriesslider.screens.MainContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NetworkServiceImp  {
    MyHandler mainHandler;
    Country country;
    MainContract.MainPresenter presenter;
    MyThread myThread ;
    public final static String TAG="networkService";
    public NetworkServiceImp(MainContract.MainPresenter presenter) {
        country= new Country();

        this.presenter=presenter;
        mainHandler=new MyHandler(presenter);
        myThread= new MyThread(mainHandler);
        Thread thread=new Thread(myThread);
        thread.start();

    }
    public void getCountryImg(int contryPos)
    {
        try
        {
            URL imgUrl = new URL(mainHandler.getReturnCountryList().get(contryPos).getImageurl());
            DownloadImage downloadImage = new DownloadImage(presenter);
            downloadImage.execute(imgUrl);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


}
