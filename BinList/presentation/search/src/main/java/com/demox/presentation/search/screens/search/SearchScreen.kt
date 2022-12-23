package com.demox.presentation.search.screens.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.demox.presentation.search.screens.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen() {
    val viewModel: SearchViewModel = hiltViewModel()
    Text("Search Screen")
}
