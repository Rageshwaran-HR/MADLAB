package com.example.multithreading;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startThreadButton;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI components
        startThreadButton = findViewById(R.id.startThreadButton);
        statusTextView = findViewById(R.id.statusTextView);

        // Set click listener for the button
        startThreadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the background thread
                startBackgroundThread();
            }
        });
    }

    // Method to start a background thread
    private void startBackgroundThread() {
        // Create a new thread
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Perform background task (e.g., simulate a delay)
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds (simulating work)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // After background task is complete, update the UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        statusTextView.setText("Status: Task Completed");
                    }
                });
            }
        });

        // Start the background thread
        backgroundThread.start();
        statusTextView.setText("Status: Working...");
    }
}
