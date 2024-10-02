package com.example.todolistapp

import android.app.Application
import com.example.todolistapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ApplicationActivity : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationActivity)
            modules(appModule)
        }
    }
}