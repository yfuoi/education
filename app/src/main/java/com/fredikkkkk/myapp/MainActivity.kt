package com.fredikkkkk.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import android.net.Uri
import com.fredikkkkk.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        onButtonClick = {
                            val intent = Intent(this, MainActivity2::class.java).apply{
                                putExtra("USER_NAME","Fredikkkkk")
                            }
                            startActivity(intent)
                        },
                        onCall = {
                            val phoneNumber = "tel:+79854237659"
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                            startActivity(intent)
                        },
                        shareText = {
                            val texttosend = "Hi! Now im know everything about intent"
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, texttosend)
                            }
                            startActivity(Intent.createChooser(intent, "Share by..."))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(onButtonClick: () -> Unit, onCall: () -> Unit, shareText: () -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("Welcome to the main menu!")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onButtonClick) {
            Text("Open a second Activity")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onCall)
        {
            Text("Click to call")
        }
        Button(onClick = shareText) {
            Text("Click to share text")
        }
    }
}