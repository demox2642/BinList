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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demox.presentation.base_ui.theme.AppTheme

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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "SCHEME / NETWORK", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = scheme, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "BRAND", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = brand, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "TYPE", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = type, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "PREPAID", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = if (prepaid) { "Yes" } else { "No" }, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "COUNTRY", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Row() {
                Text(text = country, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.MyLocation,
                    contentDescription = "local",
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
        Text(text = "CARD NUMBER", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "LENGTH", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = length.toString(), fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "LUHN", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = if (lunht) { "Yes" } else { "No" }, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "BANK", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "NAME", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)
            Text(text = bankName, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "URL", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)

            Row() {
                Text(text = bankUrl, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.Web,
                    contentDescription = "web",
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
            Text(text = "PHONE", fontSize = 18.sp, color = AppTheme.colors.systemTextTertiary)

            Row() {
                Text(text = bankPhone, fontSize = 18.sp, color = AppTheme.colors.systemTextSecondary, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.Phone,
                    contentDescription = "phone",
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
}
