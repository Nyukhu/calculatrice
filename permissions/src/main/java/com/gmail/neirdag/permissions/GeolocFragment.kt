package com.gmail.neirdag.permissions

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.fragment.app.Fragment


class GeolocFragment : Fragment(){
    lateinit var latitudeText: TextView
    lateinit var longitudeText: TextView
    private var locationManager : LocationManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.geoloc_fragment_layout, container, false)
    }

    override fun onStart() {
        super.onStart()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            0 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {


                } else {
                    val errorToast = Toast.makeText(this.activity,"error, acces to gps denied", Toast.LENGTH_LONG)
                    errorToast.show()
                }
            }
            else -> {
                // Le code ne concerne pas la permission, on l'ignore
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latitudeText = view.findViewById(R.id.latitudeTextView)
        longitudeText = view.findViewById(R.id.longitudeTextView)
        latitudeText.text = "ca"
        longitudeText.text = "marche"

        if (ContextCompat.checkSelfPermission(
                this.activity!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this.activity!!,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                val builder = AlertDialog.Builder(this.activity)
                builder.setTitle("Hey !")
                builder.setMessage("avec la géoloc, on peut faire des trucs cools")
                //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->

                    ActivityCompat.requestPermissions(
                        this.activity!!,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        0
                    )
                }

                builder.setNegativeButton(android.R.string.no) { dialog, which -> }

                builder.show()
            } else {
                ActivityCompat.requestPermissions(
                    this.activity!!,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    0

                )
            }
        } else {

        }

    }

}