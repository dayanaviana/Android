package com.android_training.class12.c

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.android_training.class12.R
import kotlinx.android.synthetic.main.rows_news_image.view.*

class NewsAdapterC (var mContext: Context, var mList: ArrayList<NewsC>) : BaseAdapter(){

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, container: ViewGroup?): View {
        var layoutInflater = LayoutInflater.from(mContext)
        var view = layoutInflater.inflate(R.layout.rows_news_image, container, false)

        var news = mList[position]

        view.img_news.setImageResource(news.image)
        view.text_view_title.text = news.title
        view.text_view_description.text = news.description

        return view
    }

}