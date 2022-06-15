package com.culture.mobileexp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class BookingActivity extends AppCompatActivity {

    public static Context Context; //예약확인 정보 불러오기
    RadioButton radio_Turner,radio_Mucha;
    Button btn_pm12, btn_pm2, btn_pm4, btn_End, btn_up, btn_down;
    CalendarView calView;
    TextView tvTime, tvYear, tvMonth, tvDay, people_counter, tvselectE;
    int selectYear, selectMonth, selectDay;
    private int count = 0;

    private static final String TAG = "Main_Activity";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);

        mAuth = FirebaseAuth.getInstance();
        Context = this;

        radio_Mucha = findViewById(R.id.radio_Mucha);
        radio_Turner = findViewById(R.id.radio_Turner);
        tvselectE = findViewById(R.id.tvselectE);

        btn_pm12 = findViewById(R.id.btn_pm12);
        btn_pm2 = findViewById(R.id.btn_pm2);
        btn_pm4 = findViewById(R.id.btn_pm4);
        btn_End = findViewById(R.id.btn_End);

        calView = findViewById(R.id.calView);
        tvTime = findViewById(R.id.tvTime);

        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);

        people_counter = findViewById(R.id.people_counter);
        people_counter.setText(count + "");
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        calView.setVisibility(View.VISIBLE);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnAdd : " + v.getClass().getName());
                count++;
                people_counter.setText(count + "");
            }
        }); //인원수 1씩 증가

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count--;
                    people_counter.setText(count + "");
                }
            }
        }); //인원수 1씩 감소

        btn_pm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("오후 12시");
            }
        }); //12시 예약
        btn_pm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("오후 2시");
            }
        }); //2시 예약
        btn_pm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("오후 4시");
            }
        }); //4시 예약

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1 + 1;
                selectDay = i2;
            }
        }); //날짜예약

        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                if(radio_Mucha.isChecked()){
                    tvselectE.setText("알폰스 무하展");
                } else if(radio_Turner.isChecked()){
                    tvselectE.setText("윌리엄 터너展");
                }

                Intent intent = new Intent(BookingActivity.this, Booking_checkActivity.class);
                startActivity(intent);
            }
        }); //예약확인창 이동


    }
}