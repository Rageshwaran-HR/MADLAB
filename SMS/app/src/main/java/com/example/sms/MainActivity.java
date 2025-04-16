package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    private String phoneNo,message;
    private Button b;
    private EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextTextPersonName);

        e2 = findViewById(R.id.editTextTextPersonName2);
        b = findViewById(R.id.button);
        SmsManager smsManager = SmsManager.getDefault();
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = e1.getText().toString();
                message = e2.getText().toString();
                try {
                    SmsManager smsManager1 = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"SMS failed , Please try again later!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}