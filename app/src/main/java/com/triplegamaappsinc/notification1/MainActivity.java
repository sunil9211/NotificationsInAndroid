package com.triplegamaappsinc.notification1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    Button buttonC1, buttonC2;

    NotificationManagerCompat notificationManagerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat= NotificationManagerCompat.from(this);

        buttonC1 = findViewById(R.id.buttonC1);
        buttonC2 = findViewById(R.id.buttonC2);

        buttonC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel1();
            }
        });

        buttonC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel2();
            }
        });
    }

    public void sendOnChannel1()
    {
        new NotificationClass().createMyNotificationChannels();

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_layout1);
        RemoteViews remoteViews1 = new RemoteViews(getPackageName(), R.layout.custom_layout2);

        Notification notification = new NotificationCompat.Builder(this, NotificationClass.C1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle(editTextC1title.getText().toString())
//                .setContentText(editTextC1Des.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(remoteViews)
                .setCustomBigContentView(remoteViews1)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnChannel2()
    {
        new NotificationClass().createMyNotificationChannels();

        Notification notification = new NotificationCompat.Builder(this, NotificationClass.C2_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
