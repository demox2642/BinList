package com.demox.binlist.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.demox.binlist.R

sealed class MainScreen(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val resourceId: Int
) {
    object Search : MainScreen("search_bin", R.drawable.main_search, R.string.search)
    object History : MainScreen("history_main", R.drawable.main_history, R.string.history)
}
