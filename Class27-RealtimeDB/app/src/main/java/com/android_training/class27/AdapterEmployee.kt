package com.android_training.class27

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.row_adapter_employee.view.*

class AdapterEmployee(var mContext: Context): RecyclerView.Adapter<AdapterEmployee.MyViewHolder>() {
    var mList: ArrayList<Employee> = ArrayList()

    var dbReference = FirebaseDatabase.getInstance().getReference(Employee.KEY_EMPLOYEE)

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(employee: Employee, position: Int){
            itemView.txt_name.text = employee.name
            itemView.txt_email.text = employee.email
            itemView.edt_name.setText(employee.name)
            itemView.edt_email.setText(employee.email)

            itemView.btn_delete.setOnClickListener {
                var empId = employee.key
                dbReference.child(empId!!).setValue(null)
                mList.remove(employee)
//                notifyItemRemoved(position)
            }
            itemView.btn_edit.setOnClickListener {
                setupEditLayout(itemView)
            }
            itemView.btn_done.setOnClickListener {
                var name = itemView.edt_name.text.toString()
                var email = itemView.edt_email.text.toString()
                var emp = Employee(name, email)
                dbReference.child(employee.key!!).setValue(emp)
//                notifyItemChanged(position)

                setupViewLayout(itemView)
            }
        }
    }

    fun setupViewLayout(itemView: View){
        itemView.view_data_layout.visibility = View.VISIBLE
        itemView.edit_data_layout.visibility = View.GONE
        itemView.btn_delete.visibility = View.VISIBLE
        itemView.btn_done.visibility = View.GONE
        itemView.btn_edit.visibility = View.VISIBLE
    }

    fun setupEditLayout(itemView: View){
        itemView.view_data_layout.visibility = View.GONE
        itemView.edit_data_layout.visibility = View.VISIBLE
        itemView.btn_delete.visibility = View.GONE
        itemView.btn_done.visibility = View.VISIBLE
        itemView.btn_edit.visibility = View.GONE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_employee, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position], position)
    }

    fun setData(data: ArrayList<Employee>){
        mList = data
        notifyDataSetChanged()
    }
}