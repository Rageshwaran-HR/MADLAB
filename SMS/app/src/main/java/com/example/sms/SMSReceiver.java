package com.example.sms;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the SMS message.
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[0]);

        // Get the message body
        String messageBody = message.getMessageBody();

        // Display the message using Toast (for testing)
        Toast.makeText(context, "Received: " + messageBody, Toast.LENGTH_SHORT).show();

        // Send the message to MainActivity
        Intent activityIntent = new Intent(context, MainActivity.class);
        activityIntent.putExtra("message", messageBody);
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(activityIntent);
    }
}
