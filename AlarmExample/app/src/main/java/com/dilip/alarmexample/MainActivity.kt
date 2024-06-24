package com.dilip.alarmexample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dilip.alarmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var alarmManager: AlarmManager

        val intent = Intent(this, AlarmManagerReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(this, 122, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        binding.Start.setOnClickListener {
            val i = binding.editTextText.text.toString().toInt()

            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (i * 100),
                pendingIntent
            )
            Toast.makeText(this, "Alarm in $i seconds", Toast.LENGTH_SHORT).show()

        }

        binding.end.setOnClickListener {
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarm is cancelled", Toast.LENGTH_SHORT).show()

        }

    }
}