package com.dilip.checkboxandradiobuttonapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrder  = findViewById<Button>(R.id.btnOrder)
        val rgVeg = findViewById<RadioGroup>(R.id.rgVeg)
        val rgOnion = findViewById<RadioButton>(R.id.rgOnion)
        val rgCapsicum = findViewById<RadioButton>(R.id.rgCapsicum)
        val rgTomato = findViewById<RadioButton>(R.id.rgTomato)
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        val cbPotato = findViewById<CheckBox>(R.id.cbPotato)
        val cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        val tvOrder = findViewById<TextView>(R.id.tvOrder)

        btnOrder.setOnClickListener {
            val checkVegRadioButtonId = rgVeg.checkedRadioButtonId
            val veg = findViewById<RadioButton>(checkVegRadioButtonId)
            val cheese = cbCheese.isChecked
            val potato = cbPotato.isChecked
            val salad = cbSalad.isChecked

            val orderString = "You ordered a burger with:\n " +
                    "${veg.text}" +
                    (if(cheese) "\nCheese" else "") +
                    (if(potato) "\nPotato" else "") +
                    (if(salad) "\nSalad" else "")
            tvOrder.text = orderString
        }

    }
}