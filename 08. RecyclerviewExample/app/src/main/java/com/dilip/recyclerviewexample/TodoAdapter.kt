package com.dilip.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class for the RecyclerView to handle Todo items
class TodoAdapter(
    var todos: List<Todo> // List of Todo items
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() { // Inherit from RecyclerView.Adapter

    // ViewHolder class that holds the view for each item in the list
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // Called when RecyclerView needs a new ViewHolder of the given type to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // Inflate the custom layout (item_todo.xml) for each item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view) // Return a new ViewHolder instance
    }

    // Called by RecyclerView to display the data at the specified position
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // Get references to the TextView and CheckBox in our item layout
        val tvTitle = holder.itemView.findViewById<TextView>(R.id.tvTitle)
        val cbDone = holder.itemView.findViewById<CheckBox>(R.id.cbDone)

        holder.itemView.apply {
            tvTitle.text = todos[position].title // Set the title text from our Todo item
            cbDone.isChecked = todos[position].isChecked // Set the checked state from our Todo item
        }
    }

    // Returns the total number of items in the data set held by the adapter
    override fun getItemCount(): Int {
        return todos.size // Return the size of the 'todos' list
    }
}
