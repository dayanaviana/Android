package com.android_training.class24

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_dexter.*
import kotlinx.android.synthetic.main.activity_dexter.btn_multiple_permissions
import kotlinx.android.synthetic.main.activity_dexter.txt_denied
import kotlinx.android.synthetic.main.activity_dexter.txt_granted
import kotlinx.android.synthetic.main.activity_multiple_permission.*

class DexterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dexter)
        init()
    }

    private fun init() {
        btn_single_permission.setOnClickListener {requestSinglePermission()}
        btn_multiple_permissions.setOnClickListener { requestMultiplePermissions() }
    }
    private fun requestSinglePermission() {
        Dexter.withContext(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object: PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    //Permission Granted
                    var name = response!!.requestedPermission.name
                    Toast.makeText(applicationContext, "$name \n Permission GRANTED", Toast.LENGTH_LONG).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    //Permission Denied
                    Toast.makeText(applicationContext, "Permission DENIED", Toast.LENGTH_LONG).show()
                }

            }).check()
    }

    private fun requestMultiplePermissions() {
        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            .withListener(object: MultiplePermissionsListener{
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    //ALL Permissions Granted
                    if(report!!.areAllPermissionsGranted()){
                        Toast.makeText(applicationContext, "ALL Permission granted", Toast.LENGTH_LONG).show()
                    }
                    //ANY permanent Denial?
                    if(report!!.isAnyPermissionPermanentlyDenied){
//                      Toast.makeText(applicationContext, "Permission denied permanently", Toast.LENGTH_LONG).show()
                        showGoToSettingsDialog()
                    }
                    if(!report!!.deniedPermissionResponses.isEmpty()){
                        var denies: MutableList<PermissionDeniedResponse> = report!!.deniedPermissionResponses
                        if(!denies.isEmpty()){
                            var str = ""
                            for (deny in denies){
                                str += deny.permissionName + "\n"
                            }
                            txt_denied.text = str
                        }
                    }
                    if(!report!!.grantedPermissionResponses.isEmpty()){
                        var grants: MutableList<PermissionGrantedResponse> = report!!.grantedPermissionResponses
                        if(!grants.isEmpty()){
                            var str = ""
                            for(grant in grants){
                                 str += grant.permissionName + "\n"
                            }
                            txt_granted.text = str
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            }).onSameThread().check()
    }

    private fun showGoToSettingsDialog(){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Need Permission")
        builder.setMessage("Please, give this permission")
        builder.setPositiveButton("Go to Settings", object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
                openAppSettings()
            }
        })
        builder.setNegativeButton("Cancel", object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }
        })
        builder.show()
    }

    fun openAppSettings(){
        var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        var uri = Uri.fromParts("package", packageName, null)
        intent.setData(uri)
        startActivityForResult(intent, 101)
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
        txt_granted.text = ""
        txt_denied.text = ""
    }

}