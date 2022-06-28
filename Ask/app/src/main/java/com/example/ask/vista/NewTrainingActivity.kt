package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.ask.R
import com.example.ask.controlador.Controller.Companion.getSubjects

class NewTrainingActivity : AppCompatActivity() {

    private lateinit var btn: ImageView
    private lateinit var  btnTopic : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_training)

        btn = findViewById(R.id.btnBack)
        btnTopic = findViewById(R.id.topicButton)

        btn.setOnClickListener{
            irTraining()
        }

        btnTopic.setOnClickListener{
            loadSubject()}

    }

    private fun loadSubject() {
        println("Subjects::::")
        println(getSubjects())
        val intent = Intent(this, TopicsActivity::class.java)
        var bundle : Bundle
        bundle.putSerializable("subjects",getSubjects())
        intent.putExtra("subjects",getSubjects())
        startActivity(intent)

    }

    private fun irTraining(){
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)

    }
}