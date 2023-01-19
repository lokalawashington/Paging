package com.nyumbakumiapp.android.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyumbakumiapp.android.paging.adapter.CountryAdapter
import com.nyumbakumiapp.android.paging.utils.CountriesDb

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
    }
}