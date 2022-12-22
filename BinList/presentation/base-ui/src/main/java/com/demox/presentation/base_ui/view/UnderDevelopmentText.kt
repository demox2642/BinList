package com.demox.presentation.base_ui.view // ktlint-disable package-name

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.demox.presentation.base_ui.R
import com.demox.presentation.base_ui.theme.AppTheme

@Composable
fun UnderDevelopmentText() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.base_ui_under_develop),
            style = AppTheme.typography.h2,
            color = AppTheme.colors.systemTextPrimary
        )
    }
}
