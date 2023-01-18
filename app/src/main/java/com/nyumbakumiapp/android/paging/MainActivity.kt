package com.nyumbakumiapp.android.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nyumbakumiapp.android.paging.utils.CountriesDb

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesDb.initialize(this)
    }
}