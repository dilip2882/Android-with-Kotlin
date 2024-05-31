package com.dilip.androidlayoutsapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button button; (in Java)
        val button: Button = findViewById(R.id.bottom_button)
        button.setOnClickListener {
            Log.i("LOG","Button Clicked")
        }

    }
}