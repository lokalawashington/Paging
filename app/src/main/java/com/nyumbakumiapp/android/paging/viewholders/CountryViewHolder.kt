package com.nyumbakumiapp.android.paging.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyumbakumiapp.android.paging.R
import com.nyumbakumiapp.android.paging.models.Country

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val TAG: String = "CountryViewHolder"

    private val countryTitle = view.findViewById<TextView>(R.id.country_title)
    private val countryDesc = view.findViewById<TextView>(R.id.country_desc)

    fun bind (country: Country) {
        val title = "${country.name} - ${country.shortCode}"
        val desc = "Population: ${country.population}"
        countryTitle.text = title
        countryDesc.text = desc
    }

    companion object {
        fun create(parent: ViewGroup): CountryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.countries_rv_layout, parent, false)

            return CountryViewHolder(view)
        }
    }
}