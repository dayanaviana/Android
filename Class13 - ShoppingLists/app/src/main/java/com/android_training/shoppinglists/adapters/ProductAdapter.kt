package com.thevarungupta.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.android_training.shoppinglists.R
import com.android_training.shoppinglists.models.Product
import kotlinx.android.synthetic.main.rows_layout.view.*

class ProductAdapter(var mContext: Context, var mList: ArrayList<Product>) : BaseAdapter() {

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, container: ViewGroup?): View {
        var view =
            LayoutInflater.from(mContext).inflate(R.layout.rows_layout, container, false)
        var product = mList[position]
        view.img_item.setImageResource(product.productImage!!)
        view.txt_item_title.text = product.productName
        view.txt_item_description.text = product.productDescription
        return view
    }

}