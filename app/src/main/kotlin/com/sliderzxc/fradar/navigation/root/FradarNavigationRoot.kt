package com.sliderzxc.fradar.navigation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.sliderzxc.fradar.features.auth.navigation.AuthComponent

interface FradarNavigationRoot {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Auth(val component: AuthComponent) : Child()
    }
}