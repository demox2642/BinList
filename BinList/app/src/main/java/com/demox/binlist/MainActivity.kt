package com.demox.binlist

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.demox.binlist.di.ConnectionManager
import com.demox.binlist.ui.MainContent
import com.demox.presentation.base_ui.theme.AppTheme
import com.demox.presentation.base_ui.theme.AppTheme.AppTheme
import com.demox.presentation.base_ui.theme.appDarkColors
import com.demox.presentation.base_ui.theme.appLightColors
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var connectionManager: ConnectionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.light_gray)
            val darkTheme: Boolean = isSystemInDarkTheme()
            val colors = if (darkTheme) appDarkColors() else appLightColors()

            val snackbarHostState = remember { mutableStateOf(SnackbarHostState()) }
            connectionManager.connectionLiveData.observe(this) {
                if (!it) {
                    lifecycleScope.launch {
                        snackbarHostState.value.showSnackbar(
                            message = "No Network Connection",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }

            AppTheme(colors = colors) {
                SystemUi(windows = window)
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                    SnackbarHost(
                        hostState = snackbarHostState.value
                    ) {
                        Snackbar(
                            modifier = Modifier.padding(12.dp),
                            backgroundColor = AppTheme.colors.colorBackgroundAlert,
                            snackbarData = it,
                            contentColor = AppTheme.colors.colorTextAlert
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SystemUi(windows: Window) =
    AppTheme {
        windows.statusBarColor = AppTheme.colors.systemBackgroundPrimary.toArgb()
        windows.navigationBarColor = AppTheme.colors.systemBackgroundPrimary.toArgb()

        @Suppress("DEPRECATION")
        if (AppTheme.colors.systemBackgroundPrimary.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (AppTheme.colors.systemBackgroundPrimary.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }
