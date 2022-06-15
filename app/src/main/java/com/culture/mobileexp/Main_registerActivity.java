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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main_registerActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; //firebase연동
    private DatabaseReference mDatabaseReference;//서버에 연결시킬 수 있는 실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;
    private Button mBtnRegister, btn_re_login,btn_delete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("mobileExp");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pw);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 처리

                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();

                //firebase auth진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Main_registerActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//회원가입 성공 시
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            //setValue : database INSERT
                            mDatabaseReference.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            Toast.makeText(Main_registerActivity.this, "회원가입완료",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Main_registerActivity.this,"회원가입실패",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        btn_re_login = findViewById(R.id.btn_re_login);
        btn_re_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //로그인 창 이동
                Intent intent = new Intent(Main_registerActivity.this, Main_loginActivity.class);
                startActivity(intent);
            }
        });
    }
}
