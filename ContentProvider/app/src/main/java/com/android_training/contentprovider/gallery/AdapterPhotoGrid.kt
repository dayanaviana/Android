package com.android_training.contentprovider.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android_training.contentprovider.R
import kotlinx.android.synthetic.main.row_photo_adapter.view.*

class AdapterPhotoGrid(): RecyclerView.Adapter<AdapterPhotoGrid.MyViewHolder>() {

    var mContext: Context = MyApplication.appContext

    private var mList: ArrayList<Photo> = ArrayList()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(photo: Photo){
            itemView.progress_bar.visibility = View.GONE
            itemView.image_view.setImageURI(photo.imageUri)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_photo_adapter, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    fun setData(data: ArrayList<Photo>){
        mList = data
        notifyDataSetChanged()
    }
}