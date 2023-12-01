package com.sliderzxc.fradar.features.auth.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sliderzxc.fradar.features.auth.ui.AuthComponent
import com.sliderzxc.fradar.features.auth.ui.store.AuthStore

@Composable
fun AuthContent(
    state: AuthStore.State,
    onEvent: (AuthStore.Intent) -> Unit,
    onOutput: (AuthComponent.Output) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(2f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
//                    oneTapClient.beginSignIn(signInRequest).addOnCompleteListener { task ->
//                        activityLauncher.launch(
//                            IntentSenderRequest.Builder(task.result.pendingIntent.intentSender).build()
//                        )
//                    }
                },
            ) {
                Text(text = "Sign in")
            }
        }
    }
}