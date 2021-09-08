package com.example.electricity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InformacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val texttitulo = findViewById<TextView>(R.id.textViewTitulo)
        val textViewMensaje = findViewById<TextView>(R.id.textViewMensaje)
        val imageViewTigo = findViewById<ImageView>(R.id.imageViewTigo)
        val textViewTigo = findViewById<TextView>(R.id.textViewg)
        val imageViewEntel = findViewById<ImageView>(R.id.imageViewEntel)
        val textViewEntel = findViewById<TextView>(R.id.textViewGG)
        val imageViewCotel = findViewById<ImageView>(R.id.imageViewCotel)
        val textCotel = findViewById<TextView>(R.id.textViewggg)
        val imageViewDelapaz = findViewById<ImageView>(R.id.imageViewDelapaz)
        val textDelapaz = findViewById<TextView>(R.id.textViewgggg)

        imageViewTigo.setOnClickListener {
            Toast.makeText(this, "BIENVENIDO :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TigoActivity::class.java)
            startActivity(intent)
        }

        imageViewEntel.setOnClickListener {
            Toast.makeText(this, "BIENVENIDO :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EntelActivity::class.java)
            startActivity(intent)
        }

        imageViewCotel.setOnClickListener {
            Toast.makeText(this, "BIENVENIDO :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CotelActivity::class.java)
            startActivity(intent)
        }

        imageViewDelapaz.setOnClickListener {
            Toast.makeText(this, "BIENVENIDO :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DelapazActivity::class.java)
            startActivity(intent)
        }
    }
}