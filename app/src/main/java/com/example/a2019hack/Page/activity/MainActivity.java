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

        changeFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFindButton.setVisibility(View.INVISIBLE);
                changeFindButton.setEnabled(false);

                changeProtectButton.setEnabled(true);
                changeProtectButton.setVisibility(View.VISIBLE);

                fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
                fragmentTransaction.commit();
            }
        });

        changeProtectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFindButton.setVisibility(View.VISIBLE);
                changeFindButton.setEnabled(true);

                changeProtectButton.setEnabled(false);
                changeProtectButton.setVisibility(View.INVISIBLE);

                fragmentTransaction.replace(R.id.fragment, new ChildProtectListviewActivity());
                fragmentTransaction.commit();
            }
        });
    }
}
