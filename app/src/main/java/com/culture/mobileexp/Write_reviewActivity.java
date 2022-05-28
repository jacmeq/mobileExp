package com.culture.mobileexp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Write_reviewActivity extends AppCompatActivity {
    DataBase myDB;
    EditText editW,editR;
    Button btnInsert,btnReview;
    TextView text;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_review);

        btnInsert = findViewById(R.id.btnInsert);
        btnReview = findViewById(R.id.btnReview);
        editW = findViewById(R.id.editW);
        text = findViewById(R.id.text);
        editR = findViewById(R.id.editR);

        myDB = new DataBase(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myDB.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO reviewTBL VALUES ( '"
                        + editW.getText().toString() + "');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력 완료되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }

        });
        btnReview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sqlDB = myDB.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM reviewTBL;", null);

                String strTexts = "--------- 후기입니다 --------" + "\r\n";

                while (cursor.moveToNext()) {
                    strTexts += cursor.getString(0) + "\r\n";
                }

                editR.setText(strTexts);

                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class DataBase extends SQLiteOpenHelper {
        public DataBase(Context context) {
            super(context, "reviewDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLite) {
            sqLite.execSQL("CREATE TABLE  reviewTBL ( text CHAR(1000) );");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}

