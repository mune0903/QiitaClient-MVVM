package com.github.mune0903.qiitaclient_mvvm

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //Stetho.initializeWithDefaults(this)
            //Timber.plant(Timber.DebugTree())
        }
    }
}