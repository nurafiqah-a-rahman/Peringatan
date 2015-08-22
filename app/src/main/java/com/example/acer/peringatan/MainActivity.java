package com.example.acer.peringatan;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;


public class MainActivity extends Activity {
    private CheckBox Imsak, Maghrib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Imsak = (CheckBox) findViewById(R.id.Imsak);
        Maghrib = (CheckBox) findViewById(R.id.Maghrib);

        Imsak.setChecked(true);


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();

                if (checked) {

                    switch (view.getId()) {

                        case R.id.Imsak:
                            showNotification();
                            break;

                        case R.id.Maghrib:
                            showNotification1();
                            break;
                    }

                }

                else cancelNotification(0);
            }
        };

        findViewById(R.id.Imsak).setOnClickListener(onClickListener);
        findViewById(R.id.Maghrib).setOnClickListener(onClickListener);

    }

    public void showNotification1()
    {
        Intent intent = new Intent(MainActivity.this,NotificationReceiver1.class);
        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

        Notification mNotification = new Notification.Builder(this)
                .setContentTitle("Maghrib")
                .setContentText("Telah masuk waktu maghrib")
                .setSmallIcon(R.drawable.ikaaaaaa2)
                .setContentIntent(pIntent)

                .addAction(R.drawable.ikaaaaaa2,"View",pIntent)
                .addAction(0,"Remind", pIntent)

                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //hide
        notificationManager.notify(0, mNotification);
    }

    public void showNotification()
    {
        Intent intent = new Intent(MainActivity.this,NotificationReceiver.class);
        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

        Notification mNotification = new Notification.Builder(this)
                .setContentTitle("Imsak")
                .setContentText("Telah masuk waktu imsak")
                .setSmallIcon(R.drawable.ikaaaaaa2)
                .setContentIntent(pIntent)

                .addAction(R.drawable.ikaaaaaa2, "View", pIntent)
                .addAction(0,"Remind", pIntent)

                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //hide
        notificationManager.notify(0, mNotification);
    }

    public void cancelNotification(int notificationId)
    {

        if(Context.NOTIFICATION_SERVICE!=null){
            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager nMgr =(NotificationManager)getApplicationContext().getSystemService(ns);
            nMgr.cancel(notificationId);
        }
    }

}




