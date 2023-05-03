package com.example.common.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class IosDispatcher: DispatcherProvider{
    override val io: CoroutineDispatcher
        get() = Dispatchers.Main
    override val main: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher(): DispatcherProvider = IosDispatcher()