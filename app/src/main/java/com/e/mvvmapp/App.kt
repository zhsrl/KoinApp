package com.e.mvvmapp

import android.app.Application
import com.e.mvvmapp.di.networkModule
import com.e.mvvmapp.di.repositoryModule
import com.e.mvvmapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    repositoryModule))
        }
    }
}