package com.hudutech.njerucyrus.parkingfinder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    public MainMapFragment() {
        // Required empty public constructor
    }

    SupportMapFragment suportMapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_map, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map =  googleMap;
        LatLng pinPoint = new LatLng(-122.0840, 37.4220);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(pinPoint).title("Current Location");
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLng(pinPoint));
    }
}
