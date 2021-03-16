package com.android_training.rxjava.network

import com.android_training.rxjava.models.Product
import com.android_training.rxjava.models.ProductResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    fun getProducts(): Observable<Product>
    @GET("products/{id}")
    fun getProductById(@Path("id")id: String): Single<ProductResponse>
}