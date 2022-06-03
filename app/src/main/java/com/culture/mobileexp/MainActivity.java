package com.culture.mobileexp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton maingallery_btn,mainbooking_btn,mainreview_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maingallery_btn=findViewById(R.id.maingallery_btn);
        mainreview_btn=findViewById(R.id.mainreview_btn);
        mainbooking_btn=findViewById(R.id.mainbooking_btn);

        maingallery_btn.setOnClickListener(new View.OnClickListener() {
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
        mainreview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(getApplicationContext(),
                        Write_reviewActivity.class);
                startActivity(start);
            }
        });
    }
}