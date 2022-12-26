package com.demox.presentation.history

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.demox.presentation.history.screens.detail.HistoryDetailScreen
import com.demox.presentation.history.screens.main.HistoryMainScreen

sealed class HistoryScreens(
    val route: String
) {
    object HistoryMainScreen : HistoryScreens("history_main")
    object HistoryDetailScreen : HistoryScreens("history_detail")
}
fun NavGraphBuilder.historyScreens(navController: NavHostController) {
    composable(HistoryScreens.HistoryMainScreen.route) { HistoryMainScreen(navController) }
    composable(
        HistoryScreens.HistoryDetailScreen.route + "/{bin_id}",
        arguments = listOf(navArgument(name = "bin_id") { NavType.StringType })
    ) { backStackEntry ->
        val arguments =
            (backStackEntry.arguments?.getString("bin_id") ?: return@composable).toLong()
        HistoryDetailScreen(navController, arguments)
    }
}
