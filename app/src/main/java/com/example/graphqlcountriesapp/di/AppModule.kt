package com.example.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlcountriesapp.data.ApolloCountryClient
import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.GetCountriesUseCase
import com.example.graphqlcountriesapp.domain.GetCountryUseCase
import com.umvel.network_android.usecase.IsOnlineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()

    @Provides
    @Singleton
    fun provideCountryClient(
        apolloClient: ApolloClient,
        isOnlineUseCase: IsOnlineUseCase
    ): CountryClient = ApolloCountryClient(apolloClient, isOnlineUseCase)

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(
        countryClient: CountryClient
    ): GetCountriesUseCase = GetCountriesUseCase(countryClient)

    @Provides
    @Singleton
    fun provideGetCountryUseCase(
        countryClient: CountryClient
    ): GetCountryUseCase = GetCountryUseCase(countryClient)

}