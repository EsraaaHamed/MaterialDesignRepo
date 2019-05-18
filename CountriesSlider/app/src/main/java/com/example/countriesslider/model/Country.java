package com.example.countriesslider.model;

import android.graphics.Bitmap;

public class Country {
    String rank;
    String name;
    String population;
    String imageurl;
    //Bitmap coutryImg;


    public Country() {
    }

    public Country(String rank, String name, String population, String imageurl) {
        this.rank = rank;
        this.name = name;
        this.population = population;
        this.imageurl = imageurl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

   /* public Bitmap getCoutryImg() {
        return coutryImg;
    }

    public void setCoutryImg(Bitmap coutryImg) {
        this.coutryImg = coutryImg;
    }*/
}
