package com.example.androidmeditationuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.androidmeditationuiapp.ui.theme.AndroidMeditationUIAppTheme
import com.example.androidmeditationuiapp.ui.theme.Pink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMeditationUIAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    window.statusBarColor = Pink.toArgb()
                    window.navigationBarColor = Color.Black.toArgb()
//                    DashboardPage(innerPadding)
                    MoodPage(innerPadding)
                }
            }
        }
    }
}

