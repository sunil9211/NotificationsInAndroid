package com.triplegamaappsinc.notification1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationClass extends Application {

    public static final String C1_ID = "channel1";
    public static final String C2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createMyNotificationChannels();
    }
    public void createMyNotificationChannels()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(C1_ID, "channel1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("My channel 1.");
            NotificationChannel notificationChannel2 = new NotificationChannel(C2_ID, "channel2", NotificationManager.IMPORTANCE_LOW);
            notificationChannel2.setDescription("My channel 2.");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(notificationChannel2);

        }
    }
}
