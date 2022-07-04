package com.example.ask.modelo


class QuestionDataCollection : ArrayList<QuestionDataCollectionItem>()

data class QuestionDataCollectionItem(
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerCorrect: String,
    val answerD: String,
    val id: Int,
    val question: String,
    val subject: SubjectDataCollectionItem
)

