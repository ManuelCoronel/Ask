package com.example.ask.controlador

import com.example.ask.modelo.Subject
import com.example.ask.modelo.SubjectDataCollectionItem
import java.io.Serializable

class Controller {


    companion object {


       lateinit var subjects : List<SubjectDataCollectionItem>


        public fun getSubjects(){
            var sub: Subject =  Subject()
            subjects = sub.callServiceGetSubjects()
        }
    }
    }
