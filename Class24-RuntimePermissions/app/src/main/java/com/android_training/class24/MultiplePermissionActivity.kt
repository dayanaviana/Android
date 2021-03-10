package com.android_training.class24

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_multiple_permission.*

class MultiplePermissionActivity : AppCompatActivity() {

    private val REQUEST_MULTIPLE_CODE = 201
    private var requestPermissionList: ArrayList<String> = ArrayList()

    var granted = ""
    var denied = ""

    var permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_permission)
        init()
    }

    private fun init() {
        btn_multiple_permissions.setOnClickListener {
            checkMultiplePermission()
        }
    }

    private fun checkMultiplePermission() {
        for(permission in permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_DENIED
            ) {
                //Add to list to request permission
                requestPermissionList.add(permission)
            }
            requestMultiplePermission()
        }
    }

    private fun requestMultiplePermission() {
        ActivityCompat.requestPermissions(this,
            permissions,
        REQUEST_MULTIPLE_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_MULTIPLE_CODE -> {
                if (!grantResults.isEmpty()) {
                    for (i in 0 until permissions.lastIndex) {
                        //PERMISSION_DENIED == 1
                        //PERMISSION_GRANTED == 0
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            denied += "${permissions[i].toString()} \n"
                        } else {
                            granted += "${permissions[i].toString()} \n"
                        }
                        if (i == permissions.lastIndex) {
                            Toast.makeText(
                                applicationContext,
                                "Finished Multiple Permission",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("myApp", "onResume")
        updateLayout()
    }

    override fun onPause() {
        super.onPause()
        Log.d("myApp", "onPause")
        updateLayout()
    }

    private fun updateLayout(){
        txt_granted.text = granted
        txt_denied.text = denied
    }

}