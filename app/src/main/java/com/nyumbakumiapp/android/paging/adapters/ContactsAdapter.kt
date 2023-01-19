package com.nyumbakumiapp.android.paging.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.nyumbakumiapp.android.paging.models.Contact
import com.nyumbakumiapp.android.paging.viewholderss.ContactViewHolder

class ContactsAdapter: PagedListAdapter<Contact, ContactViewHolder>(CONTACT_DIFFUTIL_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)

        if (contact != null) {
            holder.bind(contact)
        }
    }

    companion object {
        private val CONTACT_DIFFUTIL_CALLBACK = object: DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}