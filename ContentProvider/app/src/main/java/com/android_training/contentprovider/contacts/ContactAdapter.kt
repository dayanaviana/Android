package com.android_training.contentprovider.contacts

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android_training.contentprovider.R
import com.android_training.contentprovider.databinding.RowContactBinding
import kotlinx.android.synthetic.main.activity_main.*

class ContactAdapter(var context: Context, var contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        var inflater = LayoutInflater.from(context)

        val binding: RowContactBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.row_contact,parent,false
        )
        return ContactHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contacts[position])
    }
}

class ContactHolder(val binding: RowContactBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(contact: Contact){
        binding.contact = contact
    }
}

