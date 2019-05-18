package com.example.countriesslider.model.NetworkServices;


import android.os.Message;

import com.example.countriesslider.model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable
{
    String url="https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    List<Country> countryList;
    Country country ;
    MyHandler mainHandler;

    public MyThread(MyHandler myHandler) {
        countryList= new ArrayList<>();
        mainHandler=myHandler;
    }

    @Override
    public void run() {


        try
        {
            URL urlConnection=new URL(url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) urlConnection.openConnection();
            httpURLConnection.connect();
            InputStream inputStream=httpURLConnection.getInputStream();
            String result=convertStreamToString(inputStream);
            try
            {
                JSONObject jsonObject=new JSONObject(result);
                JSONArray worldpopulation=jsonObject.getJSONArray("worldpopulation");
                for(int i=0; i<worldpopulation.length();i++)
                {
                    JSONObject eachCountry= worldpopulation.getJSONObject(i);
                    String rank=eachCountry.getString("rank");
                    final String countryName=eachCountry.getString("country");
                    String population=eachCountry.getString("population");
                    String imgUrl=eachCountry.getString("flag").replaceFirst("http","https");
                    //imgUrl.replaceFirst("http","https");
                    country= new Country(rank,countryName,population,imgUrl);
                    countryList.add(country);
                }
                Message msg=new Message();
                msg.obj=countryList;
                mainHandler.sendMessage(msg);

            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringStream=new StringBuilder();
        String eachLine;
        while((eachLine=bufferedReader.readLine())!=null)
        {
            stringStream.append(eachLine);
            stringStream.append("\n");
        }
        inputStream.close();

        return stringStream.toString();
    }
}
