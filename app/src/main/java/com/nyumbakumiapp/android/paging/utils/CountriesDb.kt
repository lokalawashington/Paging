package com.nyumbakumiapp.android.paging.utils

import android.content.Context
import com.nyumbakumiapp.android.paging.models.Country
import com.google.gson.Gson

class CountriesDb {
    companion object {
        private lateinit var countries: ArrayList<Country>

        fun initialize(context: Context) {
            val content = context.assets.open("countries_paged.json")
                    .bufferedReader()
                    .use {
                        it.readText()
                    }
            countries = ArrayList(Gson()
                            .fromJson(content, Array<Country>::class.java)
                            .toList())
        }

        fun getCountries(): List<Country> {
            return countries
        }

        fun deleteCountry(countryCode: String) {
            countries.filter { countryCode != countryCode }
        }

        fun deleteCountryById(id: Int) {
            countries.removeAll { country -> country.id == id }
        }

        fun addCountry(country: Country) {
            countries.add(country)
        }
    }
}