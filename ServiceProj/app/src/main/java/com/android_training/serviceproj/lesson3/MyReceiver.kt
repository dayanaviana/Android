package com.android_training.serviceproj.lesson3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.android_training.serviceproj.MainActivity

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("debuging","BroadcastReceiver: onReceive")
        Toast.makeText(context, "AIRPLAN MODE", Toast.LENGTH_SHORT).show()

        var intent = Intent(context, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
    }
}