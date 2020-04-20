package com.gmail.neirdag.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    private var locationManager : LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()
        button = findViewById(R.id.show_geoloc)



        button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_frame, GeolocFragment())
                addToBackStack(null)
            }.commit()

        }
    }

    fun FragmentActivity.change(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            //replacer le précédent fragment, s'il existe
            replace(R.id.fragment_frame, fragment)
            //ajouter la transaction dans la stack
            addToBackStack(null)
        }.commit()
    }


}

