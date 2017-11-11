 package com.example.ayush.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("Messages")
                  .setContentText("Events received");
                //sets content and text when not in expanded form
                NotificationCompat.InboxStyle inboxStyle =
                        new NotificationCompat.InboxStyle();
                //Strings which depict a conversation
                String[] events = new String[]{"Hello there","Hi","How are You","I am great,how are you??"};
// Sets a title for the Inbox in expanded form
                inboxStyle.setBigContentTitle("Event tracker details:");

// Moves events into the expanded form
                for (int i=0; i < events.length; i++) {
                    inboxStyle.addLine(events[i]);
                }
// Moves the expanded layout object into the notification object.
                builder.setStyle(inboxStyle);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //builds the notification
                mNotificationManager.notify(1, builder.build());


            }
        });
    }
}
