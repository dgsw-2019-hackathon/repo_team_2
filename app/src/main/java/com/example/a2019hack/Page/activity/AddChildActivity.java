package com.example.a2019hack.Page.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a2019hack.R;
import com.example.a2019hack.data.Child;

public class AddChildActivity extends AppCompatActivity {

    String [] item = new String[100];
    String name, call, sex, place, age;
    Child childData;
    Boolean sexToggle = false; // true = man, false = woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        final Spinner ageSpinner = findViewById(R.id.ageSpinner);
        Button manBtn = findViewById(R.id.manButton);
        Button womanBtn = findViewById(R.id.womanButton);
        Button confirm = findViewById(R.id.confirmAdd);
        EditText childName = findViewById(R.id.add_child_nameText);
        EditText callNumber = findViewById(R.id.parentPhoneNumber);

        name = childName.getText().toString();
        call = callNumber.getText().toString();

        // 나이 콤보박스 및 선택 시 이벤트
        for(int i = 0; i < item.length; i++){
            item[i] = Integer.toString(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age = ageSpinner.getSelectedItem().toString();
                //childData.setChildAge(ageSpinner.getSelectedItem().toString());
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

        confirm.setOnClickListener(I -> {
            if(name.equals("") || call.equals("") || ageSpinner.getSelectedItem().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "필수 입력란을 채워주세요.", Toast.LENGTH_LONG);
                toast.show();
            } else {
                childData.setChildSex(sex);
                childData.setChildAge(age);
                childData.setChildName(name);
            }
        });

    }

}
