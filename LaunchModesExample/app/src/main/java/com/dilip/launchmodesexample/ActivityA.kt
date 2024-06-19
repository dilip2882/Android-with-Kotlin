package com.dilip.launchmodesexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val buttonB = findViewById<Button>(R.id.button_start_activity_b)
        buttonB.setOnClickListener {
            Toast.makeText(this, "SingleTop Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}