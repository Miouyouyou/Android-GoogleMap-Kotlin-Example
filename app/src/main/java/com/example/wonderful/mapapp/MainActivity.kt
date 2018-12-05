package com.example.wonderful.mapapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as MyMapFragment
        /*mapFragment.initial_latitude = -10.0
        mapFragment.initial_longitude = 115.0
        mapFragment.initial_marker = "Inishol mawker"*/
        mapFragment.getMapAsync(mapFragment)
        System.err.println("OnCreate end")
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
