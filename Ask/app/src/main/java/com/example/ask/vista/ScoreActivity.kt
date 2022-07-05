package com.example.ask.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.ask.R

class ScoreActivity : AppCompatActivity() {

    private lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        score = findViewById(R.id.score)
        println(intent.getStringExtra("score"))
        score.text = getIntent().getExtras()?.get("score").toString().plus(" %")
    }
}