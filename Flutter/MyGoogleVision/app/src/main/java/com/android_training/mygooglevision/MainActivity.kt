//Source: https://www.youtube.com/watch?v=DFwSBUb6wA8

package com.android_training.mygooglevision

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.SparseArray
import android.view.SurfaceHolder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.util.isNotEmpty
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val requestCodeCameraPermission = 101
    private lateinit var cameraSource: CameraSource
    private lateinit var detector: BarcodeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED){
            askForPermission()
        }else setupControls()
    }

    private fun setupControls(){
        //Recognizes barcodes (various 1D and 2D formats)
        detector = BarcodeDetector.Builder(this).build()
        //Receive frames from the camera and uses detector to recognize barcodes
        cameraSource = CameraSource.Builder(this,detector)
            .setAutoFocusEnabled(true)
            .build()
        camera_surface_view.holder.addCallback(surgaceCallBack)
        detector.setProcessor(processor)
    }

    private fun askForPermission(){
        ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.CAMERA),
        requestCodeCameraPermission)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == requestCodeCameraPermission && grantResults.isNotEmpty()){
            setupControls()
        }else{
            Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_LONG).show()
        }
    }

    private val surgaceCallBack = object: SurfaceHolder.Callback{
        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
            cameraSource.stop()
        }

        override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
            try {
                if (ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.CAMERA
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    askForPermission()
                }
                cameraSource.start(surfaceHolder)
            }catch (e: Exception){
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
    }

    private val processor = object : Detector.Processor<Barcode>{
        override fun release() {
        }

        override fun receiveDetections(detections: Detector.Detections<Barcode>?) {
            if(detections != null && detections.detectedItems.isNotEmpty()){
                val qrCodes: SparseArray<Barcode> = detections.detectedItems
                val code =  qrCodes.valueAt(0)
                txtScanResult.text = code.displayValue
            }else{
                txtScanResult.text = ""
            }
        }
    }
}