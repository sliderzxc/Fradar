package com.sliderzxc.fradar.features.auth.ui.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AuthStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): AuthStore {
        return object : AuthStore, Store<AuthStore.Intent, AuthStore.State, Nothing> by storeFactory.create(
            name = "AuthStore",
            initialState = AuthStore.State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}
    }

    private sealed class Msg {
        data object ProgressAuth : Msg()
        data class SuccessAuth(val idToken: String): Msg()
        data class FailureAuth(val error: String): Msg()
    }

    private inner class ExecutorImpl : CoroutineExecutor<AuthStore.Intent, Unit, AuthStore.State, Msg, Nothing>() {
        override fun executeAction(action: Unit, getState: () -> AuthStore.State) {
            getFavoritePokemonList()
        }

        override fun executeIntent(intent: AuthStore.Intent, getState: () -> AuthStore.State) {

        }

        private var authJob: Job? = null
        private fun getFavoritePokemonList() {
            if (authJob?.isActive == true) return

            authJob = scope.launch {
                dispatch(Msg.ProgressAuth)
            }
        }
    }

    private object ReducerImpl: Reducer<AuthStore.State, Msg> {
        override fun AuthStore.State.reduce(msg: Msg): AuthStore.State {
            return when (msg) {
                is Msg.SuccessAuth -> copy(idToken = idToken)
                is Msg.FailureAuth -> copy(error = error)
                is Msg.ProgressAuth -> copy(isLoading = true)
            }
        }
    }
}