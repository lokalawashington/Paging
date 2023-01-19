package com.nyumbakumiapp.android.paging.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nyumbakumiapp.android.paging.datasources.PagedCountriesDataSourceFactory
import com.nyumbakumiapp.android.paging.models.Country
import com.nyumbakumiapp.android.paging.utils.CountriesBoundaryCallback

class MainActivityViewModel: ViewModel() {

    val pageSize = 15
    var config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(15)
        .setPrefetchDistance(5)
        .setEnablePlaceholders(false)
        .build()

    var dataSource = PagedCountriesDataSourceFactory()
    var countries: LiveData<PagedList<Country>> = LivePagedListBuilder(dataSource, config)
        .setBoundaryCallback(CountriesBoundaryCallback())
        .build()
}