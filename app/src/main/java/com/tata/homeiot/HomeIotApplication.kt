package com.tata.homeiot

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class HomeIotApplication: Application() {


    init {
        Log.i("HomeIotApplication", "HomeIotApplication");
    }
}