package com.sliderzxc.fradar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.sliderzxc.fradar.features.common.ContentView
import com.sliderzxc.fradar.navigation.root.RootComponent
import com.sliderzxc.fradar.themes.FradarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FradarTheme {
                val rootComponent = RootComponent(
                    componentContext = defaultComponentContext(),
                    storeFactory = DefaultStoreFactory(),
                )
                setContent {
                    ContentView(component = rootComponent)
                }
            }
        }
    }
}