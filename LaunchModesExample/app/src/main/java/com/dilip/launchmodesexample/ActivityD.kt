package com.dilip.launchmodesexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityD : AppCompatActivity() {
    class ActivityD : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_d)

            val buttonE = findViewById<Button>(R.id.button_start_activity_e)
            buttonE.setOnClickListener {
                Toast.makeText(this, "New Task and Clear Top", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityE::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        }
    }
}