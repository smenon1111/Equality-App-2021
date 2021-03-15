package com.example.informationapp2021;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.view.View;
import androidx.fragment.app.Fragment;

public class Calendar extends Fragment {


    private  static final String TAG = "CalendarActivity";



    private CalendarView mCalendarView;
    private TextView thedate;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View calendarView = inflater.inflate(R.layout.calendar, container, false);
        thedate = (TextView) calendarView.findViewById(R.id.date1);
        mTextView = (TextView) calendarView.findViewById(R.id.textView2);
        mCalendarView = (CalendarView) calendarView.findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {

                String date = (month +1)  + "/" + dayOfMonth + "/" +  year  ;
                String day = "" + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: dd/mm/yyyy:" + date);

                Intent text = (getActivity()).getIntent();
                text.putExtra("date",date);
                text.putExtra("dayOfMonth",day);
                startActivity(text);

                Intent calendarView = (getActivity()).getIntent();
                String date1 = calendarView.getStringExtra("date");
                String dayOfMonth1 = calendarView.getStringExtra("dayOfMonth");
                if (date1 !=null) {
                    thedate.setText(date1);
                }

                if (dayOfMonth1 !=null && dayOfMonth1.equals("9")) {
                    mTextView.setText(getString(R.string.Month_9_2021));
                }

                else if (dayOfMonth1 !=null && dayOfMonth1.equals("8")) {
                    mTextView.setText(getString(R.string.Month_8_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("1")) {
                    mTextView.setText(getString(R.string.Month_1_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("2")) {
                    mTextView.setText(getString(R.string.Month_2_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("3")) {
                    mTextView.setText(getString(R.string.Month_3_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("4")) {
                    mTextView.setText(getString(R.string.Month_4_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("5")) {
                    mTextView.setText(getString(R.string.Month_5_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("6")) {
                    mTextView.setText(getString(R.string.Month_6_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("7")) {
                    mTextView.setText(getString(R.string.Month_7_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("10")) {
                    mTextView.setText(getString(R.string.Month_10_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("11")) {
                    mTextView.setText(getString(R.string.Month_11_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("12")) {
                    mTextView.setText(getString(R.string.Month_12_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("13")) {
                    mTextView.setText(getString(R.string.Month_13_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("14")) {
                    mTextView.setText(getString(R.string.Month_14_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("15")) {
                    mTextView.setText(getString(R.string.Month_15_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("16")) {
                    mTextView.setText(getString(R.string.Month_16_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("17")) {
                    mTextView.setText(getString(R.string.Month_17_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("18")) {
                    mTextView.setText(getString(R.string.Month_18_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("19")) {
                    mTextView.setText(getString(R.string.Month_19_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("20")) {
                    mTextView.setText(getString(R.string.Month_20_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("21")) {
                    mTextView.setText(getString(R.string.Month_21_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("22")) {
                    mTextView.setText(getString(R.string.Month_22_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("23")) {
                    mTextView.setText(getString(R.string.Month_23_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("24")) {
                    mTextView.setText(getString(R.string.Month_24_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("25")) {
                    mTextView.setText(getString(R.string.Month_25_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("26")) {
                    mTextView.setText(getString(R.string.Month_26_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("27")) {
                    mTextView.setText(getString(R.string.Month_27_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("28")) {
                    mTextView.setText(getString(R.string.Month_28_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("29")) {
                    mTextView.setText(getString(R.string.Month_29_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("30")) {
                    mTextView.setText(getString(R.string.Month_30_2021));
                }
                else if (dayOfMonth1 !=null && dayOfMonth1.equals("31")) {
                    mTextView.setText(getString(R.string.Month_31_2021));
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
    return calendarView;
    }}
