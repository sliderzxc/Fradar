package com.sliderzxc.fradar.navigation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.sliderzxc.fradar.features.auth.ui.AuthComponent
import com.sliderzxc.fradar.navigation.configuration.FradarNavConfiguration

class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val auth: (ComponentContext, (AuthComponent.Output) -> Unit) -> AuthComponent,
) : FradarNavigationRoot, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        auth = { childContext, output ->
            AuthComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                output = output
            )
        }
    )

    private val navigation = StackNavigation<FradarNavConfiguration>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = FradarNavConfiguration.Auth,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: FradarNavConfiguration,
        componentContext: ComponentContext
    ): FradarNavigationRoot.Child {
        return when (configuration) {
            FradarNavConfiguration.Auth -> FradarNavigationRoot.Child.Auth(
                auth(componentContext, ::onSplashOutput)
            )
        }
    }

    override val childStack: Value<ChildStack<*, FradarNavigationRoot.Child>> = stack

    private fun onSplashOutput(output: AuthComponent.Output) {
        when(output) {
            AuthComponent.Output.NavigateToMap -> TODO()
            AuthComponent.Output.TestOutput -> TODO()
        }
    }
}