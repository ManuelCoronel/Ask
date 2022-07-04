package com.example.ask.modelo

import com.example.ask.controlador.Controller
import com.example.ask.util.RestEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Question {



    public fun listQuestion(id:Int): List<QuestionDataCollectionItem> {

        val questionService: QuestionService = RestEngine.getRestEngine().create(QuestionService::class.java)
        val result: Call<List<QuestionDataCollectionItem>> = questionService.listQuestion(id)
        println("LA URL ES")

        //questionService.listSubject().request().url.encodedPath = questionService.listSubject().request().url.encodedPath.plus("?token=").plus(4)
        println(questionService.listQuestion(id).request().header("Authorization"))
        var lista: List<QuestionDataCollectionItem> = listOfNotNull()
        result.enqueue(object : Callback<List<QuestionDataCollectionItem>> {
            override fun onFailure(call: Call<List<QuestionDataCollectionItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<QuestionDataCollectionItem>>,
                response: Response<List<QuestionDataCollectionItem>>
            ) {

                println(response)
                lista = response.body()!!
                println(lista)
                Controller.questions= lista
                println("CARGA DE QUESTIONS COMPLETADA")

            }
        }
        )

        return lista
    }

}