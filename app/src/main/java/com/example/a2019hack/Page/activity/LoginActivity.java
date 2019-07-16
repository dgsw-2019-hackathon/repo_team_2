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
    String registerId, registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText idText = (EditText) findViewById(R.id.loginIdText); // ID입력창
        EditText passwordText = (EditText) findViewById(R.id.loginPasswordText); //PW입력창
        Button loginBtn = (Button) findViewById(R.id.buttonLogin); // 로그인 버튼
        TextView registerText = (TextView) findViewById(R.id.loginGetRegister); // 회원가입 텍스트박스
        CheckBox keepLoginBox = (CheckBox) findViewById(R.id.keepLoginCheckBox); // 로그인유지 체크박스

        loginId = idText.getText().toString();
        loginPassword = passwordText.getText().toString();

        //로그인 버튼 클릭리스너
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //registerId =
                //registerPassword =

                if (loginId.equals(registerId) && loginPassword.equals(registerPassword)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), "로그인하였습니다.", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        //회원가입 텍스트 클릭 리스너
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
