//2. pass the data from activity to intentService
package com.android_training.serviceproj.task2

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.android_training.serviceproj.R

class DataToServiceService : IntentService("myservicethread"){
    var myData = ""
    override fun onHandleIntent(intent: Intent?) {
        Log.d("debugin", "DataToServiceService: onHandleIntent $myData")
        for (i in 0..10){

            Thread.sleep(1000)

        }



    }
    
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        if (intent != null) {
            myData = intent.getStringExtra("DATA").toString()
        }
        Log.d("debugin", "DataToServiceService: onHandleIntent myData")
        Toast.makeText(this,myData, Toast.LENGTH_SHORT).show()
    }

}