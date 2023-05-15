package com.example.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val btnenviar3 = findViewById<Button>(R.id.btnRegistro2)

        btnenviar3.setOnClickListener {
            val intent = Intent(this, Articulos::class.java)
            startActivity(intent)
        }
        val btnenviar4 = findViewById<Button>(R.id.btnYaTengo)

        btnenviar4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}