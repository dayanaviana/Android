package com.android_training.shoppinglists.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android_training.shoppinglists.R
import com.android_training.shoppinglists.models.*
import com.thevarungupta.myapplication.adapters.ProductAdapter
import kotlinx.android.synthetic.main.list_layout.view.*


class ProductFragment : Fragment() {
    // Parameters
    private var mProducts: ArrayList<Product> = ArrayList()
    private var catId: Int = 0

    //Get data sent to fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            catId = it.getInt(Category.KEY_CAT_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.list_layout, container, false)
        init(view)
        return view
    }
    private fun init(view: View){
        //SETUP LIST VIEW
        getData(catId)

//        var itemsAdapter = ItemsAdapter(view.context, mProducts)
        var productAdapter = ProductAdapter(activity!!, mProducts)
        view.list_view.adapter = productAdapter

        //TODO : Handle item clicked
        view.list_view.setOnItemClickListener { p0, p1, position, p3 ->
            var news = mProducts[position]
            // Toast.makeText(applicationContext, news.title, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(catId: Int) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putInt(Category.KEY_CAT_ID, catId)
                }
            }
    }

    private fun getData(catId: Int) {
        when(catId){
            1->{
//                mProducts.add(Product(category, "name", "Description", img))
                mProducts.add(Product(1, "\$36.66/mo.", "Apple - iPhone 12 Pro Max 5G 128GB - Gold (Verizon)",R.drawable.phone1))
                mProducts.add(Product(1, "\$19.99/mo.", "Samsung - Galaxy S21 5G 128GB - Phantom Gray (AT&T)",R.drawable.phone2))
                mProducts.add(Product(1, "\$37.50/mo.", "Apple - iPhone 11 Pro 256GB - Space Gray (Sprint)",R.drawable.phone3))
                mProducts.add(Product(1, "\$119.99", "TRACFONE - Motorola Moto E6 with 16GB Memory Prepaid Cell Phone - Starry Black",R.drawable.phone4))
                mProducts.add(Product(1, "\$129.99", "Verizon Prepaid - Motorola Moto e 32GB - Midnight Blue",R.drawable.phone5))
            }
            2->{
                mProducts.add(Product(2, "\$999.99", "MacBook Air 13.3\\\" Laptop - Apple M1 chip - 8GB Memory - 256GB SSD (Latest Model)", R.drawable.laptop1))
                mProducts.add(Product(2, "\$219.99", "ASUS - 14.0\\\" Laptop - Intel Celeron N4020 - 4GB Memory - 128GB eMMC - Pink", R.drawable.laptop2))
                mProducts.add(Product(2, "\$549.99", "Lenovo - Yoga C740 2-in-1 14\\\" Touch-Screen Laptop - Intel Core i5 - 8GB Memory - 256GB", R.drawable.laptop3))
                mProducts.add(Product(2, "\$499.99", "HP - Pavilion x360 2-in-1 14\\\" Touch-Screen Laptop - Intel Core i3 - 8GB Memory - 128GB SSD", R.drawable.laptop4))
                mProducts.add(Product(2, "\$219.99", "HP - 14\\\" Laptop - Intel Celeron - 4GB Memory - 64GB eMMC - Snowflake white", R.drawable.laptop5))
            }
            3->{
                mProducts.add(Product(3, "\$549.99", "HP - 24\\\" All-In-One - Intel Core i3 - 8GB Memory - 256GB SSD - Black", R.drawable.desktop1))
                mProducts.add(Product(3, "\$399.99", "HP - 19.5\\\" All-In-One - AMD A4-Series - 4GB Memory - 1TB Hard Drive - Snow White", R.drawable.desktop2))
                mProducts.add(Product(3, "\$699.99", "Lenovo - IdeaCentre A540 24\\\" Touch-Screen All-In-One - AMD Ryzen 3-Series - 8GB Memory - 256GB Solid State Drive - Black", R.drawable.desktop3))
                mProducts.add(Product(3, "\$629.99", "ASUS - M241DA 23.8'' Touch-Screen All-In-One - AMD R5-3500U - 8GB Memory - 256GB Solid State Drive - White", R.drawable.desktop4))
                mProducts.add(Product(3, "\$679.99", "Dell - Inspiron 24\\\" Touch-Screen All-In-One - Intel Core i3 - 8GB Memory - 256GB SSD - Black", R.drawable.desktop5))
            }
            else->{
                mProducts.add(Product(catId, "Price", "Description"))
                mProducts.add(Product(catId, "Price", "Description"))
                mProducts.add(Product(catId, "Price", "Description"))
                mProducts.add(Product(catId, "Price", "Description"))
                mProducts.add(Product(catId, "Price", "Description"))
            }
        }
    }
}