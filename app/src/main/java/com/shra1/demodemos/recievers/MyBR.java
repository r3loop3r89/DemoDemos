package com.shra1.demodemos.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.shra1.demodemos.App;
import com.shra1.demodemos.fragments.AlarmManagerDemoFragment;

import org.joda.time.DateTime;

import static com.shra1.demodemos.App.db;

public class MyBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(1000);

        

        DateTime dateTime = new DateTime(intent.getLongExtra("THELONG", 0));
        dateTime = dateTime.plusMinutes(1);
        AlarmManagerDemoFragment.setAlarm(context, dateTime);
    }
}
