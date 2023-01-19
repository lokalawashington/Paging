package com.nyumbakumiapp.android.paging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nyumbakumiapp.android.paging.datasources.PagedCountriesDataSourceFactory
import com.nyumbakumiapp.android.paging.models.Country

class MainActivityViewModel: ViewModel() {

    val pageSize = 15
    var config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(15)
        .setEnablePlaceholders(false)
        .build()

    var dataSource = PagedCountriesDataSourceFactory()
    var countries: LiveData<PagedList<Country>> = LivePagedListBuilder(dataSource,config).build()

}