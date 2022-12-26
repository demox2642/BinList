package com.demox.presentation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.demox.presentation.search.screens.search.screens.main.SearchScreen

sealed class SearchScreens(
    val route: String
) {
    object SearchScreen : SearchScreens("search_bin")
}
fun NavGraphBuilder.searchScreens(navController: NavHostController) {
    composable(SearchScreens.SearchScreen.route) { SearchScreen(navController) }
}
