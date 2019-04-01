package com.example.rasel.androidnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "my_notification";
    public static int NOTIFICATION_ID = 033;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(View view) {

        createNotificationChannel();

        RemoteViews normal_layout = new RemoteViews(getPackageName(),R.layout.custom_normal_layout);
        RemoteViews extended_layout = new RemoteViews(getPackageName(),R.layout.custom_extended_layout);

//        Intent landingIntent = new Intent(this,LandingActivity.class);
//
//        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//        PendingIntent landingPendingIntent =PendingIntent.getActivity(this,0,landingIntent,PendingIntent.FLAG_ONE_SHOT);
//
//
//        Intent YesIntent = new Intent(this,YesActivity.class);
//        YesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent YesPendingIntent =PendingIntent.getActivity(this,0,YesIntent,PendingIntent.FLAG_ONE_SHOT);
//
//        Intent NoIntent = new Intent(this,YesActivity.class);
//        NoIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent NoPendingIntent =PendingIntent.getActivity(this,0,NoIntent,PendingIntent.FLAG_ONE_SHOT);



        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_sms_notification_icon);
//        builder.setContentTitle("Demo Notification");
//        builder.setContentText("This is Demo Notification");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        builder.setCustomContentView(normal_layout);
        builder.setCustomBigContentView(extended_layout);


//        builder.setAutoCancel(true);
//        builder.setContentIntent(landingPendingIntent);

//        builder.addAction(R.drawable.ic_sms_notification_icon,"Yes",YesPendingIntent);
//        builder.addAction(R.drawable.ic_sms_notification_icon,"No",NoPendingIntent);


//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.company_logo);
//        builder.setLargeIcon(bitmap);
//        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));

//        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.notification_text)));


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

//        final int max_progress = 100;
//        int current_progress = 0;
//
//        builder.setProgress(0,0,true);

        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                int count = 0;
//                try{
//                    while (count<=100){
//                        count = count+10;
//                        sleep(1000);
//                    }
//                    builder.setContentText("Download Complete");
//                    builder.setProgress(0,0,false);
//                    notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
//
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();

    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Personal Notification";
            String description = "There will be include all the personal Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


}
