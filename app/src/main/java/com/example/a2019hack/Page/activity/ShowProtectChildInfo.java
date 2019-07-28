package com.example.a2019hack.Page.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a2019hack.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowProtectChildInfo extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_protect_child_info);

        TextView childName = findViewById(R.id.childName);
        TextView childSex = findViewById(R.id.childSex);
        TextView childAge = findViewById(R.id.childAge);
        TextView childPlace = findViewById(R.id.childPlace);
        TextView childHeight = findViewById(R.id.childHeight);
        TextView childWeight = findViewById(R.id.childWeight);
        TextView detailContents = findViewById(R.id.detailContentsText);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        Intent intent = getIntent();

        String childNames = intent.getStringExtra("childName");
        String childAges = intent.getStringExtra("childAge");
        String childSexs = intent.getStringExtra("childSex");
        String phonNumbers = intent.getStringExtra("phoneNumber");
        String childHeights = intent.getStringExtra("childHeight");
        String childWeights = intent.getStringExtra("childWeight");
        String places = intent.getStringExtra("place");
        String contentss = intent.getStringExtra("detailContents");

        childName.setText(childNames);
        childSex.setText(childSexs);
        childAge.setText(childAges);
        childPlace.setText(places);
        childHeight.setText(childHeights);
        childWeight.setText(childWeights);
        detailContents.setText(contentss);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
