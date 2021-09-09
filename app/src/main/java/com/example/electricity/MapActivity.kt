package com.example.electricity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        createMapFragment()
    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapCableado) as SupportMapFragment
        mapFragment.getMapAsync(this)     }

    override fun onMapReady(p0: GoogleMap) {
        map=p0
        map.addMarker(MarkerOptions().position(LatLng(-16.575036228355355, -68.1263274753755)))
        map.addMarker(MarkerOptions().position(LatLng(-16.57578485581285, -68.12665485552319)))
        map.addMarker(MarkerOptions().position(LatLng(-16.575856836660034, -68.12721275497202)))
        map.addMarker(MarkerOptions().position(LatLng(-16.57512160245424, -68.12740587401201)))
        map.addMarker(MarkerOptions().position(LatLng(-16.574669149239515, -68.12752925562089)))
        map.addMarker(MarkerOptions().position(LatLng(-16.574185845767307, -68.12788330719418)))
        map.addMarker(MarkerOptions().position(LatLng(-16.57457146033765, -68.12697672058982)))
    }
}