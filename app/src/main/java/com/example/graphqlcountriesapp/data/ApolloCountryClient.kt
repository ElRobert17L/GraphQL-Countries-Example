package com.example.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.DetailedCountry
import com.example.graphqlcountriesapp.domain.SimpleCountry
import com.umvel.network_android.usecase.IsOnlineUseCase
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient,
    private val isOnlineUseCase: IsOnlineUseCase
): CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> =
        if (isOnlineUseCase()) {
            apolloClient
                .query(CountriesQuery())
                .execute()
                .data
                ?.countries
                ?.map { it.toSimpleCountry() }
                .orEmpty()
        } else {
            emptyList()
        }

    override suspend fun getCountry(
        code: String
    ): DetailedCountry? =
        if (isOnlineUseCase()) {
            apolloClient
                .query(CountryQuery(code))
                .execute()
                .data
                ?.country
                ?.toDetailCountry()
        } else {
            null
        }

}