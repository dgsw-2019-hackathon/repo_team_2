package com.example.a2019hack.Page.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a2019hack.Page.fragment.ChildListviewActivity;
import com.example.a2019hack.Page.fragment.ChildProtectListviewActivity;
import com.example.a2019hack.R;

public class MainActivity extends AppCompatActivity {

    private Button changeFindButton;
    private Button changeProtectButton;

    private ImageView listButton;
    private ImageView plusButton;
    private ImageView searchButton;
    private ImageView peopleButton;

    FragmentManager fragmentManager = getSupportFragmentManager();

    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFindButton = findViewById(R.id.changeFindButton);
        changeProtectButton = findViewById(R.id.changeProtectButton);

        listButton = findViewById(R.id.listButton);
        plusButton = findViewById(R.id.plusButton);
        searchButton = findViewById(R.id.searchButton);
        peopleButton = findViewById(R.id.peopleButton);

        fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
        fragmentTransaction.commit();

        changeFindButton.setVisibility(View.VISIBLE);
        changeFindButton.setEnabled(true);

        changeProtectButton.setVisibility(View.INVISIBLE);
        changeProtectButton.setEnabled(false);

        listButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "listButton", Toast.LENGTH_SHORT).show();
        });

        plusButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "plusButton", Toast.LENGTH_SHORT).show();
        });

        searchButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "searchButton", Toast.LENGTH_SHORT).show();
        });

        peopleButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "peopleButton", Toast.LENGTH_SHORT).show();
        });

        changeFindButton.setOnClickListener(v -> {

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            changeFindButton.setVisibility(View.INVISIBLE);
            changeFindButton.setEnabled(false);

            changeProtectButton.setVisibility(View.VISIBLE);
            changeProtectButton.setEnabled(true);

            fragmentTransaction.replace(R.id.fragment, new ChildProtectListviewActivity());
            fragmentTransaction.commit();
        });

        changeProtectButton.setOnClickListener(v -> {

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            changeFindButton.setVisibility(View.VISIBLE);
            changeFindButton.setEnabled(true);

            changeProtectButton.setVisibility(View.INVISIBLE);
            changeProtectButton.setEnabled(false);

            fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
            fragmentTransaction.commit();
        });
    }
}
