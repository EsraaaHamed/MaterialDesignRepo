package com.example.materialdesignlab2day2navigationdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    FloatingActionButton floatingActionButtonTwo;
    Animation scale;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<String> worldpopulationArrayList;
    NavigationView navigationView;
    boolean isFABOpen=false;

    public MainActivity() {
        worldpopulationArrayList=new ArrayList<>();
        worldpopulationArrayList.add("Flower 1");
        worldpopulationArrayList.add("flower 2");
        worldpopulationArrayList.add("Flower 3");
        worldpopulationArrayList.add("Flower 4");

        worldpopulationArrayList.add("Flower 5");

        worldpopulationArrayList.add("Flower 6");

        worldpopulationArrayList.add("Flower 7");

    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButtonTwo=(FloatingActionButton)findViewById(R.id.fabtwo);
        floatingActionButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFABTwoTrans();
            }
        });

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.countries_RecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hey", Toast.LENGTH_SHORT).show();
            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(worldpopulationArrayList);
        recyclerView.setAdapter(mAdapter);
        navigationView=(NavigationView)findViewById(R.id.nav_view);

        scale= AnimationUtils.loadAnimation(this,R.anim.surface_elevation);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFABTrans();

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.firstItem) {
                    Intent intent = new Intent(MainActivity.this, ExitEnterAnim.class);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.in, R.anim.out);

                }
                return true;
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    private void showFABTrans(){
        isFABOpen=true;
        TranslateAnimation translateAnimation= new TranslateAnimation(0.0f, -55.0f, 0.0f, 0.0f);
        translateAnimation.setStartTime(0);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(1);
        floatingActionButton.startAnimation(translateAnimation);
    }
    private void showFABTwoTrans(){

        floatingActionButtonTwo.startAnimation(scale);
    }
}
