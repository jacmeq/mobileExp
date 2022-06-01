package com.culture.mobileexp;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Booking_checkActivity extends AppCompatActivity {
    TextView tvYear2, tvMonth2, tvDay2; //BookingActivity 날짜 예약 정보 가져오는 변수
    TextView tvTime2,people_counter2;//BookingActivity 회차, 인원수 예약 정보 가져오는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_check);
        setTitle("전시회 예약 확인");

        tvYear2 = (TextView) findViewById(R.id.tvYear2);
        tvMonth2 = (TextView) findViewById(R.id.tvMonth2);
        tvDay2 = (TextView) findViewById(R.id.tvDay2);

        tvYear2.setText(((BookingActivity)BookingActivity.Context).tvYear.getText());
        tvMonth2.setText(((BookingActivity)BookingActivity.Context).tvMonth.getText());
        tvDay2.setText(((BookingActivity)BookingActivity.Context).tvDay.getText());
        //BookingActivity 날짜 예약 정보 context로 가져와서 보여주기

        tvTime2 = (TextView)findViewById(R.id.Seat2);
        people_counter2 = (TextView)findViewById(R.id.people_counter2);

        tvTime2.setText(((BookingActivity)BookingActivity.Context).tvTime.getText());
        people_counter2.setText(((BookingActivity)BookingActivity.Context).people_counter.getText());
        //BookingActivity 회차,인원수 예약 정보 context로 가져와서 보여주기

    }
}
