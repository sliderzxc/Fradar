package com.sliderzxc.fradar.features.auth.ui.store

import com.arkivanov.mvikotlin.core.store.Store

interface AuthStore: Store<AuthStore.Intent, AuthStore.State, Nothing> {

    sealed class Intent {

    }

    data class State(
        val idToken: String? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )
}