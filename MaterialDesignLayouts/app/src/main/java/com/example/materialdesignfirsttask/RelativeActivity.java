package com.example.materialdesignfirsttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class RelativeActivity extends AppCompatActivity {
Button addbtn;
EditText itemTxt;
ListView itemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        addbtn=(Button)findViewById(R.id.addBtn);
        itemTxt=(EditText)findViewById(R.id.itemTxt);
        itemsList=(ListView)findViewById(R.id.listView);
        final ArrayAdapter arrayAdapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.add(itemTxt.getText().toString());
                itemsList.setAdapter(arrayAdapter);
            }
        });
    }
}
