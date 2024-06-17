package com.dilip.checkboxandradiobuttonapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    // This function is called when the activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the layout defined in 'activity_main.xml'.
        setContentView(R.layout.activity_main)

        // Find the button by its ID and store a reference to it.
        val btnOrder  = findViewById<Button>(R.id.btnOrder)
        // Find the RadioGroup by its ID.
        val rgVeg = findViewById<RadioGroup>(R.id.rgVeg)
        // Find the RadioButtons by their IDs.
        val rgOnion = findViewById<RadioButton>(R.id.rgOnion)
        val rgCapsicum = findViewById<RadioButton>(R.id.rgCapsicum)
        val rgTomato = findViewById<RadioButton>(R.id.rgTomato)
        // Find the CheckBoxes by their IDs.
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        val cbPotato = findViewById<CheckBox>(R.id.cbPotato)
        val cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        // Find the TextView by its ID.
        val tvOrder = findViewById<TextView>(R.id.tvOrder)

        // Set an OnClickListener on the button to handle click events.
        btnOrder.setOnClickListener {
            // Get the ID of the selected RadioButton in the RadioGroup.
            val checkVegRadioButtonId = rgVeg.checkedRadioButtonId
            // Find the selected RadioButton by its ID.
            val veg = findViewById<RadioButton>(checkVegRadioButtonId)
            // Check if each CheckBox is checked and store the result as a boolean.
            val cheese = cbCheese.isChecked
            val potato = cbPotato.isChecked
            val salad = cbSalad.isChecked

            // Build a string that describes the user's order based on their selections.
            val orderString = "You ordered a burger with:\n " +
                    "${veg.text}" +  // Add the selected vegetable to the order string.
                    (if(cheese) "\nCheese" else "") +  // Add 'Cheese' if the CheckBox is checked.
                    (if(potato) "\nPotato" else "") +  // Add 'Potato' if the CheckBox is checked.
                    (if(salad) "\nSalad" else "")  // Add 'Salad' if the CheckBox is checked.
            // Set the text of the TextView to display the order summary.
            tvOrder.text = orderString
        }
    }
}
