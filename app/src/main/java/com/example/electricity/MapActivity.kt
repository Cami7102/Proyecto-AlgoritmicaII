package com.example.electricity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import kotlin.collections.HashMap


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private val sort: Unit
        get() {
            TODO()
        }


    private lateinit var map: GoogleMap

    var MAX_N:Int = 10000
    var nodos: IntArray = intArrayOf(10000)
    var parent: IntArray = intArrayOf(10000)
    var rango: IntArray = intArrayOf(10000)
    var numeroNodos:Int = 0
    var numeroAristas:Int = 7


    var locations: Array<LatLng> = arrayOf(LatLng(-16.575036228355355, -68.1263274753755),
                                           LatLng(-16.57578485581285, -68.12665485552319),
                                           LatLng(-16.575856836660034, -68.12721275497202),
                                           LatLng(-16.57512160245424, -68.12740587401201),
                                           LatLng(-16.574669149239515, -68.12752925562089),
                                           LatLng(-16.574185845767307, -68.12788330719418),
                                           LatLng(-16.57457146033765, -68.12697672058982)
                                            )
    var postes: HashMap<Int, LatLng> = hashMapOf()
    //var points: IntArray = intArrayOf(90,60,80,50,70,110,90)
    var points: Array<IntArray> = arrayOf(
        intArrayOf(90, 90, 0, 0, 0, 0,0),
        intArrayOf(90, 60, 0, 0, 0, 115, 114),
        intArrayOf(60, 0, 0, 80, 0, 85, 0),
        intArrayOf(0, 0, 80, 0, 50, 120, 0),
        intArrayOf(50, 0, 0, 0, 0, 70, 0),
        intArrayOf(0, 0, 120, 109, 70, 0, 0),
        intArrayOf(0, 115, 0, 0, 0, 0, 110)
    )

    var n: Int = 0
    var m: Int = 0

    private lateinit var text:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        createMapFragment()

        postes[0] = LatLng(-16.575036228355355, -68.1263274753755)
        postes[1] = LatLng(-16.57578485581285, -68.12665485552319)
        postes[2] = LatLng(-16.575856836660034, -68.12721275497202)
        postes[3] = LatLng(-16.57512160245424, -68.12740587401201)
        postes[4] = LatLng(-16.574669149239515, -68.12752925562089)
        postes[5] = LatLng(-16.574185845767307, -68.12788330719418)
        postes[6] = LatLng(-16.57457146033765, -68.12697672058982)



        text = findViewById<TextView>(R.id.textView32)
        text.text = minCostConnectPoints1(points).toString()
    }


    private fun createMapFragment() {
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapCableado) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        for (i in 0..6){
            map.addMarker(MarkerOptions().position(locations[i]))
        }

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-16.4963238471052, -64.48222396894373), 3f))

    }



    private class EdgePoint(
        val from: Int, // Index of first point
        val to: Int,   // Index of another point
        val cost: Int  // Cost between points
    )

    private fun buildGraph(points: Array<IntArray>): PriorityQueue<EdgePoint> {
        val edges = PriorityQueue<EdgePoint> { o1, o2 -> o1.cost - o2.cost } // Compare by costs
        for (i in points.indices) {
            val (x1, y1) = points[i]
            for (j in i + 1 until points.size) { // We add ALL of vertex to our PQ.
                val (x2, y2) = points[j]
                val cost = Math.abs(x2 - x1) + Math.abs(y2 - y1) // Calculate costs
                val edgePoint = EdgePoint(i, j, cost)
                edges.offer(edgePoint)
            }
        }
        return edges
    }

    private class UFMinConst(n: Int) {
        private val array = Array(n) { it }
        fun union(x1: Int, x2: Int) {
            val p1 = find(x1)
            val p2 = find(x2)
            if (p1 == p2) return
            array[p1] = p2
        }

        fun find(x: Int): Int {
            if (array[x] == x) return x
            val parent = find(array[x])
            array[x] = parent
            return parent
        }

        fun connected(x1: Int, x2: Int): Boolean = find(x1) == find(x2)

    }

    fun minCostConnectPoints1(points: Array<IntArray>): Int {
        val graph = buildGraph(points) // Implelemtation above
        val uf = UFMinConst(points.size) // Implelemtation above
        var costMst = 0 // Our MST, but need only cost
        while (graph.isNotEmpty()) {
            val edge = graph.poll()
            if (uf.connected(edge.from, edge.to).not()) { // no need to add cycles =)
                uf.union(edge.from, edge.to)
                costMst += edge.cost
            }
        }
        return costMst
    }

}