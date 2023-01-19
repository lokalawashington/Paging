package com.nyumbakumiapp.android.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.nyumbakumiapp.android.paging.adapters.ContactsAdapter
import com.nyumbakumiapp.android.paging.data.ContactDatabase
import com.nyumbakumiapp.android.paging.models.Contact
import com.nyumbakumiapp.android.paging.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ready the database
        val db = Room.databaseBuilder(this, ContactDatabase::class.java, "contacts.sqlite")
            .allowMainThreadQueries()
            .build()
        viewModel = MainActivityViewModel(db)

        // Connect to RecyclerView
        val contactsRv = findViewById<RecyclerView>(R.id.contacts_rv)
        val adapter = ContactsAdapter()

        contactsRv.layoutManager = LinearLayoutManager(this)
        contactsRv.adapter = adapter

        viewModel.contacts.observe(this, Observer { contacts ->
            Log.v(TAG, "Observed ${contacts.size} contacts from ViewModel")
            adapter.submitList(contacts)
        })
    }

    fun deleteTop(view: View) {
        val topContact = viewModel.dataSource.getTopContact()
        viewModel.dataSource.delete(topContact)
    }

    val firstNames = arrayOf("Steve", "Bill", "Mike", "George", "John", "Chris")
    val lastNames = arrayOf("Mathers", "Hanlon", "Taylor", "Smith", "Trevolta")
    fun addContact(view: View?) {
        val name = "${firstNames.random()} ${lastNames.random()}";
        val lastId = viewModel.dataSource.getLastId()
        Log.i(TAG, "lastId is ${lastId}")
        val contact = Contact(lastId + 1, name)

        Log.i(TAG, "inserting contact to the database ${contact}")
        viewModel.dataSource.insertContact(contact)
    }
}