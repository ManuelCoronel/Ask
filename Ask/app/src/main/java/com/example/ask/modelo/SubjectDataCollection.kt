package com.example.ask.modelo

class SubjectDataCollection  : ArrayList<QuestionDataCollectionItem>()

data class SubjectDataCollectionItem (
    val id: Int,
    val name: String
)

