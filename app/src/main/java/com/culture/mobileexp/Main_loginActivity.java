package com.culture.mobileexp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main_loginActivity extends AppCompatActivity {

    Button btn_login,btn_register;
    private FirebaseAuth mFirebaseAuth; //firebase연동
    private DatabaseReference mDatabaseReference;//서버에 연결시킬 수 있는 실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("mobileExp");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인 요청
                String strEmail = mEtEmail.getText().toString();
                String strpwd = mEtPwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strpwd).addOnCompleteListener(Main_loginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent intent = new Intent(Main_loginActivity.this,BookingActivity.class);
                            startActivity(intent);
                            finish(); //현재 액티비티 파괴
                        }
                        else{
                            Toast.makeText(Main_loginActivity.this,"로그인실패",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 화면으로 이동
                Intent intent = new Intent(Main_loginActivity.this, Main_registerActivity.class);
                startActivity(intent);
            }
        });
    }

}
