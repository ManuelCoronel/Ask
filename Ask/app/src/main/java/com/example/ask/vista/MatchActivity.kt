package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.children
import com.example.ask.R
import com.example.ask.controlador.Controller
import com.squareup.okhttp.internal.Util.concat
import org.w3c.dom.Text

class MatchActivity : AppCompatActivity() {

    lateinit var  question : TextView
    lateinit var  answerA : RadioButton
    lateinit var  answerB : RadioButton
    lateinit var  answerC : RadioButton
    lateinit var  answerD : RadioButton
    lateinit var  radioG : RadioGroup
     var id : Int = 0
    var correctas : Int = 0
    var maxQuestion:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        radioG = findViewById(R.id.radioQuestion)
        question = findViewById(R.id.question)
        answerA = findViewById(R.id.answerA)
        answerB = findViewById(R.id.answerB)
        answerC = findViewById(R.id.answerC)
        answerD = findViewById(R.id.answerD)
        var iden = id +1
        maxQuestion = getIntent().getExtras()?.get("numQuestions").toString().toInt()
        question.text = (iden).toString().plus(". ").plus(Controller.questions.get(id).question)
        answerA.text = Controller.questions.get(id).answerA
        answerB.text = Controller.questions.get(id).answerB
        answerC.text = Controller.questions.get(id).answerC
        answerD.text = Controller.questions.get(id).answerD

        radioG.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener {

                group, checkedId ->
            when(checkedId){
                R.id.answerA -> validateA(group)
                R.id.answerB -> validateB(group)
                R.id.answerC -> validateC(group)
                R.id.answerD -> validateD(group)
            }

            loadQuestion()
        })

    }
    fun validateA(view: View){
        if(answerA.isChecked && Controller.questions.get(id).answerCorrect == "A"){
            correctas++ }
        resetRadioButton(radioG)
    }

    fun validateB(view: View){
        if(answerB.isChecked && Controller.questions.get(id).answerCorrect == "B"){
            correctas++ }
        resetRadioButton(radioG)
    }

    fun validateC(view: View){
        if(answerC.isChecked && Controller.questions.get(id).answerCorrect == "C"){
            correctas++ }
        resetRadioButton(radioG)
    }

    fun validateD(view: View){
        if(answerD.isChecked && Controller.questions.get(id).answerCorrect == "D"){
            correctas++ }
        resetRadioButton(radioG)
    }

    fun resetRadioButton(view: View){

        radioG.clearCheck()
        id++
    }

    fun loadQuestion() {
        if (maxQuestion == id){
            val intent = Intent(this, ScoreActivity::class.java)
            println(correctas)
            intent.putExtra("score", (correctas*100)/maxQuestion)
            startActivity(intent)
        }
        else{
            var iden = id +1
            question.text = (iden).toString().plus(". ").plus(Controller.questions.get(id).question)
            answerA.text = Controller.questions.get(id).answerA
            answerB.text = Controller.questions.get(id).answerB
            answerC.text = Controller.questions.get(id).answerC
            answerD.text = Controller.questions.get(id).answerD

        }

    }
}

