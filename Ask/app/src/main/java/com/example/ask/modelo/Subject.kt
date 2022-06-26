package com.example.ask.modelo

import com.example.ask.util.RestEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Subject {
    constructor()

    public fun callServiceGetSubjects(): List<SubjectDataCollectionItem> {
        val questionService: QuestionService = RestEngine.getRestEngine().create(QuestionService::class.java)
        val result: Call<List<SubjectDataCollectionItem>> = questionService.listSubject()
        println("Holaaaaaaaa")
        println(result)
        var lista: List<SubjectDataCollectionItem>? = null
        result.enqueue(object : Callback<List<SubjectDataCollectionItem>> {
            override fun onFailure(call: Call<List<SubjectDataCollectionItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<SubjectDataCollectionItem>>,
                response: Response<List<SubjectDataCollectionItem>>
            ) {
                lista = response.body()!!
                println(lista)
                println(lista!![0].name)

            }
        }
        )
        return lista!!
    }

}