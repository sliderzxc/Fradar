package com.sliderzxc.fradar.features.auth.ui

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.sliderzxc.fradar.BuildConfig
import com.sliderzxc.fradar.features.auth.ui.components.AuthContent

@Composable
fun AuthScreen(
    component: AuthComponent
) {
    val state by component.state.collectAsState()

    AuthContent(
        state = state,
        onEvent = component::onEvent,
        onOutput = component::onOutput
    )



    val activity = LocalContext.current as Activity
    val oneTapClient = Identity.getSignInClient(activity)

    val signInRequest = BeginSignInRequest.builder().setPasswordRequestOptions(
        BeginSignInRequest.PasswordRequestOptions.builder().setSupported(false).build()
    ).setGoogleIdTokenRequestOptions(
        BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
            .setSupported(true)
            .setServerClientId(BuildConfig.WEB_CLIENT_ID)
            .setFilterByAuthorizedAccounts(false)
            .build()
    ).setAutoSelectEnabled(false).build()

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
}