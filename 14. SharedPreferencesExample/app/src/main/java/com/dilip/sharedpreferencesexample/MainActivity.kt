package com.dilip.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dilip.sharedpreferencesexample.databinding.ActivityMainBinding

// Main Activity class that extends AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Lateinit variable for View Binding to access the views
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the content view to the root of the binding
        setContentView(binding.root)

        // Initialize SharedPreferences with a file name "myPref" in private mode
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        // Editor object to make changes in SharedPreferences
        val editor = sharedPref.edit()

        // Set an OnClickListener on the Save button
        binding.btnSave.setOnClickListener {
            // Get the input text from EditText views and isChecked state from CheckBox
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val isAdult = binding.cbAdult.isChecked

            // Use editor to put values in SharedPreferences and apply changes
            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply() // Apply changes asynchronously
            }
        }

        // Set an OnClickListener on the Load button
        binding.btnLoad.setOnClickListener {
            // Retrieve values from SharedPreferences or set default values if not found
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            // Set retrieved values to corresponding views
            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbAdult.isChecked = isAdult
        }
    }
}
