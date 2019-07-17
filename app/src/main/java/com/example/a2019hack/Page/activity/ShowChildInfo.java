package com.example.a2019hack.Page.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.a2019hack.Page.fragment.MainPageFragment;
import com.example.a2019hack.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowChildInfo extends AppCompatActivity implements OnMapReadyCallback {

    private ImageView listButton;
    private ImageView plusButton;
    private ImageView searchButton;
    private ImageView peopleButton;

    private TextView listButtonText;
    private TextView plusButtonText;
    private TextView searchButtonText;
    private TextView peopleButtonText;

    private GoogleApiClient mGoogleApiClient = null;
    private GoogleMap mGoogleMap = null;
    private Marker currentMarker = null;

    private static final String TAG = "googlemap_example";
    private static final int GPS_ENABLE_REQUEST = 2001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_info);

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
        mapFragment.getMapAsync(this);

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
