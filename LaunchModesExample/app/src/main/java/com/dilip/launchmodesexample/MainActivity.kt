package com.dilip.launchmodesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStandard = findViewById<Button>(R.id.button_standard_launch)
        buttonStandard.setOnClickListener {
            Toast.makeText(this, "Standard Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityA::class.java))
        }

        val buttonSingleTop = findViewById<Button>(R.id.button_single_top_launch)
        buttonSingleTop.setOnClickListener {
            Toast.makeText(this, "SingleTop Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityA::class.java))
        }

        val buttonSingleTask = findViewById<Button>(R.id.button_single_task_launch)
        buttonSingleTask.setOnClickListener {
            Toast.makeText(this, "SingleTask Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityB::class.java))
        }

        val buttonSingleInstance = findViewById<Button>(R.id.button_single_instance_launch)
        buttonSingleInstance.setOnClickListener {
            Toast.makeText(this, "SingleInstance Launch", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityC::class.java))
        }

        val buttonNewTaskClearTop = findViewById<Button>(R.id.button_new_task_clear_top_launch)
        buttonNewTaskClearTop.setOnClickListener {
            Toast.makeText(this, "New Task and Clear Top", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityD::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
