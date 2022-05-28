package com.example.ask

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    lateinit var  btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn = findViewById(R.id.btn_sign_in)
        btn.setOnClickListener(irRegistro())

    }

    fun irRegistro(): View.OnClickListener? {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        return null
    }
}