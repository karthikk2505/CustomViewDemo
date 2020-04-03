package com.kb.customviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button clickme;
    LovelyView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickme=findViewById(R.id.clickmeBt);
        lv=(LovelyView)findViewById(R.id.custview);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setCircleColor(Color.GREEN);
                lv.setLabelColor(Color.MAGENTA);
                lv.setLabelText("Help");
            }
        });
    }
}
