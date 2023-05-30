package com.example.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

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
            val signInEmailEdt = findViewById<EditText>(R.id.signInEmailEdt)
            val signInPasswordEdt = findViewById<EditText>(R.id.sign_in_password_edt)
            if (signInEmailEdt.text.isNotEmpty() && signInPasswordEdt.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    signInEmailEdt.text.toString(),
                    signInPasswordEdt.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result.user?.email ?:"", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            } else {
                Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.sing_up_btn).setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private  fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario.")
        builder.setPositiveButton("Ok", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra( "email",email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}