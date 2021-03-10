package com.android_training.news_reader.adapter

import android.content.Context
import android.net.ParseException
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.android_training.class23.R
import com.android_training.news_reader.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_news_adapter.view.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class AdapterNews(var mContext: Context): RecyclerView.Adapter<AdapterNews.MyViewHolder>() {

    var mList: ArrayList<Article> = ArrayList()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(article: Article, position: Int){
            itemView.txt_title.text = article.title
            itemView.txt_description.text = article.description
            itemView.txt_date.text = convertMongoDate(article.publishedAt)
//            itemView.txt_date.text = convertDate(article.publishedAt)

            Picasso.get()
                .load(article.urlToImage)
                .into(itemView.img_news)
        }

        //Call requires API level 26 (current min is 19): java.time.LocalDateTime#format
        @RequiresApi(Build.VERSION_CODES.O)
        fun convertDate(dateString: String): String{
            val instant = Instant.parse(dateString)
            val datetime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"))
            return datetime.format(DateTimeFormatter.ofPattern("MM-dd-yyy"))
//            return datetime.toString()
        }
        private fun convertMongoDate(date: String): String? {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val outputFormat = SimpleDateFormat("MMM d, yyyy")
            try {
                val finalStr: String = outputFormat.format(inputFormat.parse(date))
                println(finalStr)
                return finalStr
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_news_adapter,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position],position)
    }

    fun setData(data: ArrayList<Article>){
        mList = data
        notifyDataSetChanged()
    }
}