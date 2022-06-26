package com.example.ask.modelo

import retrofit2.Call
import retrofit2.http.GET

interface QuestionService {
    @GET("public/api/listSubjects")
    fun listSubject(): Call<List<SubjectDataCollectionItem>>

}