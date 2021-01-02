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
import com.example.projectandroid.risandio.MainActivity2
import com.example.projectandroid.risandio.MainActivity3
import com.example.projectandroid.risandio.MainActivity4
import com.example.projectandroid.risandio.MainActivity5

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
    private lateinit var mMap3: GoogleMap
    private lateinit var mMap4: GoogleMap
    private lateinit var mMap5: GoogleMap

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
        mMap3 = googleMap
        mMap4 = googleMap
        mMap5 = googleMap

        // Add a marker in Sydney and move the camera
        val uad = LatLng(-7.833234900000001,110.3831212)
        val briman = LatLng(-7.8276337,110.3796486)
        val grojogan = LatLng(-7.845274, 110.390919)
        val asri = LatLng(-7.835922, 110.391057)
        val madrasah = LatLng(-7.830895, 110.387720)

        mMap.addMarker(MarkerOptions()
            .position(uad)
            .title("Marker"))
        mMap2.addMarker(MarkerOptions()
            .position(briman)
            .title("briman"))
        mMap3.addMarker(MarkerOptions()
            .position(grojogan)
            .title("grojogan"))
        mMap4.addMarker(MarkerOptions()
            .position(asri)
            .title("asri"))
        mMap5.addMarker(MarkerOptions()
            .position(madrasah)
            .title("madrasah"))


        mMap.setOnMarkerClickListener(this)
        mMap2.setOnMarkerClickListener(this)
        mMap3.setOnMarkerClickListener(this)
        mMap4.setOnMarkerClickListener(this)
        mMap5.setOnMarkerClickListener(this)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uad,15f))
        mMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(briman,15f))
        mMap3.moveCamera(CameraUpdateFactory.newLatLngZoom(grojogan,15f))
        mMap4.moveCamera(CameraUpdateFactory.newLatLngZoom(asri,15f))
        mMap5.moveCamera(CameraUpdateFactory.newLatLngZoom(madrasah,15f))

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
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
                btn_close.setOnClickListener {
                    overBox.alpha=0f
                    konten.startAnimation(toClose)
                    btnClose.startAnimation(toClose)

                    ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                    ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
                }
                btn_detail.setOnClickListener {
                    val intentview = Intent(this@MapsActivity, MainActivity2::class.java)
                    startActivity(intentview)
                }
            }
            "briman"->{
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
                btn_close.setOnClickListener {
                    overBox.alpha=0f
                    konten.startAnimation(toClose)
                    btnClose.startAnimation(toClose)

                    ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                    ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
                }
                btn_detail.setOnClickListener {
                    val intentview1 = Intent(this@MapsActivity, MainActivity2::class.java)
                    startActivity(intentview1)
                }
            }
            "grojogan"->{
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
                btn_close.setOnClickListener {
                    overBox.alpha=0f
                    konten.startAnimation(toClose)
                    btnClose.startAnimation(toClose)

                    ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                    ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
                }
                btn_detail.setOnClickListener {
                    val intentview2 = Intent(this@MapsActivity, MainActivity3::class.java)
                    startActivity(intentview2)
                }
            }
            "asri"->{
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
                btn_close.setOnClickListener {
                    overBox.alpha=0f
                    konten.startAnimation(toClose)
                    btnClose.startAnimation(toClose)

                    ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                    ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
                }
                btn_detail.setOnClickListener {
                    val intentview3 = Intent(this@MapsActivity, MainActivity4::class.java)
                    startActivity(intentview3)
                }
            }
            "madrasah"->{
                btnClose.alpha=1f
                btnClose.startAnimation(forbtnClose)
                overBox.alpha=1f
                overBox.startAnimation(fromnothing)
                konten.alpha=1f
                konten.startAnimation(fromsmall)
                btn_close.setOnClickListener {
                    overBox.alpha=0f
                    konten.startAnimation(toClose)
                    btnClose.startAnimation(toClose)

                    ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                    ViewCompat.animate(btnClose).setStartDelay(1000).alpha(0f).start()
                }
                btn_detail.setOnClickListener {
                    val intentview4 = Intent(this@MapsActivity, MainActivity5::class.java)
                    startActivity(intentview4)
                }
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
