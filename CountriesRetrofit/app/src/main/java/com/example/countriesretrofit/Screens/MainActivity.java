package com.example.countriesretrofit.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.countriesretrofit.Model.Worldpopulation;
import com.example.countriesretrofit.Model.networkServices.RetrofitResponseInterface;
import com.example.countriesretrofit.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    MainContract.MainPresenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Worldpopulation> worldpopulationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter= new MainPresenterImp(this);
        recyclerView = (RecyclerView) findViewById(R.id.countries_RecycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public void takeTheListAfterDownloading(List<Worldpopulation> worldpopulationArrayList) {
        this.worldpopulationArrayList=worldpopulationArrayList;
        mAdapter = new MyAdapter(worldpopulationArrayList);
        recyclerView.setAdapter(mAdapter);
    }
}
