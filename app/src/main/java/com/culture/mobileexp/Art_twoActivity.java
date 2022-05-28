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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Art_twoActivity extends AppCompatActivity {
    Button btnPrev, btnNext, otherArt,home, address1;
    ImageButton img2,img3,img4,img5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art_two);

        final ViewFlipper vFlipper;

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        otherArt = (Button) findViewById(R.id.otherArt);
        home = (Button) findViewById(R.id.home);
        address1 = (Button) findViewById(R.id.address1);

        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);

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
                Uri uri1 = Uri.parse("https://goo.gl/maps/uZhNDWHiCAjAmXdJA");
                Intent address1 = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(address1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg2 = new AlertDialog.Builder( Art_twoActivity.this);
                dlg2.setTitle("그림에 숨겨진 내용");
                dlg2.setMessage("이 작품은 15살의 터너가 그린 <대주교 궁전의 전경>입니다. \n" +
                        "15살이 그림이라고 믿기 어려울 정도로 섬세하고 세세한 묘사가 돋보입니다.\n");
                dlg2.setIcon(R.drawable.iconqa);
                dlg2.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_twoActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg2.show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg3 = new AlertDialog.Builder( Art_twoActivity.this);
                dlg3.setTitle("그림에 숨겨진 내용");
                dlg3.setMessage("이 작품은 ‘바다의 어부들’이란 작품으로 터너가 아카데미에 들어가 전시한 첫 작품이에요. \n" +
                        "달빛이 바다를 잔잔하게 비추고 출렁이는 바다의 물결이 아주 인상적이죠. \n" +
                        "잘 짜여진 완벽한 구도의 그림처럼 보이기도 하죠?\n");
                dlg3.setIcon(R.drawable.iconqa);
                dlg3.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_twoActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg3.show();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg4 = new AlertDialog.Builder( Art_twoActivity.this);
                dlg4.setTitle("그림에 숨겨진 내용");
                dlg4.setMessage("터너는 주변의 만류에도 불구하고, 기존의 화법을 모두 버린 채 새로운 방법을 찾아 연구합니다. \n" +
                        "그리고 발표한 것이 이 작품 ‘눈보라’ 이라는 작품입니다.\n" +
                        "터너는 이 작품을 그리기 위해서 배의 돛대에 몸을 묶고 거친 파도를 직접 두 눈에 담았다고 합니다.\n" +
                        "이후의 풍경화들은 대부분 이런 식으로 나타나게 되는 걸 볼 수 있습니다.\n");
                dlg4.setIcon(R.drawable.iconqa);
                dlg4.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_twoActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg4.show();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder( Art_twoActivity.this);
                dlg.setTitle("그림에 숨겨진 내용");
                dlg.setMessage("그가 이후에 그린 여러 풍경화들은 대부분 이런 식으로 나타나게 됩니다. \n" +
                        "이 그림들을 본 사람들은 터너를 비난했어요. \n" +
                        "비누 거품과 회반죽 같다며 손가락질했습니다.\n");
                dlg.setIcon(R.drawable.iconqa);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText( Art_twoActivity.this,
                                        "다시 관람을 즐기세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });

    }
}
