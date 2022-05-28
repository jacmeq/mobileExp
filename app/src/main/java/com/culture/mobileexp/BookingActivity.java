package com.culture.mobileexp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BookingActivity extends AppCompatActivity {

    Button btn_pm12, btn_pm2, btn_pm4, btn_End, btn_up, btn_down, btn_logout;
    CalendarView calView;
    TextView textView, tvYear, tvMon, tvDay, counter;
    int selectYear, selectMonth, selectDay;
    private int count = 0;
    private static final String TAG = "Main_Activity";

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);

        mAuth = FirebaseAuth.getInstance();

        btn_pm12 = findViewById(R.id.btn_pm12);
        btn_pm2 = findViewById(R.id.btn_pm2);
        btn_pm4 = findViewById(R.id.btn_pm4);
        btn_End = findViewById(R.id.btn_End);

        calView = findViewById(R.id.calView);
        textView = findViewById(R.id.textview);

        tvYear = findViewById(R.id.tvYear);
        tvMon = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);

        counter = findViewById(R.id.counter);
        counter.setText(count + "");
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        calView.setVisibility(View.VISIBLE);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnAdd : " + v.getClass().getName());
                count++;
                counter.setText(count + "");
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count--;
                    counter.setText(count + "");
                }
            }
        });

        btn_pm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("오후 12시");
            }
        }); //12시 예약
        btn_pm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("오후 2시");
            }
        }); //2시 예약
        btn_pm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("오후 4시");
            }
        }); //4시 예약


        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvYear.setText(Integer.toString(selectYear));
                tvMon.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1 + 1;
                selectDay = i2;
            }
        });


    }
}