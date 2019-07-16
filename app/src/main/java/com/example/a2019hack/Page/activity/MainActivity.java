package com.example.a2019hack.Page.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    private TextView listButtonText;
    private TextView plusButtonText;
    private TextView searchButtonText;
    private TextView peopleButtonText;

    FragmentManager fragmentManager = getSupportFragmentManager();

    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        setting();

        event();
    }

    private void initData() {

        changeFindButton = findViewById(R.id.changeFindButton);
        changeProtectButton = findViewById(R.id.changeProtectButton);

        listButton = findViewById(R.id.listButton);
        plusButton = findViewById(R.id.plusButton);
        searchButton = findViewById(R.id.searchButton);
        peopleButton = findViewById(R.id.peopleButton);

        listButtonText = findViewById(R.id.listButtonText);
        plusButtonText = findViewById(R.id.plusButtonText);
        searchButtonText = findViewById(R.id.searchButtonText);
        peopleButtonText = findViewById(R.id.peopleButtonText);

        fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
        fragmentTransaction.commit();
    }

    private void setting() {

        changeFindButton.setVisibility(View.VISIBLE);
        changeFindButton.setEnabled(true);

        changeProtectButton.setVisibility(View.INVISIBLE);
        changeProtectButton.setEnabled(false);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickListButton();
        clickPlusButton();
        clickSearchButton();
        clickPeopleButton();

        clickChangeFindButton();
        clickChangeProtectButton();
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
        });
    }

    private void clickChangeFindButton() {

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
    }

    private void clickChangeProtectButton() {

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
