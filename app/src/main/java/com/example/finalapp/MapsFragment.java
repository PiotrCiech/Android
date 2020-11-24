package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robin.locationgetter.EasyLocation;

public class MapsFragment extends Fragment {

    private GoogleMap map;
    private FloatingActionButton floatingActionButton;

    boolean autopositioning = true;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng sydney = new LatLng(-34, 151);
            map = googleMap;
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        floatingActionButton = view.findViewById(R.id.gps_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autopositioning = !autopositioning;
            }
        });
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new EasyLocation(getActivity(), new EasyLocation.EasyLocationCallBack() {
            @Override
            public void permissionDenied() {

            }

            @Override
            public void locationSettingFailed() {
                Log.d("MapsFragment", "locationSettingFailed");
            }

            @Override
            public void getLocation(Location location) {if(autopositioning) {
                Log.d("MapsFragment", "getLocation: " + location.toString());
                LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
                map.addMarker(new MarkerOptions().position(point).title("Marker"));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 10.2f));
            }
            }
        });
    }
}