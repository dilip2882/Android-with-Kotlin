package com.dilip.androidlayoutsapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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