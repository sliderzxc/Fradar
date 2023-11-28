package com.sliderzxc.fradar.features.auth.ui.screen

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.sliderzxc.fradar.features.auth.navigation.AuthComponent

@Composable
fun AuthScreen(
    component: AuthComponent
) {
    val activity = LocalContext.current as Activity
    val oneTapClient = Identity.getSignInClient(activity)
    val signInRequest = BeginSignInRequest.builder()
        .setPasswordRequestOptions(
            BeginSignInRequest.PasswordRequestOptions.builder()
                .setSupported(false)
                .build()
        )
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId("webClientId")
                .setFilterByAuthorizedAccounts(false)
                .build()
        )
        .setAutoSelectEnabled(false)
        .build()
    val activityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        try {
            val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
            val idToken = credential.googleIdToken
            if (idToken != null) {
                Log.d("MyLog", "Fradar | AuthScreen | SUCCESS")
            } else {
                Log.d("MyLog", "Fradar | AuthScreen | BAD ID TOKEN")
            }
        } catch (ex: Exception) {
            Log.d("MyLog", "Fradar | AuthScreen | EXCEPTION: ${ex.message}")
        }
    }

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
                    oneTapClient.beginSignIn(signInRequest).addOnCompleteListener { task ->
                        activityLauncher.launch(
                            IntentSenderRequest.Builder(task.result.pendingIntent.intentSender).build()
                        )
                    }
                },
                //enabled = !state.opened
            ) {
                Text(text = "Sign in")
            }
        }
    }
}