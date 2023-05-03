package com.example.common.util

import kotlinx.coroutines.CoroutineDispatcher

internal  interface DispatcherProvider{
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

internal expect fun provideDispatcher(): DispatcherProvider