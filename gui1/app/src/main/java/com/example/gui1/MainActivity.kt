package com.example.helloworldcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    Button redButton, greenButton, blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = findViewById(R.id.helloText);
        redButton = findViewById(R.id.redButton);
        greenButton = findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);

        redButton.setOnClickListener(v -> helloText.setTextColor(Color.RED));
        greenButton.setOnClickListener(v -> helloText.setTextColor(Color.GREEN));
        blueButton.setOnClickListener(v -> helloText.setTextColor(Color.BLUE));
    }
}
