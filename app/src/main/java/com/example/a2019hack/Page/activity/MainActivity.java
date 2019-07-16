package com.example.a2019hack.Page.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a2019hack.R;
import com.example.a2019hack.adapter.ChildListviewAdapter;
import com.example.a2019hack.data.Child;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView childListView;
    private ChildListviewAdapter childListviewAdapter;

    private ArrayList<Child> childList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        childList = new ArrayList<>();

        childListView = findViewById(R.id.childListView);

        childList.add(new Child(
                R.drawable.child_image, "제정민", "남", "대구소프트웨어고 정문", "18", "185cm", "80kg"));

        childList.add(new Child(
                R.drawable.child_image, "제정민", "남", "대구소프트웨어고 정문", "18", "185cm", "80kg"));

        childList.add(new Child(
                R.drawable.child_image, "제정민", "남", "대구소프트웨어고 정문", "18", "185cm", "80kg"));

        childList.add(new Child(
                R.drawable.child_image, "제정민", "남", "대구소프트웨어고 정문", "18", "185cm", "80kg"));

        childList.add(new Child(
                R.drawable.child_image, "제정민", "남", "대구소프트웨어고 정문", "18", "185cm", "80kg"));


        Collections.reverse(childList);

        childListviewAdapter = new ChildListviewAdapter(this, childList);

        childListView.setAdapter(childListviewAdapter);

        childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}
