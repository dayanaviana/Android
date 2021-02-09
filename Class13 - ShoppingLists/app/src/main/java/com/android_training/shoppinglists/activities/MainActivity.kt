package com.android_training.shoppinglists.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.shoppinglists.R
import com.android_training.shoppinglists.adapters.FragmentAdapter
import com.android_training.shoppinglists.models.Category
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mCategoryList: ArrayList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        var fragmentAdapter = FragmentAdapter(supportFragmentManager)

        generateCategories()
        for (i in 0 until mCategoryList.size){
            fragmentAdapter.addFragment(mCategoryList[i])
        }

        //SETUP TAB LAYOUT & VIEW ADAPTER
        view_pager.adapter = fragmentAdapter
        tab_layout.setupWithViewPager(view_pager)

        //Handle icons setup on adapter
        fragmentAdapter.setTitleIcons(tab_layout, mCategoryList)

    }

    private fun generateCategories() {
        mCategoryList.add(Category(1, "Mobile", R.drawable.phone_icon))
        mCategoryList.add(Category(2, "Laptop", R.drawable.laptop_icon))
        mCategoryList.add(Category(3, "Desktop", R.drawable.desktop_icon))
        mCategoryList.add(Category(4, "Tablets"))
        mCategoryList.add(Category(5, "Watches"))
        mCategoryList.add(Category(6, "EarBuds"))
    }
}