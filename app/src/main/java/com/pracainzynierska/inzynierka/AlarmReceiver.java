package com.pracainzynierska.inzynierka;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.pracainzynierska.inzynierka.SettingsActivity.NOTIFICATION_CHANNEL_ID;

public class AlarmReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 0;

    public AlarmReceiver() {


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(NOTIFICATION_SERVICE);

        //Create the content intent for the notification, which launches this activity
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.basic_logo)
                .setContentTitle("Lucid Brain")
                .setContentText("Start Your Daily Training")
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(String.valueOf(NOTIFICATION_CHANNEL_ID), "NOTIFICATION_CHANNEL_NAME", importance);

            builder.setChannelId(String.valueOf((int) NOTIFICATION_CHANNEL_ID));
            notificationManager.createNotificationChannel(notificationChannel);
        }

        //Deliver the notification
        notificationManager.notify(NOTIFICATION_ID, builder.build());
        Log.d("Alarm","Alarm started");
    }

}
