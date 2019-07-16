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

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2019hack.Page.fragment.ChildListviewActivity;
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

    String [] item = new String[19];
    String name, call, sex, place, age; // 저장한 데이터들
    Boolean sexToggle = false; // true = man, false = woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        final Spinner ageSpinner = findViewById(R.id.ageSpinner);
        ImageView image = findViewById(R.id.add_child_image);
        Button manBtn = findViewById(R.id.manButton);
        Button womanBtn = findViewById(R.id.womanButton);
        Button confirm = findViewById(R.id.confirmAdd);
        EditText childName = findViewById(R.id.add_child_nameText);
        EditText callNumber = findViewById(R.id.parentPhoneNumber);
        EditText missingPlace = findViewById(R.id.missingLocation);

        String setAge = " 세";

        // 나이 콤보박스 및 선택 시 이벤트
        for(int i=0;i<item.length;i++) {

            item[i] = Integer.toString(i);

            setAge = item[i] + setAge;
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
        if(sexToggle) {

            manBtn.setEnabled(true);
            womanBtn.setEnabled(false);
        }
        else {

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

            tedPermission();
        });

        confirm.setOnClickListener(I -> {

            name = childName.getText().toString();
            call = callNumber.getText().toString();
            place = missingPlace.getText().toString();

            if(name.equals("") || call.equals("") || ageSpinner.getSelectedItem().equals("")) {

                Toast.makeText(getApplicationContext(), "필수 입력란을 채워주세요.", Toast.LENGTH_LONG).show();
            }
            else { // 값이 다 채워졌으면

                Toast.makeText(getApplicationContext(), "모든 항목이 입력되었습니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AddChildActivity.this, ChildListviewActivity.class);

                // TODO
            }
        });
    }

    private void tedPermission() {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    // 이미지 Uri 가져오기
    private String getImageUri(Uri contentUri) {

        String result;
        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null);

        if(cursor == null){

            result = contentUri.getPath();
        }
        else {

            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }

        return result;
    }
}
