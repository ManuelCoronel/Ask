package com.example.ask.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ask.R
import com.example.ask.controlador.Controller
import com.example.ask.controlador.SubjectAdapter
import com.example.ask.controlador.Controller.Companion.getSubjects
import com.example.ask.controlador.Controller.Companion.subjects
import com.example.ask.modelo.SubjectDataCollectionItem


class TopicsActivity : AppCompatActivity() {

    lateinit var adapter: SubjectAdapter
     lateinit var  recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)

       recyclerView = findViewById(R.id.recyclerview)
        var linearLayout = LinearLayoutManager(this)
        recyclerView.layoutManager =linearLayout

        val dataSet: List<SubjectDataCollectionItem>? = subjects

        this.recyclerView.adapter = dataSet?.let { SubjectAdapter(it) }



    }
}