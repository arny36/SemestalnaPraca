package com.example.semestalnapraca;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.semestalnapraca.databinding.ActivityMapaBinding;
/**
 *Mapa je klasická google mapa. Musel som ju implementovať z googlu pomocou kľúča.
 *
 */
public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Pomocou parametra v zilina som nastavil že mobil sa bude nachádzať v Žiline na námesti
     * Po  otvoreni mapy budete mať červenú šípku na mape kde sa nachádzame
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng zilina = new LatLng(49.22315, 18.73941);
        mMap.addMarker(new MarkerOptions().position(zilina).title("Marker in Zilina"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(zilina));
    }
}