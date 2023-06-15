package com.example.graphqlcountriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.graphqlcountriesapp.presentation.CountriesScreen
import com.example.graphqlcountriesapp.presentation.CountriesViewModel
import com.example.graphqlcountriesapp.ui.theme.GraphQlCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlCountriesAppTheme {
               val state by viewModel.state.collectAsState()

                CountriesScreen(
                    state = state,
                    onSelectCountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}