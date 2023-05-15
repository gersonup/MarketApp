package com.example.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MarketApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnenviar1 = findViewById<Button>(R.id.btnRegistro)

        btnenviar1.setOnClickListener {
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
        val btnenviar2 = findViewById<Button>(R.id.btnIngresar)

        btnenviar2.setOnClickListener {
            val intent = Intent(this, Articulos::class.java)
            startActivity(intent)
        }
    }
}