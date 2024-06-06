package com.dilip.businesscardapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dilip.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .background(color = Color(0xFF2196F3))
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(bottom = 24.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 50.sp,
            color = Color.White, // Text color for name
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.about),
            fontSize = 25.sp,
            color = Color.LightGray,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Divider(color = Color.Gray)

        ContactRow(
            text = stringResource(R.string.phone_number),
            icon = Icons.Rounded.Phone,
            action = { launchWebUrl("https://github.com/dilip2882") }
        )
        Divider(color = Color.Gray)
        ContactRow(
            text = stringResource(R.string.twitter),
            icon = Icons.Rounded.Share,
            action = { launchWebUrl("https://x.com/dilip2882") },
//            textColor = Color.Blue
        )

        Divider(color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.email),
            icon = Icons.Rounded.Email,
            action = { launchWebUrl("https://github.com/dilip2882") }
        )
        Divider(color = Color(0xFF4F6C79))
        ContactRow(
            text = "GitHub",
            icon = Icons.Rounded.Notifications,
            action = { launchWebUrl("https://github.com/dilip2882") }
        )
        Divider(color = Color(0xFF4F6C79))
        ContactRow(
            text = "LinkedIn",
            icon = Icons.Rounded.Star,
            action = { launchWebUrl("https://www.linkedin.com/in/dilip2882") }
        )
    }
}

@Composable
fun ContactRow(
    text: String,
    icon: ImageVector,
    action: @Composable () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)

    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun launchWebUrl(url: String) {
    // Handle opening URL in a web browser based on platform
    val context = LocalContext.current  // For Android
    var opened by remember { mutableStateOf(false) }  // For Desktop (optional)
    // Check if context is available (Android)
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        /*// Context is null, assuming Desktop
        val desktop = Desktop.getDesktop()
        if (desktop.isSupported(Desktop.Action.BROWSE)) {
            desktop.browse(URI(url))
            opened = true
        } else {
            // Handle case where Desktop doesn't support browsing
        }*/
    }
    if (opened) {  // Optional: Show a visual cue after opening (Desktop)
        Text("Opened URL in browser.")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF073042)
    ) {
        BusinessCardAppTheme {
            BusinessCard()
        }
    }
}
