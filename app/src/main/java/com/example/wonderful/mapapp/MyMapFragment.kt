package com.example.wonderful.mapapp

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MyMapFragment : SupportMapFragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    private var initial_latitude  = -34.0
    private var initial_longitude = 151.0
    private var initial_marker    = "Seed nay"
    override fun onInflate(context: Context?, attrs: AttributeSet?, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        attrs ?: return
        context ?: return

        val typed_array = context.obtainStyledAttributes(attrs,
                R.styleable.MyyMap, 0, 0)

        try {
            val provided_latitude =
                    typed_array.getFloat(R.styleable.MyyMap_latitude, initial_latitude.toFloat())
            initial_latitude  = provided_latitude.toDouble()

            val provided_longitude =
                    typed_array.getFloat(R.styleable.MyyMap_longitude, initial_longitude.toFloat())
            initial_longitude = provided_longitude.toDouble()

            val provided_marker =
                    typed_array.getString(R.styleable.MyyMap_marker)
            provided_marker?.apply { initial_marker = provided_marker }

        }
        catch(e: Exception) {

        }

        typed_array.recycle()

    }
    override fun onMapReady(map: GoogleMap?) {
        System.err.println("OnMapReady start")
        mMap = map as GoogleMap;

        val sydney = LatLng(initial_latitude, initial_longitude);
        mMap.addMarker(MarkerOptions().position(sydney).title(initial_marker));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Toast.makeText(this.context, "OnMapReady end", Toast.LENGTH_LONG).show()
    }

}
