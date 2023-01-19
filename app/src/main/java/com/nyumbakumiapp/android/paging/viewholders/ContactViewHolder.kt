package com.nyumbakumiapp.android.paging.viewholderss

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyumbakumiapp.android.paging.R
import com.nyumbakumiapp.android.paging.models.Contact

class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val TAG: String = "ContactViewHolder"

    private val name = view.findViewById<TextView>(R.id.contacts_name)

    fun bind (contact: Contact) {
        name.text = contact.name
    }

    companion object {
        fun create(parent: ViewGroup): ContactViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.contacts_rv_layout, parent, false)

            return ContactViewHolder(view)
        }
    }
}