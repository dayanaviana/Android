package com.android_training.class23.models

data class SubcategoryResponse(
    val count: Int,
    val data: Array<Subcategory>,
    val error: Boolean
)

data class Subcategory(
    val __v: Int,
    val _id: String,
    val catId: Int,
    val position: Int,
    val status: Boolean,
    val subDescription: String,
    val subId: Int,
    val subImage: String,
    val subName: String
)