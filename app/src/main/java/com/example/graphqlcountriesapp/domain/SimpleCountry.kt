package com.example.graphqlcountriesapp.domain

data class SimpleCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String
)