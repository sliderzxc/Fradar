package com.sliderzxc.fradar.features.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sliderzxc.fradar.navigation.root.RootComponent
import com.sliderzxc.fradar.navigation.root.RootContent
import com.sliderzxc.fradar.themes.FradarTheme

@Composable
fun ContentView(component: RootComponent) {
    FradarTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RootContent(component)
        }
    }
}