package com.example.ask.modelo

import android.widget.Toast
import com.example.ask.controlador.Controller
import com.example.ask.util.RestEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.ask.controlador.Controller.Companion.subjects

class Subject {
    constructor()


    public fun callServiceGetSubjects(): List<SubjectDataCollectionItem> {
        val questionService: QuestionService = RestEngine.getRestEngine().create(QuestionService::class.java)
        val result: Call<List<SubjectDataCollectionItem>> = questionService.listSubject()

        var lista: List<SubjectDataCollectionItem> = listOfNotNull()
        result.enqueue(object : Callback<List<SubjectDataCollectionItem>> {
            override fun onFailure(call: Call<List<SubjectDataCollectionItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<SubjectDataCollectionItem>>,
                response: Response<List<SubjectDataCollectionItem>>
            ) {
                lista = response.body()!!
                subjects = lista
                println("CARGA DE SUBJECTS COMPLETADA")

            }
        }
        )

        return lista
    }

}