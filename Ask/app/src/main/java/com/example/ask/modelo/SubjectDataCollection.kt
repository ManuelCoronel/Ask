package com.example.ask.modelo

import java.io.Serializable

class SubjectDataCollection  : ArrayList<SubjectDataCollectionItem>()

data class SubjectDataCollectionItem (
    val id: Int,
    val name: String
)

