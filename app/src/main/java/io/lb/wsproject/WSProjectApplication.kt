package io.lb.wsproject

import android.app.Application
import timber.log.Timber

class WSProjectApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}