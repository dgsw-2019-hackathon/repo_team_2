package com.example.a2019hack.Page.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2019hack.Page.fragment.ChildListviewActivity;
import com.example.a2019hack.Page.fragment.ChildProtectListviewActivity;
import com.example.a2019hack.R;

public class MainActivity extends AppCompatActivity {

    private Button changeFindButton;
    private Button changeProtectButton;

    FragmentManager fragmentManager = getSupportFragmentManager();

    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFindButton = findViewById(R.id.changeFindButton);
        changeProtectButton = findViewById(R.id.changeProtectButton);

        fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
        fragmentTransaction.commit();

        changeFindButton.setVisibility(View.VISIBLE);
        changeFindButton.setEnabled(true);

        changeProtectButton.setVisibility(View.INVISIBLE);
        changeProtectButton.setEnabled(false);

        changeFindButton.setOnClickListener(v -> {

            changeFindButton.setVisibility(View.INVISIBLE);
            changeFindButton.setEnabled(false);

            changeProtectButton.setVisibility(View.VISIBLE);
            changeProtectButton.setEnabled(true);

            fragmentTransaction.replace(R.id.fragment, new ChildProtectListviewActivity());
        });

        changeProtectButton.setOnClickListener(v -> {

            changeFindButton.setVisibility(View.VISIBLE);
            changeFindButton.setEnabled(true);

            changeProtectButton.setVisibility(View.INVISIBLE);
            changeProtectButton.setEnabled(false);

            fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
        });
    }
}
