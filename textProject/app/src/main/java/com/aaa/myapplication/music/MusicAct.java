package com.aaa.myapplication.music;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aaa.myapplication.R;
import com.aaa.myapplication.cander.calendarview.Calendar;
import com.aaa.myapplication.cander.calendarview.CalendarView;

public class MusicAct extends AppCompatActivity implements CalendarView.OnMonthChangeListener, CalendarView.OnYearChangeListener, CalendarView.OnCalendarRangeSelectListener {
    private TextView textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        textv = (TextView) findViewById(R.id.textv);
        textv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onYearChange(int year) {

    }

    @Override
    public void onMonthChange(int year, int month) {

    }

    @Override
    public void onCalendarSelectOutOfRange(Calendar calendar) {

    }

    @Override
    public void onSelectOutOfRange(Calendar calendar, boolean isOutOfMinRange) {

    }

    @Override
    public void onCalendarRangeSelect(Calendar calendar, boolean isEnd) {

    }
}
