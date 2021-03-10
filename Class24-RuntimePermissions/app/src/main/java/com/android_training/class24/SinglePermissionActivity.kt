package com.android_training.class24

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class SinglePermissionActivity : AppCompatActivity() {
    private val REQUEST_CAMERA_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btn_camera.setOnClickListener {
            checkPermission()
        }
    }

    private fun checkPermission(){
        var permission = ContextCompat.checkSelfPermission(this,
        Manifest.permission.CAMERA)
        if(permission != PackageManager.PERMISSION_GRANTED){
            //DO NOT HAVE PERMISSION
            requestCameraPermission()
        }else{
//            HAS PERMISSION
            openCamera()
        }
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.CAMERA),
        REQUEST_CAMERA_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CAMERA_CODE -> {
                if(grantResults.isEmpty() ||
                        grantResults[0] != PackageManager.PERMISSION_GRANTED){ //PERMISSION_GRANTED == 0
                    Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                    openCamera()
                }
            }
        }
    }

    private fun openCamera() {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CAMERA_CODE)
    }

}