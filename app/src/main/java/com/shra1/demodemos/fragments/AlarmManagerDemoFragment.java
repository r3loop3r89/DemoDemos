package com.shra1.demodemos.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shra1.demodemos.MainActivity;
import com.shra1.demodemos.R;
import com.shra1.demodemos.recievers.MyBR;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmManagerDemoFragment extends Fragment {


    private static AlarmManagerDemoFragment INSTANCE = null;
    DateTime dateTime;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private TextView tvTiming;
    private EditText etHour;
    private EditText etMinute;
    private EditText etSeconds;
    private Button bSetAlarm;
    private Button bRefresh;
    private Context mCtx;

    public static Fragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AlarmManagerDemoFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.alarm_manager_demo_fragment, container, false);

        initViews(v);

        refresh();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (MainActivity.getInstance() != null) {
                    MainActivity.getInstance().runOnUiThread(() -> tvTiming.setText(sdf.format(new Date())));
                }else{
                    Log.d("ShraX", "Running in background");
                }
            }
        }, 0, 1000);

        bRefresh.setOnClickListener(b -> {
            refresh();
        });

        bSetAlarm.setOnClickListener(b -> {
            dateTime = dateTime.withHourOfDay(Integer.parseInt(etHour.getText().toString().trim()));
            dateTime = dateTime.withMinuteOfHour(Integer.parseInt(etMinute.getText().toString().trim()));
            dateTime = dateTime.withSecondOfMinute(Integer.parseInt(etSeconds.getText().toString().trim()));
            dateTime = dateTime.withMillisOfSecond(0);

            setAlarm(mCtx, dateTime);
        });

        return v;
    }

    public static void setAlarm(Context mCtx, DateTime dateTime) {

        Intent intent = new Intent(mCtx, MyBR.class);
        intent.putExtra("THELONG", dateTime.getMillis());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(mCtx, 210, intent, 0);

        AlarmManager alarmManager = (AlarmManager) mCtx.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime.getMillis(), pendingIntent);
    }

    private void refresh() {
        dateTime = new DateTime();

        etHour.setText("" + dateTime.getHourOfDay());
        etMinute.setText("" + dateTime.getMinuteOfHour());
        etSeconds.setText("" + dateTime.getSecondOfMinute());

    }

    private void initViews(View v) {
        tvTiming = v.findViewById(R.id.tvTiming);
        etHour = v.findViewById(R.id.etHour);
        etMinute = v.findViewById(R.id.etMinute);
        etSeconds = v.findViewById(R.id.etSeconds);
        bSetAlarm = v.findViewById(R.id.bSetAlarm);
        bRefresh = v.findViewById(R.id.bRefresh);
    }
}
