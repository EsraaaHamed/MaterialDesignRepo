package com.example.materialdesignfirsttask;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GridActivity extends AppCompatActivity {
    ImageView firstImage;
    ImageView secondImage;
    ImageView thirdImage;
    ImageView fourthImage;
    ImageView fifthImage;
    ImageView sixthImage;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        firstImage=(ImageView)findViewById(R.id.imageView8);
        secondImage=(ImageView)findViewById(R.id.imageView9);
        thirdImage=(ImageView)findViewById(R.id.imageView10);
        fourthImage=(ImageView)findViewById(R.id.imageView11);
        fifthImage=(ImageView)findViewById(R.id.imageView12);
        sixthImage=(ImageView)findViewById(R.id.imageView13);
        image7=(ImageView)findViewById(R.id.imageView14);
        image8=(ImageView)findViewById(R.id.imageView15);
        image9=(ImageView)findViewById(R.id.imageView16);

        firstImage.setImageResource(R.drawable.apple);
        secondImage.setImageResource(R.drawable.fruit_watermellon);
        thirdImage.setImageResource(R.drawable.orange);
        fourthImage.setImageResource(R.drawable.strawberry);
        fifthImage.setImageResource(R.drawable.food);
        sixthImage.setImageResource(R.drawable.anas);
        image7.setImageResource(R.drawable.anas);
        image8.setImageResource(R.drawable.apple);
        image9.setImageResource(R.drawable.anas);
    }
}
