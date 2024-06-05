package com.dilip.androidlayoutsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView: TextView = findViewById(R.id.title_tv)
        val learnMoreButton: Button = findViewById(R.id.learn_more_btn)
        learnMoreButton.setOnClickListener {

            val title = titleTextView.text
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        val dataForAdapter = ArrayList<String>()
        repeat(150) { index ->
            dataForAdapter.add("Element $index")
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val simpleAdapter = SimpleAdapter()
        simpleAdapter.setData(dataForAdapter, "IPL")
//        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))


        recyclerView.adapter = simpleAdapter
        simpleAdapter.notifyDataSetChanged()


    }
}