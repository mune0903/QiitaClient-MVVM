package com.github.mune0903.qiitaclient_mvvm

import android.app.Application
import com.facebook.stetho.Stetho
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Debugビルドの時だけ有効にする設定
        if (BuildConfig.DEBUG) {
            // Chromeで通信ログを見れる
            Stetho.initializeWithDefaults(this)
            // ロギングライブラリ
            Timber.plant(Timber.DebugTree())
        }
    }
}