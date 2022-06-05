package com.example.ask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var nombre: TextView
    private lateinit var salir: ImageView
    private lateinit var  btnTraining : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        nombre = findViewById(R.id.textView9)
        salir = findViewById(R.id.btn_salir)
        btnTraining = findViewById(R.id.botonTraining)
        salir.setOnClickListener {
            salir()
        }
        btnTraining.setOnClickListener{
            irTraining()}
        initialise()
    }

    private fun irTraining(){
        val intent = Intent(this, NewTrainingActivity::class.java)
        startActivity(intent)

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