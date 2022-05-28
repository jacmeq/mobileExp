package com.culture.mobileexp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Select_artActivity extends AppCompatActivity{
    ImageButton select_btn1,select_btn2,play;

    MediaPlayer mPlayer;
    boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_art);
        select_btn1 = findViewById(R.id.select_btn1);
        select_btn2 = findViewById(R.id.select_btn2);
        play = findViewById(R.id.play);

        mPlayer = MediaPlayer.create(this, R.raw.song);
        mPlayer.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(start) {
                    mPlayer.pause(); //음악일시정지
                    start = false;
                } else {
                    mPlayer.start();
                    start = true;
                }
            }
        });

        select_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent art = new Intent(getApplicationContext(),
                        Art_oneActivity.class);
                startActivity(art);
            }
        });
        select_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent art2 = new Intent(getApplicationContext(),
                        Art_twoActivity.class);
                startActivity(art2);
            }
        });
    }
}
