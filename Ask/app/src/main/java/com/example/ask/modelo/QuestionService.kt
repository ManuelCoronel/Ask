package com.example.ask.modelo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface QuestionService {
    @GET("public/api/listSubjects/")
    fun listSubject(): Call<List<SubjectDataCollectionItem>>

    @GET("private/api/QuestionList/{id}")
    fun listQuestion(@Path("id") id :Int,@Header("Authorization")authHeader : String ): Call<List<QuestionDataCollectionItem>>

}