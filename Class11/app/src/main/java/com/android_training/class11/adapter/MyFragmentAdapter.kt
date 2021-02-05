package com.android_training.class11.adapter

//Add Layout Dependencies
//File > Project Structure > dependency > app > + > Library dependency > search
// design & material

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android_training.class11.OneFragment
import com.android_training.class11.R
import com.android_training.class11.ThreeFragment
import com.android_training.class11.TwoFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main_class11.*

//Adapter: setup for pager view and tab layout in the activity
class MyFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 30
    }

    //Pager view swipe setup
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> ThreeFragment()
        }
    }

    //Tab Layout - setup name for each tab
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "One"
            1 -> "Two"
            else -> position.toString()
        }
    }

    fun setTitleIcons(tab: TabLayout) {
        //Add icons to Tab Layout
        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_child_care_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_adb_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_android_black_24dp)
    }
}










