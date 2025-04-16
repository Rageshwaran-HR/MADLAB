package com.example.email;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailRecipient, emailSubject, emailMessage;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailRecipient = findViewById(R.id.emailRecipient);
        emailSubject = findViewById(R.id.emailSubject);
        emailMessage = findViewById(R.id.emailMessage);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String recipient = emailRecipient.getText().toString();
        String subject = emailSubject.getText().toString();
        String message = emailMessage.getText().toString();

        // Creating the Intent to send email
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // Set the type to email

        // Adding recipient, subject, and body
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        // Open email app
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
