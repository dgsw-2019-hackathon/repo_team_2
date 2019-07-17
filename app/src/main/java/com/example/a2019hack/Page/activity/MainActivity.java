package com.example.a2019hack.Page.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a2019hack.Page.fragment.MainPageFragment;
import com.example.a2019hack.Page.fragment.MyPageFragment;
import com.example.a2019hack.Page.fragment.SearchFragment;
import com.example.a2019hack.R;

public class MainActivity extends AppCompatActivity {

    private ImageView listButton;
    private ImageView plusButton;
    private ImageView searchButton;
    private ImageView peopleButton;

    private TextView listButtonText;
    private TextView plusButtonText;
    private TextView searchButtonText;
    private TextView peopleButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        event();
    }

    private void initData() {

        listButton = findViewById(R.id.listButton);
        plusButton = findViewById(R.id.plusButton);
        searchButton = findViewById(R.id.searchButton);
        peopleButton = findViewById(R.id.peopleButton);

        listButtonText = findViewById(R.id.listButtonText);
        plusButtonText = findViewById(R.id.plusButtonText);
        searchButtonText = findViewById(R.id.searchButtonText);
        peopleButtonText = findViewById(R.id.peopleButtonText);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragmentMain, new MainPageFragment());
        fragmentTransaction.commit();
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickListButton();
        clickPlusButton();
        clickSearchButton();
        clickPeopleButton();
    }

    private void clickListButton() {

        listButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list_act));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_2));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

            listButtonText.setVisibility(View.VISIBLE);
            plusButtonText.setVisibility(View.INVISIBLE);
            searchButtonText.setVisibility(View.INVISIBLE);
            peopleButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentMain, new MainPageFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickPlusButton() {

        plusButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus_act));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_2));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.VISIBLE);
            searchButtonText.setVisibility(View.INVISIBLE);
            peopleButtonText.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(getApplicationContext(), AddChildActivity.class);
            startActivity(intent);
        });
    }

    private void clickSearchButton() {

        searchButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_2_act));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.INVISIBLE);
            searchButtonText.setVisibility(View.VISIBLE);
            peopleButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentMain, new SearchFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickPeopleButton() {

        peopleButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_2));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people_act));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.INVISIBLE);
            searchButtonText.setVisibility(View.INVISIBLE);
            peopleButtonText.setVisibility(View.VISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentMain, new MyPageFragment());
            fragmentTransaction.commit();
        });
    }
}
