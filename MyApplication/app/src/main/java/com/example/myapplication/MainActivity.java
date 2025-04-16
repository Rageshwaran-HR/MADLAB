package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    Button red, green, blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = findViewById(R.id.helloText);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);

        red.setOnClickListener(v -> helloText.setTextColor(Color.RED));
        green.setOnClickListener(v -> helloText.setTextColor(Color.GREEN));
        blue.setOnClickListener(v -> helloText.setTextColor(Color.BLUE));
    }
}
