package com.example.graphqlcountriesapp.domain

import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val countryClient: CountryClient
) {

    suspend fun execute(
        code: String
    ): DetailedCountry? = countryClient.getCountry(code)

}