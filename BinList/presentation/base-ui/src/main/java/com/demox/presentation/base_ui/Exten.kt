package com.demox.presentation.base_ui // ktlint-disable package-name

import java.text.SimpleDateFormat

fun Long.convertToDataString(): String {
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(this)
}
