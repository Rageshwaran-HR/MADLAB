package com.example.database;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button saveButton, viewButton;
    TextView resultText;
    MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        saveButton = findViewById(R.id.saveButton);
        viewButton = findViewById(R.id.viewButton);
        resultText = findViewById(R.id.resultText);

        dbHelper = new MyDBHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                dbHelper.insertName(name);
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
                nameInput.setText("");
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = dbHelper.getAllNames();
                resultText.setText(names);
            }
        });
    }
}
