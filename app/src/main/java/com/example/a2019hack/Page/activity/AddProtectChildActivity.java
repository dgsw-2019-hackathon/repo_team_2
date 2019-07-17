package com.example.a2019hack.Page.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a2019hack.Page.fragment.ChildListviewActivity;
import com.example.a2019hack.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class AddProtectChildActivity extends AppCompatActivity {

    String [] item = new String[19];
    String name, call, place, age; // 저장한 데이터들
    String sex = "남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_protect_child);

        final Spinner ageSpinner = findViewById(R.id.ageSpinner);

        ImageView image = findViewById(R.id.add_child_image);

        Button findChangeButton = findViewById(R.id.changeFindButton3);
        Button protectChangeButton = findViewById(R.id.changeProtectButton3);

        Button manBtn = findViewById(R.id.manButton);
        Button womanBtn = findViewById(R.id.womanButton);
        Button confirm = findViewById(R.id.confirmAdd);

        Button weightButton = findViewById(R.id.weightButton);
        Button heightButton = findViewById(R.id.heightButton);

        EditText childName = findViewById(R.id.add_child_nameText);
        EditText callNumber = findViewById(R.id.parentPhoneNumber);
        EditText missingPlace = findViewById(R.id.missingLocation);

        for(int i=0;i<item.length;i++) {

            item[i] = Integer.toString(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        findChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findChangeButton.setEnabled(false);
                findChangeButton.setVisibility(View.INVISIBLE);

                protectChangeButton.setEnabled(true);
                protectChangeButton.setVisibility(View.VISIBLE);

                Intent intent = new Intent(getApplicationContext(), AddProtectChildActivity.class);
                startActivity(intent);
            }
        });

        protectChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findChangeButton.setEnabled(true);
                findChangeButton.setVisibility(View.VISIBLE);

                protectChangeButton.setEnabled(false);
                protectChangeButton.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(getApplicationContext(), AddChildActivity.class);
                startActivity(intent);
            }
        });

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                age = ageSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        manBtn.setOnClickListener(I -> {

            manBtn.setEnabled(false);
            manBtn.setVisibility(View.INVISIBLE);

            womanBtn.setEnabled(true);
            womanBtn.setVisibility(View.VISIBLE);

            sex = "여자";
        });

        womanBtn.setOnClickListener(I -> {

            manBtn.setEnabled(true);
            manBtn.setVisibility(View.VISIBLE);

            womanBtn.setEnabled(false);
            womanBtn.setVisibility(View.INVISIBLE);

            sex = "남자";
        });

        image.setOnClickListener(I -> {

            tedPermission();
        });

        confirm.setOnClickListener(I -> {

            name = childName.getText().toString();
            call = callNumber.getText().toString();
            place = missingPlace.getText().toString();

            if(name.equals("") || call.equals("")) {

                Toast.makeText(getApplicationContext(), "필수 입력란을 채워주세요.", Toast.LENGTH_LONG).show();
            }
            else { // 값이 다 채워졌으면

                Toast.makeText(getApplicationContext(), "모든 항목이 입력되었습니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), ChildListviewActivity.class);

                intent.putExtra("childName", name);
                intent.putExtra("childAge", age);
                intent.putExtra("childSex", sex);
                intent.putExtra("phoneNumber", call);
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

        TedPermission.with(getApplicationContext())
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
