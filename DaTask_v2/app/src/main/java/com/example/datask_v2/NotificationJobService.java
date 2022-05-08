package com.example.datask_v2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Random;

public class NotificationJobService extends JobService {

    private final int MAX = 100;
    private final int MIN = 0;
    private int i = 1;
    NotificationManager mNotifyManager;
    private boolean mIsCounterOn;
    private int mNumber;

    // Notification channel ID.
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";


    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {

        // Define notification manager object.
        mNotifyManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Job Service notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifications from Job Service");

            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.i("NotificationJobService","onStartJob");
        // Create the notification channel.
        createNotificationChannel();

        // Set up the notification content intent to launch the app when
        // clicked.
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (this, 0, new Intent(this, MainActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Daily Reminder")
                .setContentText("Don't forget to check on your on going task!")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_task_foreground)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(0, builder.build());
        return false;
    }

    private void doBackgroundWork(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i > 0){
                    mNumber++;
                    Log.i("NotificationJobService","Thread id: "+Thread.currentThread().getId()+", Number: "+ mNumber);
                }
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("NotificationJobService","onStopJob");
        return false;
    }

    private void startCounter(){
        while (mIsCounterOn){
            try{
                Thread.sleep(1000);
                if(mIsCounterOn){
                    while(i > 0){
                        mNumber++;
                        Log.i("NotificationJobService","Thread id: "+Thread.currentThread().getId()+", Number: "+ mNumber);
                    }
                }
            }catch (InterruptedException e){
                Log.i("NotificationJobService","Thread Interrupted");
            }
        }
    }
}
