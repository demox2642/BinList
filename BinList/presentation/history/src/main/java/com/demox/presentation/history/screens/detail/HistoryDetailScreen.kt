package com.demox.presentation.history.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demox.presentation.base_ui.view.BinInfoScreen

@Composable
fun HistoryDetailScreen(navController: NavHostController, arguments: Long) {
    val viewModel: HistoryDetailVM = hiltViewModel()
    viewModel.getBinInfo(arguments)
    val binInfo by viewModel.binInfo.collectAsState()

    if (binInfo != null) {
        BinInfoScreen(
            scheme = binInfo!!.scheme,
            brand = binInfo!!.brand,
            type = binInfo!!.type.toString(),
            prepaid = binInfo!!.prepaid,
            country = binInfo!!.country_name.toString(),
            length = binInfo!!.length,
            lunht = binInfo!!.luhn == true,
            bankName = binInfo!!.bank_name.toString(),
            bankUrl = binInfo!!.bank_url.toString(),
            bankPhone = binInfo!!.bank_phone.toString(),
            countryLatitude = binInfo!!.country_latitude,
            countryLongitude = binInfo!!.country_longitude
        )
    }
}
