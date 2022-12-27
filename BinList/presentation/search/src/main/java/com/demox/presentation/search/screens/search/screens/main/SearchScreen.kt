package com.demox.presentation.search.screens.search.screens.main

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demox.presentation.base_ui.theme.AppTheme
import com.demox.presentation.base_ui.view.BinInfoScreen
import com.demox.presentation.base_ui.view.dialogs.CustomErrorDialog
import com.demox.presentation.search.R
import com.demox.presentation.search.screens.search.screens.main.viewmodel.SearchViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: SearchViewModel = hiltViewModel()
    val searchText by viewModel.binSearchText.collectAsState()
    val buttonState by viewModel.buttonState.collectAsState()
    val binInfo by viewModel.binInfo.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val errorDialogState by viewModel.errorDialogState.collectAsState()
    val noBinDialogState by viewModel.noBin.collectAsState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        TextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp),
            value = searchText,

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppTheme.colors.systemGraphLine,
                textColor = AppTheme.colors.systemTextPrimary,
                cursorColor = AppTheme.colors.controlGraphBlueDark,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            placeholder = { Text("Search Bin", color = AppTheme.colors.systemTextSecondary) },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                viewModel.onBinSearchTextChange(it)
            }
        )
        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (buttonState) {
                    AppTheme.colors.controlGraphBlueActive
                } else {
                    AppTheme.colors.controlGraphDisable
                }
            ),
            enabled = buttonState,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                keyboardController?.hide()
                viewModel.searchBinInfo()
            }
        ) {
            Text(
                "Search",
                color = AppTheme.colors.systemTextOnPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (binInfo != null) {
            Card(
                modifier = Modifier.padding(5.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
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
        if (noBinDialogState) {
            Dialog(
                onDismissRequest = {},
                content = {
                    CustomErrorDialog(title = stringResource(id = R.string.error_title), message = stringResource(id = R.string.no_bin).format(searchText)) {
                        viewModel.noBinDialogDis()
                    }
                }
            )
        }

        if (errorDialogState) {
            Dialog(
                onDismissRequest = {},
                content = {
                    CustomErrorDialog(title = stringResource(id = R.string.error_title), message = stringResource(id = R.string.enter_string_error)) {
                        viewModel.noErrorDialog()
                    }
                }
            )
        }
    }
}
