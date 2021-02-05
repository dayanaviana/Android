package com.android_training.class12.b

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.android_training.class12.R
import kotlinx.android.synthetic.main.activity_main.*

class MainBActivity : AppCompatActivity() {

    var mList: ArrayList<News> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        generateData()

        var newsAdapter = NewsAdapter(this, mList)
        list_view.adapter = newsAdapter

        list_view.setOnItemClickListener { p0, p1, position, p3 ->
            var news = mList[position]
            Toast.makeText(applicationContext, news.title, Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateData(){
//        mList.add(News("Title 1", "Description 1"))
        mList.add(News("The New York Times", "McKinsey Settles for Nearly \$600 Million Over Role in Opioid Crisis"))
        mList.add(News("ZDNet", "‘Weird new things are happening in software,’ says Stanford AI professor Chris Re"))
        mList.add(News("Livescience.com", "Chemists create and capture einsteinium, the elusive 99th element"))
        mList.add(News("Reuters", "Exclusive: Suspected Chinese hackers used SolarWinds bug to spy on U.S. payroll agency – sources"))
        mList.add(News("Snopes.com", "Did Biden Give Gitmo Prisoners COVID-19 Vaccines Before Americans?"))
        mList.add(News("PolitiFact", "Photo shows Democratic protesters who “stormed the US Capitol in 2018.”"))
        mList.add(News("The Dispatch", "Clearing Up What Happened to Ocasio-Cortez During the Storming of the Capitol"))
        mList.add(News("Snopes.com", "Did Biden Vow To Eliminate the 'Stepped-Up' Basis for Capital Gains Tax?\n"))
        mList.add(News("APF Factcheck", "Trump's insulin order frozen, not scrapped, by Biden"))
        mList.add(News("The New York Times", "Sedrick Rowe is one of Georgia’s few organic peanut farmers and one of a shrinking number of African-American farmers in the United States."))
        mList.add(News("Vox.com", "An anti-Semitic cartoon from Spain in 1935, accusing a politician of taking Jewish bribes."))
        mList.add(News("Complex", "A Breakdown of Armie Hammer's Cannibalism and Abuse Controversy"))
        mList.add(News("US Today", "Oregon law to decriminalize all drugs goes into effect, offering addicts rehab instead of prison"))
        mList.add(News("BBC News", "Home working increases cyber-security fears"))
        mList.add(News("CNET", "$300 bonus unemployment checks: How long will they last? What you should know"))
    }

}