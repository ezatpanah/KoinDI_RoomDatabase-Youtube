package com.ezatpanah.koindi_roomdatabase_youtube

import android.app.Application
import com.ezatpanah.koindi_roomdatabase_youtube.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            /** Context **/
            androidContext(this@MyApp)
            /** Room Database **/
            modules(databaseModule)
        }
    }
}
