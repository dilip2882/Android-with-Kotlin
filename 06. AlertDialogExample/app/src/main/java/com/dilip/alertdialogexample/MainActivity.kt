package com.dilip.alertdialogexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dilip.alertdialogexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Lateinit variable for View Binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create an AlertDialog for adding a contact
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact") // Set the title of the dialog
            .setMessage("Do you want to add Mr. Dharmendra to your contact list?") // Set the message to display
            .setIcon(R.drawable.ic_launcher_foreground) // Set the icon of the dialog
            .setPositiveButton("Yes") { _, _ ->
                // Set the action for 'Yes' button
                Toast.makeText(this, "You added Mr. Dharmendra to your contact list.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                // Set the action for 'No' button
                Toast.makeText(this, "You didn't add Mr. Dharmendra to your contact list.", Toast.LENGTH_SHORT).show()
            }.create() // Create the AlertDialog

        // Set an OnClickListener on the button to show the addContactDialog
        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }


        // Options for single choice dialog
        val options = arrayOf("First Item", "Second Item", "Third Item")

        // Create a single choice AlertDialog
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options") // Set the title of the dialog
            .setSingleChoiceItems(options, 0) { _, i ->
                // Set single choice items and handle item click
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                // Set the action for 'Accept' button
                Toast.makeText(this, "You accepted single choice dialog.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Declined") { _, _ ->
                // Set the action for 'Declined' button
                Toast.makeText(this, "You declined single choice dialog", Toast.LENGTH_SHORT).show()
            }.create() // Create the AlertDialog

        // Set an OnClickListener on the button to show the singleChoiceDialog
        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }


        // Create a multi-choice AlertDialog
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options") // Set the title of the dialog
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                // Set multi-choice items and handle item check changes
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                // Set the action for 'Accept' button
                Toast.makeText(this, "You accepted multi choice dialog.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Declined") { _, _ ->
                // Set the action for 'Declined' button
                Toast.makeText(this, "You declined multi choice dialog", Toast.LENGTH_SHORT).show()
            }.create() // Create the AlertDialog

        // Set an OnClickListener on the button to show the multiChoiceDialog
        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}
