package com.example.materialdesignlab2day2navigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExitEnterAnim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_enter_anim);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.out, R.anim.in);

    }

    @Override
    public void finish() {
        super.finish();

    }
}
