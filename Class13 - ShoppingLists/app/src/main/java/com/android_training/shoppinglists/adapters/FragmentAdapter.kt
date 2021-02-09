package com.android_training.shoppinglists.adapters

//Add Layout Dependencies
//File > Project Structure > dependency > app > + > Library dependency > search
// design & material

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android_training.shoppinglists.R
import com.android_training.shoppinglists.fragments.ProductFragment
import com.android_training.shoppinglists.models.Category
import com.google.android.material.tabs.TabLayout

//Adapter: setup for pager view and tab layout in the activity
class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var mFragmentList: ArrayList<Fragment> = ArrayList()
    var mTitleList: ArrayList<String> = ArrayList()

    override fun getCount(): Int {
//        return 3
        return mTitleList.size
    }

    //Pager view swipe setup
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
//        return when (position) {
//            0 -> MobileFragment()
//            1 -> LaptopFragment()
//            else -> DesktopFragment()
//        }
    }

    //Tab Layout - setup name for each tab
    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
//        return when (position) {
//            0 -> "Mobile"
//            1 -> "Laptop"
//            else -> "Desktop"
//        }
    }

    fun setTitleIcons(tab: TabLayout, categoryList: ArrayList<Category>) {
        //Add icons to Tab Layout
        for (i in 0 until categoryList.size){
            tab.getTabAt(i)!!.setIcon (categoryList[i].catImg!!)
        }
    }

    fun addFragment(category: Category){
        mFragmentList.add(ProductFragment.newInstance(category.catId))
        mTitleList.add(category.catName)
    }
}










