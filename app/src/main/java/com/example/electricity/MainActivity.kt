package com.example.electricity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewLogo = findViewById<ImageView>(R.id.imageViewLogo)
        val buttonInicio = findViewById<Button>(R.id.buttonInicio)

        buttonInicio.setOnClickListener {
            Toast.makeText(this, "BIENVENIDO :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, OpcionesActivity::class.java)
            startActivity(intent)
        }
    }
}