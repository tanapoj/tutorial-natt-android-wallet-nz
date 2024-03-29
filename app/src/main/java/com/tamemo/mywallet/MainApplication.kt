package com.tamemo.mywallet

import android.app.Application
import com.tamemo.mywallet.di.getMainModule
import com.tamemo.mywallet.di.getModules
import com.tamemo.mywallet.di.getViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(getModules(this@MainApplication))
        }
    }

}