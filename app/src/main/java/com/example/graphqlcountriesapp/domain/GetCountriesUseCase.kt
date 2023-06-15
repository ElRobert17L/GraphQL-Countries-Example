package com.example.graphqlcountriesapp.domain

import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<SimpleCountry> = countryClient
        .getCountries()
        .sortedBy { it.name }

}