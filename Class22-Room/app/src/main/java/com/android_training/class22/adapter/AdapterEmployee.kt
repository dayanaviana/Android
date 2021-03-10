package com.android_training.class22.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.android_training.class22.R
import com.android_training.class22.activity.UpdateActivity
import com.android_training.class22.database.EmployeeEntity
import com.android_training.class22.database.MyDatabase
import kotlinx.android.synthetic.main.row_employee_adapter.view.*

class AdapterEmployee(var mContext: Context): RecyclerView.Adapter<AdapterEmployee.MyViewHolder>() {

    var mList: ArrayList<EmployeeEntity> = ArrayList()

    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(e: EmployeeEntity, position: Int){
            itemView.txt_id.text = e.id.toString()
            itemView.txt_name.text = e.name
            itemView.txt_email.text = e.email

            itemView.img_edit.setOnClickListener {
                var intent = Intent(mContext, UpdateActivity::class.java)
                intent.putExtra(EmployeeEntity.DATA, e)
                mContext.startActivity(intent)
//                Toast.makeText(mContext,"Edit", Toast.LENGTH_SHORT).show()
            }
            itemView.img_delete.setOnClickListener {
                var mydb = Room.databaseBuilder(
                    mContext, MyDatabase::class.java, "mydb"
                ).allowMainThreadQueries().build()

                mydb.getDao().deleteEmployee(e)
                mList.removeAt(position)
                notifyItemRemoved(position)
                Toast.makeText(mContext,"Delete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_employee_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position], position)
    }

    fun setData(data: ArrayList<EmployeeEntity>){
        mList = data
        notifyDataSetChanged()
    }
}