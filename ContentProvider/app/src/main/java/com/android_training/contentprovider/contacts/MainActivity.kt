package com.android_training.contentprovider.contacts

import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.WRITE_CONTACTS
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_training.contentprovider.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recycler_view.layoutManager = LinearLayoutManager(baseContext)

        btn_lodContent.setOnClickListener {
            if(ContextCompat.checkSelfPermission(baseContext, READ_CONTACTS)
                != PermissionChecker.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(baseContext, WRITE_CONTACTS)
                != PermissionChecker.PERMISSION_GRANTED
            ){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(arrayOf(READ_CONTACTS, WRITE_CONTACTS),101)
                }
            }else{
                loadContacts()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(ContextCompat.checkSelfPermission(baseContext, READ_CONTACTS)
                == PermissionChecker.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(baseContext, WRITE_CONTACTS)
                == PermissionChecker.PERMISSION_GRANTED
            ) {
            loadContacts()
        }else{
            Toast.makeText(baseContext, "Need Permission", Toast.LENGTH_LONG).show()
        }
    }

    private fun loadContacts() {

//        MediaStore.AUTHORITY_URI
//        UserDictionary.Words.CONTENT_URI

//        prefix: //authority.path/id
//        prefix: //authority.path

        //~database/table
//        content://com.google.contactbook/contacts
//        content://com.google.userdictionary/words
//        content://com.google.mediastore/images
//        content://com.google.mediastore/images


        var uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        var cursor = contentResolver.query(
                uri,
                arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        var list = ArrayList<Contact>()
        while(cursor?.moveToNext() == true){
            val name = cursor.getString((cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)))
            val number = cursor.getString((cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))
            list.add(Contact(name,number))
        }

        adapter = ContactAdapter(baseContext, list)
        recycler_view.adapter = adapter

        // Following commented code will not work. Because Contacts Content Provider does not support
        // insert, update and delete functions. At runtime, it will cause UnsupportedOperationException
        /*
        val values = ContentValues()
        values.put(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, "Bank")
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "+1874512369")

        contentResolver.insert(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            values
        )*/
    }
}