package com.nyumbakumiapp.android.paging.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.nyumbakumiapp.android.paging.data.ContactDatabase
import com.nyumbakumiapp.android.paging.models.Contact
import com.nyumbakumiapp.android.paging.utils.ContactsBoundaryCallback

class MainActivityViewModel(db: ContactDatabase): ViewModel() {

    val pageSize = 15
    var config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(15)
        .setPrefetchDistance(5)
        .setEnablePlaceholders(false)
        .build()
    var dataSource = db.contactDao()

    var contacts: LiveData<PagedList<Contact>> = dataSource.getContacts()
        .toLiveData(config,
            null,
            ContactsBoundaryCallback()
        )
}