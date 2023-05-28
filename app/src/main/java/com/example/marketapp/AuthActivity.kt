package com.example.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MarketApp)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // setup
        setup()
    }

    private fun setup() {

        title = "Authenticate"

        findViewById<Button>(R.id.sign_in_btn).setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.sign_up_email_edt)
            val passwordEditText = findViewById<EditText>(R.id.signup_password_first_edt)
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {

            }

            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.sing_up_btn).setOnClickListener {
            val intent = Intent(this, Articulos::class.java)
            startActivity(intent)
        }
    }
}