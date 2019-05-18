package com.example.materialdesignfirsttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {
Button appleBtn;
Button strawberryBtn;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        appleBtn=(Button)findViewById(R.id.appleBtn);
        strawberryBtn=(Button)findViewById(R.id.strwApple);
        img=(ImageView)findViewById(R.id.child1);
        appleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.apple);
            }
        });
        strawberryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.strawberry);
            }
        });
    }
}
