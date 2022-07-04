package com.example.ask.controlador

import com.example.ask.modelo.QuestionDataCollectionItem
import com.example.ask.modelo.SubjectDataCollectionItem
import com.example.ask.modelo.Subject
import com.example.ask.modelo.Question
import java.io.Serializable
import kotlin.properties.Delegates

class Controller {


    companion object {


       lateinit var subjects : List<SubjectDataCollectionItem>
       lateinit var  questions : List<QuestionDataCollectionItem>
        lateinit var token : String
       lateinit var idTopic:String

        public fun getSubjects(){
            var sub: Subject =  Subject()
            subjects = sub.callServiceGetSubjects()
        }

        public  fun getQuestions(){
            var question = Question()
            questions = question.listQuestion(Integer.parseInt(idTopic),token)
        }
    }
    }
