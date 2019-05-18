package com.example.countriesslider.screens;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.countriesslider.R;
import com.example.countriesslider.model.Country;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    EditText countryName;
    EditText rank;
    EditText population;
    ImageView countryImg;
    Button backBtn;
    Button nextBtn;
    int counter=0;
    MainContract.MainPresenter mainPresenter;
    Country country;
    public MainActivity() {
        mainPresenter=new MainPresenterImp(this);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        countryName=(EditText)findViewById(R.id.name);
        rank=(EditText)findViewById(R.id.rank);
        population=(EditText)findViewById(R.id.popuation);
        countryImg=(ImageView)findViewById(R.id.countryImg);
        backBtn=(Button)findViewById(R.id.backBtn);
        nextBtn=(Button)findViewById(R.id.nextBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                if(counter<0)
                    counter=9;
                country=mainPresenter.getCountry(counter);
                mainPresenter.getCountryImg(counter);
                countryImg.setImageBitmap(null);
                if(country==null) {
                    Toast.makeText(getApplicationContext(), "Please Wait the Country List Isn't Loaded yet", Toast.LENGTH_SHORT).show();
                    counter--;
                }
                else {
                    mainPresenter.getCountryImg(counter);
                    setCountry(country);
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter>9)
                    counter=0;
                country=mainPresenter.getCountry(counter);
                countryImg.setImageBitmap(null);
                if(country==null) {
                    Toast.makeText(getApplicationContext(), "Please Wait the Country List Isn't Loaded yet", Toast.LENGTH_SHORT).show();
                    counter--;
                }
                else {
                    mainPresenter.getCountryImg(counter);
                    setCountry(country);
                }
            }
        });

    }


    @Override
    public void setCountry(Country country) {
        countryName.setText(country.getName());
        rank.setText(country.getRank());
        population.setText(country.getPopulation());
    }

    @Override
    public void showToastMsg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setBitmapImg(Bitmap img) {
        countryImg.setImageBitmap(img);
    }
}
