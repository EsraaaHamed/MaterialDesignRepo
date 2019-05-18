package com.example.countriesslider.model.NetworkServices;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.countriesslider.screens.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImage extends AsyncTask<URL,Void, Bitmap>
{
    MainContract.MainPresenter presenter;
    public DownloadImage(MainContract.MainPresenter presenter)
    {
        this.presenter=presenter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        presenter.setBitmapImge(bitmap);

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        URL url;
        HttpURLConnection httpURLConnection;

        if(urls[0].equals(""))
        {
            //Toast.makeText(getApplicationContext(), "Please enter a Url", Toast.LENGTH_SHORT).show();

        }
        else
        {
            url=urls[0];
            try
            {
                httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                Bitmap result= BitmapFactory.decodeStream(inputStream);
                return result;

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
