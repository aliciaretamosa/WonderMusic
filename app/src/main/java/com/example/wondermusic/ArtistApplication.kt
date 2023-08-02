package com.example.wondermusic

import android.app.Application
import com.keepcoding.androidsuperpoderes.di.dataModule
import com.keepcoding.androidsuperpoderes.di.domainModule
import com.keepcoding.androidsuperpoderes.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class ArtistApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@ArtistApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}