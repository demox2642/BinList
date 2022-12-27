package com.demox.presentation.history.screens.main

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demox.presentation.base_ui.convertToDataString
import com.demox.presentation.base_ui.theme.AppTheme

@Composable
fun HistoryMainScreen(navController: NavHostController) {
    val viewModel: HistoryMainVM = hiltViewModel()
    val binList by viewModel.binList.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(10.dp)) {
        items(binList) {
            Card(
                modifier = Modifier.fillMaxWidth().height(100.dp).padding(bottom = 10.dp),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = AppTheme.colors.systemGraphLine
            ) {
                Row(
                    modifier = Modifier.fillParentMaxSize().padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = it.data.convertToDataString(), color = AppTheme.colors.systemTextPrimary, fontSize = 18.sp)
                    Text(text = it.binNum.toString(), color = AppTheme.colors.systemTextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
