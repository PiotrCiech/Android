package com.example.finalapp;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private TextView textViewEmail;
    private TextView textViewPassword;
    private Button button;


    GoogleMap mapAPI;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new Fragment();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        //Open google Api fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

        //RoomDatabase

        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new FlatFragment())
                    .addToBackStack("FLATFRAGMENT")
                    .commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new MapsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            break;
                        case R.id.nav_saved:
                            selectedFragment = new FlatFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                            break;

                    }



                    return true;
                }

            };

    public void logout1(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}