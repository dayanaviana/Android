package com.android_training.contentprovider.gallery

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.getBitmap
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.GridLayoutManager
import com.android_training.contentprovider.R
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class GalleryActivity : AppCompatActivity() {
    var galleryList = ArrayList<Photo>()
    var album = TreeSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        init()
    }

    private fun init() {
        checkPermission()
            //
        var adapter = AdapterPhotoGrid()
        adapter.setData(galleryList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this,3)
    }
    private fun checkPermission(){
        Dexter.withContext(baseContext)
            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(object: PermissionListener{
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    Log.d("myApp", "Permission Granted")
                    loadMedia()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    Log.d("myApp", "onPermissionRationaleShouldBeShown")
                    token?.continuePermissionRequest()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    Log.d("myApp", "Permission Denied")
                    Toast.makeText(baseContext, "Need Permission", Toast.LENGTH_LONG).show()
                }

            }).check()
    }
    private fun loadMedia(){
        //MediaStore.Audio, MediaStore.Video
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = contentResolver.query(
            uri,
            arrayOf(MediaStore.Images.Media.BUCKET_DISPLAY_NAME
            ,MediaStore.Images.Media.DISPLAY_NAME
            ,MediaStore.Images.Media.MINI_THUMB_MAGIC
            ,MediaStore.Images.Media._ID)
        ,null
        ,null
        ,null
        )

        while(cursor?.moveToNext()==true){
            val bucketName = cursor.getString(0)
            val displayName = cursor.getString(1)
            val miniThumbMagic = cursor.getString(2)
            val id = cursor.getLong(3)
            var imageUri = Uri.withAppendedPath(uri,"$id")
            album.add(bucketName)
            galleryList.add(Photo(bucketName,imageUri))
        }
        Log.d("myApp", "$galleryList.size Photos")
    }
}
