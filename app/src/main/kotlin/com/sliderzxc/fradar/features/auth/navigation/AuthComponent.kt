package com.sliderzxc.fradar.features.auth.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class AuthComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: (Output) -> Unit
): ComponentContext by componentContext {

//    private val mainStore =
//        instanceKeeper.getStore {
//            SplashStore(
//                storeFactory = storeFactory,
//            ).create()
//        }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    val state: StateFlow<MainStore.State> = mainStore.stateFlow

    sealed class Output {
        data object TestOutput : Output()
    }
}