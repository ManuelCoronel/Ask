package com.example.ask.controlador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ask.R
import com.example.ask.modelo.QuestionDataCollectionItem
import com.example.ask.modelo.Subject
import com.example.ask.modelo.SubjectDataCollectionItem
import com.example.ask.vista.NewTrainingActivity

class SubjectAdapter(private val dataSet: List<SubjectDataCollectionItem>) :

    RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    companion  object {
        var context: Context? = null
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val button: Button
        val id : TextView
        init {
            // Define click listener for the ViewHolder's View.
                button = view.findViewById(R.id.radioButtonTopic)
                id = view.findViewById(R.id.topicId)
                context = view.context
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.subject_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.button.setText(dataSet[position].name)
        viewHolder.button.setOnClickListener {
            println("Tema seleccionado:")
            println(dataSet[position].id)
            Controller.idTopic = dataSet[position].id.toString()
            Controller.getQuestions()
            val intent = Intent(context, NewTrainingActivity::class.java)
            intent.putExtra("checked", 1)
            with(context) {
                this?.startActivity(intent)
            }

        }


    }

        


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}