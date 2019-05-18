package com.example.materialdesignfirsttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LinearActivity extends AppCompatActivity {
    Button frameLayoutBtn;
    Button gridLayoutBtn;
    Button  relativeLayoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        frameLayoutBtn=(Button)findViewById(R.id.frameLayoutBtn);
        gridLayoutBtn=(Button)findViewById(R.id.gridLayoutBtn);
        relativeLayoutBtn=(Button)findViewById(R.id.relativeLayoutBtn);
        gridLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GridActivity.class);
                startActivity(intent);

            }
        });
        frameLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
        relativeLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RelativeActivity.class);
                startActivity(intent);
            }
        });

    }
}
