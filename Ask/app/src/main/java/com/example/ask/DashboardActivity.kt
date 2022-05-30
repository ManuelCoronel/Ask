package com.example.ask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var nombre: TextView
    private lateinit var salir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        nombre = findViewById(R.id.textView9)
        salir = findViewById(R.id.btn_salir)
        salir.setOnClickListener {
            salir()
        }
        initialise()
    }

    private fun initialise() {
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        nombre.setText(mAuth.currentUser?.displayName ?: "NONE")
    }

    private fun salir() {
        mAuth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}