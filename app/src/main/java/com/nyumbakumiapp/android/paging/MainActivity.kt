package com.nyumbakumiapp.android.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyumbakumiapp.android.paging.R
import com.nyumbakumiapp.android.paging.adapters.CountryAdapter
import com.nyumbakumiapp.android.paging.models.Country
import com.nyumbakumiapp.android.paging.utils.CountriesDb
import com.nyumbakumiapp.android.paging.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Prepare countries
        CountriesDb.initialize(this)

        // Connect to RecyclerView
        val countriesRv = findViewById<RecyclerView>(R.id.countries_rv)
        val adapter = CountryAdapter()

        countriesRv.layoutManager = LinearLayoutManager(this)
        countriesRv.adapter = adapter

        val viewModel = MainActivityViewModel()
        viewModel.countries.observe(this, Observer<PagedList<Country>> { countries ->
            Log.v(TAG, "Observed ${countries.size} countries from viewModel...")
            adapter.submitList(countries)
        })
    }
}