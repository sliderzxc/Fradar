package com.sliderzxc.fradar.features.auth.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.sliderzxc.fradar.onetap.OneTapSignInWithGoogle
import com.sliderzxc.fradar.onetap.rememberOneTapSignInState

@Composable
fun AuthScreen() {
    val state = rememberOneTapSignInState()

    OneTapSignInWithGoogle(
        state = state,
        clientId = "webClientId",
        onTokenIdReceived = {
            Log.d("MainActivity", "token: $it")
        },
        onDialogDismissed = {
            Log.d("MainActivity", "Dismiss: $it")
        }
    )

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
                onClick = { state.open() },
                enabled = !state.opened
            ) {
                Text(text = "Sign in")
            }
        }
    }
}