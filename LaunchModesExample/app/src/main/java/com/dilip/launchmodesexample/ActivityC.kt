package com.dilip.launchmodesexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val buttonD = findViewById<Button>(R.id.button_start_activity_d)
        buttonD.setOnClickListener {
            Toast.makeText(this, "SingleInstance Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityD::class.java))
        }
    }
}