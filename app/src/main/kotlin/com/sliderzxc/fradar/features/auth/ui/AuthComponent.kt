package com.sliderzxc.fradar.features.auth.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.sliderzxc.fradar.features.auth.ui.store.AuthStore
import com.sliderzxc.fradar.features.auth.ui.store.AuthStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

class AuthComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: (Output) -> Unit
): ComponentContext by componentContext {

    private val authStore = instanceKeeper.getStore {
        AuthStoreFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val state: StateFlow<AuthStore.State> = authStore.stateFlow

    fun onEvent(event: AuthStore.Intent) {
        authStore.accept(event)
    }

    fun onOutput(output: Output) {
        output(output)
    }

    sealed class Output {
        data object NavigateToMap : Output()
    }
}