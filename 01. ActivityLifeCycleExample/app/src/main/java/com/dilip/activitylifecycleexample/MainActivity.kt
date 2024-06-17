package com.dilip.activitylifecycleexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dilip.activitylifecycleexample.ui.theme.ActivityLifeCycleExampleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("LogMessage", "On Create Message ")
        Toast.makeText(applicationContext,"OnCreate",Toast.LENGTH_SHORT).show()
        setContent {
            ActivityLifeCycleExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Row( // Existing Row for horizontal centering
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxWidth()
                        ) {
                            Text(text = "This is First Activity")
                        }
                        Row {
                            Button(onClick = { startActivity(Intent(this@MainActivity, MainActivity2::class.java)) },
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .fillMaxWidth()
                                    .padding(horizontal = 60.dp)
                            ) {
                                Text(text = "Go to Second Activity")
                            }
                        }
                    }

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LogMessage", "On Start Message ")
        Toast.makeText(applicationContext,"OnStart",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("LogMessage", "On Resume Message ")
        Toast.makeText(applicationContext,"OnResume",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("LogMessage", "On Pause Message ")
        Toast.makeText(applicationContext,"OnPause",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("LogMessage", "On Stop Message ")
        Toast.makeText(applicationContext,"OnStop",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LogMessage", "On Destroy Message ")
        Toast.makeText(applicationContext,"OnDestroy",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LogMessage", "On Restart Message ")
        Toast.makeText(applicationContext,"OnRestart",Toast.LENGTH_SHORT).show()
    }
}
