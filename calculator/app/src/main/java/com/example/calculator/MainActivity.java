package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button addButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        addButton = findViewById(R.id.addButton);
        resultText = findViewById(R.id.resultText);

        addButton.setOnClickListener(v -> {
            try {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());
                int sum = n1 + n2;
                resultText.setText("Result: " + sum);
            } catch (NumberFormatException e) {
                resultText.setText("Please enter valid numbers");
            }
        });
    }
}
