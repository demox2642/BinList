package com.demox.search.model

data class BinInfo(
    val bank_town: String,
    val bank_cityname: String,
    val bank_cityphone: String?,
    val bank_cityurl: String?,
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
