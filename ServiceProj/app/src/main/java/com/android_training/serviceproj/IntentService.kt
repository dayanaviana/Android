package com.android_training.serviceproj

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class WorkerThreadService : IntentService("myservicethread"){

    override fun onHandleIntent(intent: Intent?) {
        for (i in 0..5){
            Thread.sleep(1000)//1s
        }
    }

    lateinit var mp : MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this,R.raw.music)
        Toast.makeText(this,"service created", Toast.LENGTH_SHORT).show()
        Log.d("debuging", "Worker Thread: Service created")
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this,"service started", Toast.LENGTH_SHORT).show()
        Log.d("debuging", "Worker Thread: Service started")
        mp.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"service destroyed", Toast.LENGTH_SHORT).show()
        Log.d("debuging", "Worker Thread: Service destroyed")
        mp.stop()

    }
}