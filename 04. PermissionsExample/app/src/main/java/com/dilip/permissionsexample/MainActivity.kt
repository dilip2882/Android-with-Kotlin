package com.dilip.permissionsexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    // Called when the activity is starting.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the user interface layout for this Activity.
        setContentView(R.layout.activity_main)

        // Find the button by its ID and store a reference to it.
        val btnRequestPermissions = findViewById<Button>(R.id.btnRequestPermissions)

        // Set an OnClickListener on the button to handle click events.
        btnRequestPermissions.setOnClickListener {
            // Call the function to request permissions when the button is clicked.
            requestPermissions()
        }
    }

    // Check if WRITE_EXTERNAL_STORAGE permission is granted.
    private fun writeExternalStorage() =
        ActivityCompat.checkSelfPermission(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    // Check if INTERNET permission is granted.
    private fun permissionInternet() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) ==
                PackageManager.PERMISSION_GRANTED

    // Check if CAMERA permission is granted.
    private fun permissionCamera() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED

    // Check if READ_EXTERNAL_STORAGE permission is granted.
    private fun permissionExternal() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED

    // Request permissions that have not been granted yet.
    private fun requestPermissions() {
        val permissionToRequest = mutableListOf<String>()

        // Add permissions to the list if they are not already granted.
        if (!writeExternalStorage()) {
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!permissionInternet()) {
            permissionToRequest.add(Manifest.permission.INTERNET)
        }
        if (!permissionCamera()) {
            permissionToRequest.add(Manifest.permission.CAMERA)
        }
        if (!permissionExternal()) {
            permissionToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        // Request permissions if the list is not empty
        if(permissionToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(
                this,
                permissionToRequest.toTypedArray(),
                0
            )
        }
    }

    // Callback for the result from requesting permissions.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Check if this callback corresponds to our request code.
        if(requestCode == 0 && grantResults.isNotEmpty()) {
            for(i in grantResults.indices) {
                // Log which permissions have been granted.
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest","${permissions[i]} granted")
                }
            }
        }
    }
}
