package com.example.projectandroid

import android.content.Intent
import android.graphics.LinearGradient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.ViewCompat

import androidx.fragment.app.Fragment

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
    View.OnClickListener {


    private lateinit var mMap: GoogleMap
    private lateinit var mMap2: GoogleMap

    lateinit var konten : LinearLayout
    lateinit var overBox : LinearLayout
    lateinit var btnClose : ImageView
    lateinit var btnDetail : Button
    lateinit var fromsmall : Animation
    lateinit var fromnothing : Animation
    lateinit var forbtnClose : Animation
    lateinit var toClose : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap2 = googleMap

        // Add a marker in Sydney and move the camera
        val uad = LatLng(-7.833234900000001,110.3831212)
        val saya = LatLng(-7.8276337,110.3796486)

        mMap.addMarker(MarkerOptions()
            .position(uad)
            .title("Marker"))
        mMap2.addMarker(MarkerOptions()
            .position(saya)
            .title("Saya"))

        mMap.setOnMarkerClickListener(this)
        mMap2.setOnMarkerClickListener(this)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uad,15f))
        mMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(saya,15f))

//        Animation
        fromsmall = AnimationUtils.loadAnimation(this,R.anim.fromsmall)
        fromnothing = AnimationUtils.loadAnimation(this,R.anim.fromnothing)
        forbtnClose = AnimationUtils.loadAnimation(this,R.anim.forbtnclose)
        toClose = AnimationUtils.loadAnimation(this,R.anim.toclose)

//        Declare component in xml
        konten = findViewById(R.id.konten)
        overBox = findViewById(R.id.overbox)
        btnClose = findViewById(R.id.btn_close)
        btnClose.setOnClickListener(this)
        btnDetail = findViewById(R.id.btn_detail)
        btnDetail.setOnClickListener(this)

        konten.alpha=0f
        overBox.alpha=0f
        btnClose.alpha=0f
    }

    override fun onMarkerClick(p0: Marker): Boolean {
        when(p0.title){
            "Marker"->{
                val intentMain = Intent(this@MapsActivity, MainActivity::class.java)
                startActivity(intentMain)
            }
            "Saya"->{
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
            }
        }
        return false
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_close->{
                overBox.alpha=0f
                konten.startAnimation(toClose)
                btnClose.startAnimation(toClose)

                ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
            }
            R.id.btn_detail->{

            }
        }
    }

}
