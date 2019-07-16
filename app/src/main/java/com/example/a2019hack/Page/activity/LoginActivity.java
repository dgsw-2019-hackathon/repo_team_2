package com.example.a2019hack.Page.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2019hack.R;
import com.example.a2019hack.data.Child;

public class LoginActivity extends AppCompatActivity {

    String loginId, loginPassword;

    final String userId = "user1234";
    final String userPw = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText idText = (EditText) findViewById(R.id.loginIdText); // ID입력창
        EditText passwordText = (EditText) findViewById(R.id.loginPasswordText); //PW입력창
        Button loginBtn = (Button) findViewById(R.id.buttonLogin); // 로그인 버튼
        TextView registerText = (TextView) findViewById(R.id.loginGetRegister); // 회원가입 텍스트박스

        //로그인 버튼 클릭리스너
        loginBtn.setOnClickListener(v -> {

            loginId = idText.getText().toString();
            loginPassword = passwordText.getText().toString();

            if (loginId.equals(userId) && loginPassword.equals(userPw)){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "로그인하였습니다.", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        //회원가입 텍스트 클릭 리스너
        registerText.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });

    }
}
