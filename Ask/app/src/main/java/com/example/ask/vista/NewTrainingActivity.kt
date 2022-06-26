package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ask.R

class NewTrainingActivity : AppCompatActivity() {

    private lateinit var btn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_training)

        btn = findViewById(R.id.btnBack)

        btn.setOnClickListener{
            irTraining()
        }

    }

    private fun irTraining(){
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)

    }
}