package com.sliderzxc.fradar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sliderzxc.fradar.features.auth.ui.screen.AuthScreen
import com.sliderzxc.fradar.themes.FradarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FradarTheme {
                AuthScreen()
            }
        }
    }
}