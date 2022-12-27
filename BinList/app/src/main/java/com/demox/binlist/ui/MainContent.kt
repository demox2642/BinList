package com.demox.binlist.ui

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.demox.presentation.base_ui.theme.AppTheme
import com.demox.presentation.history.historyScreens
import com.demox.presentation.search.SearchScreens
import com.demox.presentation.search.searchScreens

@Composable
fun MainContent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNav(navController) },
        backgroundColor = AppTheme.colors.systemBackgroundPrimary
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SearchScreens.SearchScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            searchScreens(navController)
            historyScreens(navController)
        }
    }
}

@Composable
fun BottomNav(navController: NavHostController) {
    val items = listOf(
        MainScreen.Search,
        MainScreen.History
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = AppTheme.colors.systemBackgroundPrimary,
        modifier = Modifier
            .defaultMinSize(minWidth = 1.dp),
        elevation = 0.dp
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(screen.iconId),
                        contentDescription = stringResource(screen.resourceId)
                    )
                },
                label = {
                    Text(stringResource(screen.resourceId), maxLines = 1, softWrap = true)
                },
                alwaysShowLabel = true,
                selectedContentColor = AppTheme.colors.systemGraphPrimary,
                unselectedContentColor = AppTheme.colors.systemGraphSecondary,
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,

                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                    }
                }
            )
        }
    }
}
