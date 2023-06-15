package com.example.graphqlcountriesapp.data

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqlcountriesapp.domain.DetailedCountry
import com.example.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailCountry(): DetailedCountry = DetailedCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital",
    currency = currency ?: "No currency",
    languages = languages.map { it.name },
    continent = continent.name
)

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry = SimpleCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital"
)