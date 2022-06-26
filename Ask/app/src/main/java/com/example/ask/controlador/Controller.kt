package com.example.ask.controlador

import com.example.ask.modelo.Subject
import com.example.ask.modelo.SubjectDataCollectionItem

class Controller {

    companion object {
        public fun getSubjects(): List<SubjectDataCollectionItem> {
            var sub: Subject =  Subject()
            return sub.callServiceGetSubjects()

        }


    }
    }
