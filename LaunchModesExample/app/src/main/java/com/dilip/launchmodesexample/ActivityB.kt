package com.dilip.launchmodesexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val buttonC = findViewById<Button>(R.id.button_start_activity_c)
        buttonC.setOnClickListener {
            Toast.makeText(this, "SingleTask Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityC::class.java))
        }
    }
}