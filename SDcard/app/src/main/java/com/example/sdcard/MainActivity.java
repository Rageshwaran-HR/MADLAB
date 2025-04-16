package com.example.sdcard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;
    private Button writeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        writeButton = findViewById(R.id.writeButton);
        statusTextView = findViewById(R.id.statusTextView);

        // Set button click listener
        writeButton.setOnClickListener(v -> writeToSDCard());
    }

    private void writeToSDCard() {
        // Check if permission is granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return;
        }

        // Check if external storage is available
        if (isExternalStorageWritable()) {
            File dir = new File(Environment.getExternalStorageDirectory(), "MyAppData");
            if (!dir.exists()) {
                dir.mkdirs(); // Create directory if not exists
            }

            // Create a file inside that directory
            File file = new File(dir, "myFile.txt");

            try (FileOutputStream fos = new FileOutputStream(file)) {
                String data = "Hello, this is a test data written to the SD card!";
                fos.write(data.getBytes()); // Write data to file
                statusTextView.setText("Data written successfully!");
            } catch (IOException e) {
                statusTextView.setText("Failed to write data: " + e.getMessage());
            }
        } else {
            statusTextView.setText("External Storage not available.");
        }
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                writeToSDCard(); // Retry writing if permission is granted
            } else {
                Toast.makeText(this, "Permission denied to write to external storage", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
