package com.dilip.intentdatapassingexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dilip.intentdatapassingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare a binding variable in the class
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding variable with the layout inflater
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        // Use the root view from the binding to set the content view
        setContentView(mBinding.root)
    }

}
