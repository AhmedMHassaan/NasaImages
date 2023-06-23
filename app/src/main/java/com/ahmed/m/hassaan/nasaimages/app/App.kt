package com.ahmed.m.hassaan.nasaimages.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    public companion object {
        public const val APP_TAG = "APP_TAG"
    }
}