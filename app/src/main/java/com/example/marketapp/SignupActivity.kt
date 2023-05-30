package com.example.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setup()
    }

    private fun setup() {
        findViewById<Button>(R.id.signupBtn).setOnClickListener {
            val signupEmailEditTxt = findViewById<EditText>(R.id.signInEmailEdt)
            val signupPasswordFirstEditTxt = findViewById<EditText>(R.id.sign_in_password_edt)
            val signupPasswordSecondEditTxt = findViewById<EditText>(R.id.signup_password_second_edt)
            if (signupEmailEditTxt.text.isNotEmpty() &&
                signupPasswordFirstEditTxt.text.isNotEmpty() &&
                signupPasswordSecondEditTxt.text.isNotEmpty()) {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    signupEmailEditTxt.text.toString(),
                    signupPasswordSecondEditTxt.text.toString()
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

        findViewById<Button>(R.id.i_already_have_account_btn).setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
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
        val homeIntent = Intent(this, Articulos::class.java).apply {
            putExtra( "email",email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}