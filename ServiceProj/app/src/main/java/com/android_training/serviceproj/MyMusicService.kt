package com.android_training.serviceproj

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyMusicService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}