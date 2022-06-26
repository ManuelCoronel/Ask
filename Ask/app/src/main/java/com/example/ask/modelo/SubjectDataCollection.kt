package com.example.ask.modelo

class SubjectDataCollection : ArrayList<SubjectDataCollectionItem>()

data class SubjectDataCollectionItem(
    val id: Int,
    val name: String
)