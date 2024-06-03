package com.dilip.androidlayoutsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titleFromIntent = intent.getStringExtra("title") ?: "No title"
        val textView: TextView = findViewById(R.id.textView)
        textView.text = titleFromIntent

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