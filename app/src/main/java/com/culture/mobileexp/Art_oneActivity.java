package com.culture.mobileexp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Art_oneActivity extends AppCompatActivity {
    Button btnPrev, btnNext, otherArt,home, address1;
    ImageButton img2,img3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art_one);

        final ViewFlipper vFlipper;

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        otherArt = (Button) findViewById(R.id.otherArt);
        home = (Button) findViewById(R.id.home);
        address1 = (Button) findViewById(R.id.address1);

        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });

        otherArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent other = new Intent(getApplicationContext(),
                        Select_artActivity.class);
                startActivity(other);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(main);
            }
        });
        address1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri1 = Uri.parse("https://goo.gl/maps/UFSo76gDbGUamrVi9");
                Intent address1 = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(address1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder( Art_oneActivity.this);
                dlg.setTitle("그림에 숨겨진 내용");
                dlg.setMessage("어렸을 때부터 그림을 그린 그가 8살 무렵 \n첫 작품으로 인정받은 작품이다.\n" +
                        "보통 8살 때 그림 그리라고 하면 부모님을 가장 많이 그린다고 하는데 " +
                        "8살 무하는 십자가에 못 박힌 예수를 그렸다.");
                dlg.setIcon(R.drawable.iconqa);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_oneActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder( Art_oneActivity.this);
                dlg.setTitle("그림에 숨겨진 내용");
                dlg.setMessage("그때 당시 기존의 포스터는 세로 1m 길이였는데\n" +
                        "무하는 1m씩 두 번 인쇄하여 붙여 총 세로 2m 길이의 이 포스터를 완성하였다.\n" +
                        "사라 매니저는 포스터를 보자마자 무하를 질타했지만 빈손으로 갈 수는 없어 \n" +
                        "하는 수 없이 포스터를 사라에게 가져갔는데 \n" +
                        "사라는 이 포스터를 보자마자 “내가 지금까지 본 포스터 중에 제일 예뻐”라고 했다고 한다.\n" +
                        "그 후 무하는 이 그림으로 파리의 전설이 되었다.\n");
                dlg.setIcon(R.drawable.iconqa);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_oneActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });
    }
}
