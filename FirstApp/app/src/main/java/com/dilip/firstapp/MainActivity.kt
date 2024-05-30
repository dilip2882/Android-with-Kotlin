package com.dilip.firstapp

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dilip.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column(
                       modifier = Modifier.background(Color.Cyan)
                   ) {
                       Text(text = "Login",
                           fontSize = 24.sp,
                           fontWeight = FontWeight.ExtraBold,
                           modifier = Modifier
                               .align(Alignment.CenterHorizontally)
                               .padding(vertical = 120.dp)
                       )
                       TextField(value = "", onValueChange = {},
                           modifier = Modifier.align(Alignment.CenterHorizontally),
                           placeholder = {
                               Text(text = "Email")
                           }
                           )
                       Spacer(modifier = Modifier.height(10.dp))
                       TextField(value = "", onValueChange = {},
                           modifier = Modifier.align(Alignment.CenterHorizontally),
                           placeholder = {
                               Text(text = "Password")
                           }
                       )
                       Spacer(modifier = Modifier.height(20.dp))
                       Button(onClick = { /*TODO*/ },
                           modifier = Modifier
                               .align(Alignment.CenterHorizontally)
                               .fillMaxWidth()
                               .padding(horizontal = 60.dp)
                       ) {
                           Text(text = "Login")
                       }
                    }
                }
            }
        }
    }
}


