package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ask.R
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var log: EditText
    private lateinit var mbutton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initialise()

        mbutton = findViewById(R.id.btn_registro)

        mbutton.setOnClickListener {
            registerUser()
        }
    }

    private fun initialise() {
        etEmail = findViewById(R.id.editTextTextPersonName)
        etPassword = findViewById(R.id.editTextTextPassword)

        mAuth = FirebaseAuth.getInstance()
    }

    private fun registerUser() {
        val email = etEmail.text.toString()
        val pass = etPassword.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() ) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        mAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Hubo un error intentelo mas tarde", Toast.LENGTH_SHORT).show()
                }
            }

    }


}