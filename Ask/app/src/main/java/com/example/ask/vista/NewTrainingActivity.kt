package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.*
import com.example.ask.R
import com.example.ask.controlador.Controller
import com.example.ask.controlador.Controller.Companion.getSubjects


class NewTrainingActivity : AppCompatActivity() {

    private lateinit var btn: ImageView
    private lateinit var checked: ImageView
    private lateinit var  btnTopic : Button
    private  lateinit var btnCreate : Button
    private lateinit var numQuestion: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_training)

        btn = findViewById(R.id.btnBack)
        btnTopic = findViewById(R.id.topicButton)
        checked = findViewById(R.id.completados)
        btnCreate = findViewById(R.id.createTraining)
        numQuestion = findViewById(R.id.numberQuestions)

        btn.setOnClickListener{
            irTraining()
        }
        btnCreate.setOnClickListener(){
            irCreateTraining()
        }
        btnTopic.setOnClickListener{
            irTopics()}
        var completado = getIntent().getExtras()

        numQuestion.setOnClickListener(){
            println("EL SIZE ES "+Controller.questions.size)

        }
        if (completado != null) {

            if(completado.getInt("checked")==1){
                checked.visibility = View.VISIBLE
            }



        }

    }
   private fun irCreateTraining(){

       if (numQuestion.text.toString().toInt()>Controller.questions.size){
           numQuestion.filters +=InputFilter.LengthFilter(Controller.questions.size)
       Toast.makeText(this, "No puedes crear una prueba con mas preguntas que las que hay", Toast.LENGTH_LONG).show()


       }else{
        val intent = Intent(this, MatchActivity::class.java)

       intent.putExtra("numQuestions",numQuestion.text.toString())
        startActivity(intent)}
    }

    private fun irTopics() {
        val intent = Intent(this, TopicsActivity::class.java)
        startActivity(intent)

    }

    private fun irTraining(){
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)

    }
}