package com.shra1.demodemos.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.shra1.demodemos.R;

import org.joda.time.DateTime;

public class DataListFragment extends Fragment {

    private static DataListFragment INSTANCE = null;

    public static DataListFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataListFragment();
        }
        return INSTANCE;
    }
    private Button bPrev;
    private TextView tvDate;
    private Button bNext;
    private ListView lvList;
    DateTime dateTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.datalist_fragment, container, false);

        initViews(v);

        dateTime = new DateTime();

        setDateToTV(dateTime);

        tvDate.setOnClickListener(tv->{
            dateTime=new DateTime();
            setDateToTV(dateTime);
        });
        bPrev.setOnClickListener(b->{
            dateTime = dateTime.minusDays(1);
            setDateToTV(dateTime);
        });
        bNext.setOnClickListener(b->{
            dateTime = dateTime.plusDays(1);
            setDateToTV(dateTime);
        });

        return v;
    }

    private void setDateToTV(DateTime dateTime) {
        tvDate.setText(dateTime.toString("dd-MMM-yyyy"));
    }

    private void initViews(View v) {
        bPrev = (Button) v.findViewById(R.id.bPrev);
        tvDate = (TextView) v.findViewById(R.id.tvDate);
        bNext = (Button) v.findViewById(R.id.bNext);
        lvList = (ListView) v.findViewById(R.id.lvList);
    }

}
