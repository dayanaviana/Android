package com.android_training.shoppinglists.models

import com.android_training.shoppinglists.R

data class Category(
    var catId: Int,
    var catName: String,
    var catImg: Int? = R.drawable.star_icon
){
    companion object{
        const val KEY_CAT_ID = "catId"
    }
}