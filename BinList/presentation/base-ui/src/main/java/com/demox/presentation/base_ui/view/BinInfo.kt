package com.demox.presentation.base_ui.view // ktlint-disable package-name

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Web
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.demox.presentation.base_ui.R
import com.demox.presentation.base_ui.theme.AppTheme
import com.demox.presentation.base_ui.view.dialogs.CustomAllertDialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BinInfoScreen(
    scheme: String,
    brand: String,
    type: String,
    prepaid: Boolean,
    country: String,
    length: Int?,
    lunht: Boolean,
    bankName: String,
    bankUrl: String,
    bankPhone: String,
    countryLatitude: Int?,
    countryLongitude: Int?
) {
    val context = LocalContext.current
    val callPermissionState = rememberPermissionState(
        android.Manifest.permission.CALL_PHONE
    )
    val openDialog = remember { mutableStateOf(false) }
    val changePermissionState: () -> Unit = {
        callPermissionState.launchPermissionRequest()
        openDialog.value = false
    }

    val closeDialog: () -> Unit = {
        openDialog.value = false
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.scheme).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = scheme, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.brand).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = brand, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.type).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = type, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.prepaid).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = if (prepaid) { stringResource(id = R.string.yes).uppercase() } else { stringResource(id = R.string.no).uppercase() }, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.country).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Row() {
                Text(text = country, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.MyLocation,
                    contentDescription = stringResource(id = R.string.country).uppercase(),
                    tint = AppTheme.colors.controlGraphBlueActive,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable(onClick = {
                            val strUri =
                                "http://maps.google.com/maps?q=loc:$countryLatitude,$countryLongitude"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(strUri))
                            intent.setClassName(
                                "com.google.android.apps.maps",
                                "com.google.android.maps.MapsActivity"
                            )
                            context.startActivity(intent)
                        })
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(id = R.string.card_number).uppercase(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.length).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = length.toString(), fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.luhn).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = if (lunht) { stringResource(id = R.string.yes).uppercase() } else { stringResource(id = R.string.no).uppercase() }, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(id = R.string.bank).uppercase(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.name).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = bankName, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.web_site).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)

            Row() {
                Text(text = bankUrl, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.Web,
                    contentDescription = stringResource(id = R.string.web_site).uppercase(),
                    tint = AppTheme.colors.controlGraphBlueActive,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable(onClick = {
                            val url = if (!bankUrl.startsWith("http://") && !bankUrl.startsWith("https://")) "http://$bankUrl" else (bankUrl)
                            val browserIntent =
                                Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(browserIntent)
                        })
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.phone).uppercase(), fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)

            Row() {
                Text(text = bankPhone, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                if (!callPermissionState.status.isGranted) {
                    Icon(
                        Icons.Default.Phone,
                        contentDescription = stringResource(id = R.string.phone).uppercase(),
                        tint = AppTheme.colors.controlGraphDisable,

                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable(onClick = {
                                openDialog.value = true
                            })
                    )
                } else {
                    Icon(
                        Icons.Default.Phone,
                        contentDescription = stringResource(id = R.string.phone).uppercase(),
                        tint = AppTheme.colors.controlGraphBlueActive,

                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable(onClick = {
                                val intent =
                                    Intent(Intent.ACTION_CALL, Uri.parse("tel:$bankPhone"))
                                context.startActivity(intent)
                            })
                    )
                }
            }
        }

        if (openDialog.value) {
            Dialog(
                onDismissRequest = {},
                content = {
                    CustomAllertDialog(
                        title = stringResource(id = R.string.permission_title),
                        message = stringResource(id = R.string.permission_message),
                        confermButtonText = stringResource(id = R.string.permission_conferm_bt),
                        dismissButtonText = stringResource(id = R.string.permission_dismiss_bt),
                        closeDialog = closeDialog,
                        changePermissionState = changePermissionState
                    )
                }
            )
        }
    }
}
