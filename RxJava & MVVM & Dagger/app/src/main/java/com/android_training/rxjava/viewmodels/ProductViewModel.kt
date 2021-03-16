package com.android_training.rxjava.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android_training.rxjava.models.Product
import com.android_training.rxjava.models.ProductResponse
import com.android_training.rxjava.network.ProductApi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ProductViewModel(): ViewModel() {
    lateinit var disposable: Disposable
    lateinit var productApi: ProductApi
    var liveData: MutableLiveData<Product> = MutableLiveData()

    fun getProduct(){
        productApi
            .getProductById("5de4a33df571123984a948ac")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { item: ProductResponse -> item.data }
            .subscribeWith(getObserver() as SingleObserver<Product>)
    }
    private fun getObserver(): SingleObserver<Product> {
        return object : SingleObserver<Product>{
            override fun onSuccess(product: Product) {
                liveData.value = product
            }
            override fun onSubscribe(d: Disposable) {
                disposable = d
            }
            override fun onError(e: Throwable) {
                Log.d("myApp","Product Observer Error")
            }
        }
    }
    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}