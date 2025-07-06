package com.example.meditationui_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.meditationui_jetpackcompose.ui.theme.MeditationUI_JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeditationUI_JetPackComposeTheme {
                HomeScreen()
            }
        }
    }
}

