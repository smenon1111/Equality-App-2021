package com.example.informationapp2021;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.view.View;

public class Calendar extends AppCompatActivity {


    private  static final String TAG = "CalendarActivity";



    private CalendarView mCalendarView;
    private TextView thedate;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        thedate = (TextView) findViewById(R.id.date1);
        mTextView = (TextView) findViewById(R.id.textView2);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {

                String date = (month +1)  + "/" + dayOfMonth + "/" +  year  ;
                String day = "" + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: dd/mm/yyyy:" + date);

                Intent text = getIntent();
                text.putExtra("date",date);
                text.putExtra("dayOfMonth",day);
                startActivity(text);

                Intent calendarView = getIntent();
                String date1 = calendarView.getStringExtra("date");
                String dayOfMonth1 = calendarView.getStringExtra("dayOfMonth");
                if (date1 !=null) {
                    thedate.setText(date1);
                }

                if (dayOfMonth1 !=null && dayOfMonth1.equals("9")) {
                    mTextView.setText(getString(R.string.February_9_2021));
                }

                else if (dayOfMonth1 !=null && dayOfMonth1.equals("8")) {
                    mTextView.setText(getString(R.string.February_8_2021));
                }
                else mTextView.setText(dayOfMonth1);
                startActivity(calendarView);


            /* Intent intent = new Intent(CalendarActivity.this,MainActivity.class);

                intent.putExtra("date",date);
                intent.putExtra("dayOfMonth",day);
                startActivity(intent);


             /*   calendarView.putExtra("date",date);
                calendarView.putExtra("dayOfMonth",day);
                startActivity(calendarView);

              */

            }
        });
    }}
