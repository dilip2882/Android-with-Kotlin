package com.dilip.recyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dilip.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = mutableListOf(
            Todo("Follow AndroidDevs", false),
            Todo("Playing Game", false),
            Todo("Watching Movie", false),
            Todo("Eat some curry", false),
            Todo("Learn about recyclerview", true)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}