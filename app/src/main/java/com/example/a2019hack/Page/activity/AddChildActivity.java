package com.example.a2019hack.Page.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2019hack.R;
import com.example.a2019hack.data.Child;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddChildActivity extends AppCompatActivity {

    String [] item = new String[100];
    String name, call, sex, place, age; // 저장한 데이터들
    Boolean sexToggle = false; // true = man, false = woman;
    private final int GET_GALLERY_IMAGE = 200;

    ImageView image;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selecUri = data.getData();// image Uri
            image.setImageURI(selecUri);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        final Spinner ageSpinner = findViewById(R.id.ageSpinner);
        image = findViewById(R.id.add_child_image);
        Button manBtn = findViewById(R.id.manButton);
        Button womanBtn = findViewById(R.id.womanButton);
        Button confirm = findViewById(R.id.confirmAdd);
        EditText childName = findViewById(R.id.add_child_nameText);
        EditText callNumber = findViewById(R.id.parentPhoneNumber);
        EditText missingPlace = findViewById(R.id.missingLocation);

        name = childName.getText().toString();
        call = callNumber.getText().toString();
        place = missingPlace.getText().toString();

        // 나이 콤보박스 및 선택 시 이벤트
        for(int i = 0; i < item.length; i++){
            item[i] = Integer.toString(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age = ageSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // sexToggle is true then man, false then woman
        if(sexToggle){
            manBtn.setEnabled(true);
            womanBtn.setEnabled(false);
        } else {
            womanBtn.setEnabled(true);
            manBtn.setEnabled(false);
        }
        manBtn.setOnClickListener(I -> {
            sexToggle = true;
            sex = "boy";
        });

        womanBtn.setOnClickListener(I -> {
            sexToggle = false;
            sex = "girl";
        });

        image.setOnClickListener(I -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            startActivityForResult(intent, GET_GALLERY_IMAGE);
        });

        confirm.setOnClickListener(I -> {
            if(name.equals("") || call.equals("") || ageSpinner.getSelectedItem().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "필수 입력란을 채워주세요.", Toast.LENGTH_LONG);
                toast.show();
            } else { // 값이 다 채워졌으면

            }
        });
    }


}
