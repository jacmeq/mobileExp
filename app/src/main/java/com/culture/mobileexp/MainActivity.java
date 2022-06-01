package com.culture.mobileexp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton mainbtn1,mainbtn2;
    Button mainbooking_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainbtn1=findViewById(R.id.mainbtn1);
        mainbtn2=findViewById(R.id.mainbtn2);
        mainbooking_btn=findViewById(R.id.mainbooking_btn);

        mainbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(getApplicationContext(),
                        Select_artActivity.class);
                startActivity(start);
            }
        });
        mainbooking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(getApplicationContext(),
                        Main_loginActivity.class);
                startActivity(start);
            }
        });
        mainbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(getApplicationContext(),
                        Write_reviewActivity.class);
                startActivity(start);
            }
        });
    }
}