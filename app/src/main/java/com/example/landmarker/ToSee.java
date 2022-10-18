package com.example.landmarker;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class ToSee extends AppCompatActivity implements OnMapReadyCallback {

    String Latitude ,Longitude ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_see);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.m2);
        mapFragment.getMapAsync(this);


    }

    @SuppressLint("MissingPermission")
    public void onMapReady(GoogleMap Map) {

        // Map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng pretoria = new LatLng(-25.7478676, 28.2292712);
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pretoria, 15));
        Map.animateCamera(CameraUpdateFactory.newLatLngZoom(pretoria, 10));

        Map.getUiSettings().setZoomControlsEnabled(true);
        Map.getUiSettings().setZoomGesturesEnabled(true);

        Map.setMyLocationEnabled(true);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}