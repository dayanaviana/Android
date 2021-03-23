package com.android_training.contentprovider.gallery

import android.net.Uri

data class Photo(
    var bucketName: String?,
    var imageUri: Uri
)
//        getBitmap(contentResolver, imageUri)