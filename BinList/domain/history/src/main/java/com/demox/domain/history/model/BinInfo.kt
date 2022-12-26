package com.demox.domain.history.model

data class BinInfo(
    val bank_town: String?,
    val bank_name: String?,
    val bank_phone: String?,
    val bank_url: String?,
    val prepaid: Boolean,
    val country_currency: String?,
    val country_latitude: Int?,
    val country_longitude: Int?,
    val country_name: String,
    val brand: String,
    val length: Int?,
    val luhn: Boolean?,
    val scheme: String,
    val type: String
)
