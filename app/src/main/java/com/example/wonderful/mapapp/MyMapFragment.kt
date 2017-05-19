package com.example.wonderful.mapapp

import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MyMapFragment : SupportMapFragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onMapReady(map: GoogleMap?) {
        System.err.println("OnMapReady start")
        mMap = map as GoogleMap;

        val sydney = LatLng(-34.0, 151.0);
        mMap.addMarker(MarkerOptions().position(sydney).title("Seed nay"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Toast.makeText(this.context, "OnMapReady end", Toast.LENGTH_LONG).show()
    }

}