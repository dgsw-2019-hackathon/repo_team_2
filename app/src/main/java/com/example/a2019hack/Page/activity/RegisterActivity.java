package com.example.a2019hack.Page.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2019hack.R;

public class RegisterActivity extends AppCompatActivity {

    String id, pw, pwCheck, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText userId = (EditText) findViewById(R.id.userId);
        EditText userPass = (EditText) findViewById(R.id.userPassword);
        EditText userPassCheck = (EditText) findViewById(R.id.userPasswordCheck);
        EditText userEmail = (EditText) findViewById(R.id.userEmail);
        Button confirm = (Button) findViewById(R.id.confirmRegister);

        id = userId.getText().toString();
        pw = userPass.getText().toString();
        pwCheck = userPassCheck.getText().toString();
        email = userEmail.getText().toString();

        confirm.setOnClickListener(I -> {
            if (id.equals("") || pw.equals("") || pwCheck.equals("") || email.equals("")) {
                Toast.makeText(getApplicationContext(), "빈칸이 존재합니다. 빈칸을 채워주세요.", Toast.LENGTH_LONG).show();
            } else if (pw != pwCheck) {
                Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
            }
            if (id.equals("ys0216")) {
                Toast.makeText(getApplicationContext(), "이미 등록된 아이디 입니다.", Toast.LENGTH_LONG).show();
            }
            //if(id != "ys0216" && pw.equals("1234"))

        });

    }

}
