package com.example.electricity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class OpcionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val imageViewcableado = findViewById<ImageView>(R.id.imageViewCableado)
        val imageViewempresa = findViewById<ImageView>(R.id.imageViewEmpresas)
        val textViewtitle = findViewById<TextView>(R.id.textViewTitle)

        imageViewcableado.setOnClickListener {
            Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        imageViewempresa.setOnClickListener {
            Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, InformacionActivity::class.java)
            startActivity(intent)
        }
    }
}