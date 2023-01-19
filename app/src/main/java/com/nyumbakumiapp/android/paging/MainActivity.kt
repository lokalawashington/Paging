package com.nyumbakumiapp.android.paging

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyumbakumiapp.android.paging.adapter.CountryAdapter
import com.nyumbakumiapp.android.paging.models.Country
import com.nyumbakumiapp.android.paging.utils.CountriesDb
import com.nyumbakumiapp.android.paging.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesDb.initialize(this)

        //connect to Recyclerview
        var countriesRv = findViewById<RecyclerView>(R.id.countries_rv)
        val adapter = CountryAdapter()

        countriesRv.layoutManager = LinearLayoutManager(this)
        countriesRv.adapter = adapter

        //viewmodel instance
        val viewModel = MainActivityViewModel()
        viewModel.countries.observe(this, Observer< PagedList<Country>>{ countries ->
            Log.v(TAG,"Observed ${countries.size} countries from viewModel...")
            adapter.submitList(countries)
        })
    }
}