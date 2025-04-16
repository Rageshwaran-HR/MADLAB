package com.example.nativecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText t1, t2, t3;
    TextView t4, t5;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts and Buttons
        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        t4 = findViewById(R.id.textView1);
        t5 = findViewById(R.id.textView2);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        b15 = findViewById(R.id.button15);
        b16 = findViewById(R.id.button16);

        // Number button listeners
        setNumberButtonListener(b1, "1");
        setNumberButtonListener(b2, "2");
        setNumberButtonListener(b3, "3");
        setNumberButtonListener(b4, "4");
        setNumberButtonListener(b5, "5");
        setNumberButtonListener(b6, "6");
        setNumberButtonListener(b7, "7");
        setNumberButtonListener(b8, "8");
        setNumberButtonListener(b9, "9");
        setNumberButtonListener(b11, "0");

        // Operation buttons
        b10.setOnClickListener(v -> t3.setText("+"));
        b13.setOnClickListener(v -> t3.setText("-"));
        b14.setOnClickListener(v -> t3.setText("*"));
        b15.setOnClickListener(v -> t3.setText("/"));

        // Clear button
        b16.setOnClickListener(v -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });

        // Equal button
        b12.setOnClickListener(v -> {
            String operator = t3.getText().toString();
            try {
                int a = Integer.parseInt(t1.getText().toString());
                int b = Integer.parseInt(t2.getText().toString());

                int result = 0;
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            Toast.makeText(getApplicationContext(), "Cannot divide by zero", Toast.LENGTH_LONG).show();
                            return;
                        }
                        result = a / b;
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Invalid Operation", Toast.LENGTH_SHORT).show();
                        return;
                }

                Toast.makeText(getApplicationContext(), "Result: " + result, Toast.LENGTH_LONG).show();
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setNumberButtonListener(Button button, final String number) {
        button.setOnClickListener(v -> {
            EditText e = (EditText) getCurrentFocus();
            if (e != null) {
                e.setText(e.getText().toString() + number);
            }
        });
    }
}
