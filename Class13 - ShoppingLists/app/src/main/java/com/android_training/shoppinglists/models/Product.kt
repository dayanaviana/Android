package com.android_training.shoppinglists.models

import com.android_training.shoppinglists.R


data class Product(
    var catId: Int,
    var productName: String,
    var productDescription: String,
    var productImage: Int? = R.drawable.ic_launcher_foreground
)