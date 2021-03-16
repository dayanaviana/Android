package com.android_training.rxjava.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android_training.rxjava.MyApplication
import com.android_training.rxjava.R
import com.android_training.rxjava.models.Product
import com.android_training.rxjava.models.ProductResponse
import com.android_training.rxjava.network.ProductApi
import com.android_training.rxjava.viewmodels.ProductViewModel
import io.reactivex.SingleObserver
import kotlinx.android.synthetic.main.activity_product.*
import javax.inject.Inject

class ProductActivity : AppCompatActivity() {
    @Inject lateinit var mProductApi: ProductApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        (application as MyApplication).daggerComponent?.inject(this)
        init()
    }

    private fun init() {
        var viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModel.productApi = mProductApi
        viewModel.getProduct()
        var productResponse = viewModel.liveData.observe(this, object: Observer<Product> {
            override fun onChanged(product: Product?) {
                txt_product_name.text = product?.productName ?: "Error"
            }
        })
    }
}