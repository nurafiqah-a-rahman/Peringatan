package com.example.acer.peringatan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationReceiver1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = new TextView(this);
        tv1.setText("Selamat Berbuka :)");

        setContentView(tv1);
    }
}