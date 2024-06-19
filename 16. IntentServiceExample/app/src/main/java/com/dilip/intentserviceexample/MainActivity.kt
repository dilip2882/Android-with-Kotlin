package com.dilip.intentserviceexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dilip.intentserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartSerivce.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvServiceInfo.text = "Service running"

            }
        }

        binding.btnStopService.setOnClickListener {
            MyIntentService.stopService()
            binding.tvServiceInfo.text = "Service Stopped"
        }

    }
}