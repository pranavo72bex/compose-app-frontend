package com.example.socialmedia.android

import android.app.Application
import com.example.di.getShareModules
import com.example.socialmedia.android.di.appModule
import org.koin.core.context.startKoin

class SocialApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getShareModules())
        }
    }
}