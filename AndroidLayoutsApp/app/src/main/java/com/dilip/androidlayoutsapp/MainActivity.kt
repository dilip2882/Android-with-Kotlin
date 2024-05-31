package com.dilip.androidlayoutsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        /*// EditText inputEditText; (in Java)
        val inputEditText: EditText = findViewById(R.id.input_EditText)
        // Button button; (in Java)
        val button: Button = findViewById(R.id.bottom_button)
        button.setOnClickListener {
            val input = inputEditText.text.toString()
//            Toast.makeText(it.context, input, Toast.LENGTH_SHORT).show()
            if (input.isEmpty()) {
                return@setOnClickListener
            }
            Snackbar.make(it, input, Snackbar.LENGTH_SHORT).show()

        }*/


    }
}