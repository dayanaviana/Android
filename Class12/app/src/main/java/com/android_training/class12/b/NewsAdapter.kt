package com.android_training.class12.b

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.android_training.class12.R
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class NewsAdapter (var mContext: Context, var mList: ArrayList<News>) : BaseAdapter(){

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
        var view = layoutInflater.inflate(R.layout.row_news_adapter, container, false)

        var news = mList[position]

        view.text_view_title.text = news.title
        view.text_view_description.text = news.description

        return view
    }

}