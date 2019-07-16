package com.example.a2019hack.Page.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2019hack.R;


public class RegisterActivity extends AppCompatActivity {

    String id, pw, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText userId = findViewById(R.id.userId);
        EditText userPass = findViewById(R.id.userPassword);
        EditText userEmail = findViewById(R.id.userEmail);
        Button confirm = findViewById(R.id.confirmRegister);

        id = userId.getText().toString();
        pw = userPass.getText().toString();
        email = userEmail.getText().toString();

        confirm.setOnClickListener(I -> {

            if (id.equals("") || pw.equals("") || email.equals("")) {

                Toast.makeText(getApplicationContext(), "빈칸이 존재합니다. 빈칸을 채워주세요.", Toast.LENGTH_LONG).show();
            }
            if (id.equals("ys0216")) {

                Toast.makeText(getApplicationContext(), "이미 등록된 아이디 입니다.", Toast.LENGTH_LONG).show();
            }

            //if(id != "ys0216" && pw.equals("1234"))
        });
    }
}
