package com.demox.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demox.data.database.contracts.CountryContract

@Entity(
    tableName = CountryContract.TABLE_NAME
)
data class Country(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CountryContract.Colums.ID)
    val id: Long? = null,
    @ColumnInfo(name = CountryContract.Colums.NUMERIC)
    val numeric: Long?,
    @ColumnInfo(name = CountryContract.Colums.ALPHA2)
    val alpha2: String?,
    @ColumnInfo(name = CountryContract.Colums.NAME)
    val name: String,
    @ColumnInfo(name = CountryContract.Colums.EMOJI)
    val emoji: String?,
    @ColumnInfo(name = CountryContract.Colums.CURRENCY)
    val currency: String,
    @ColumnInfo(name = CountryContract.Colums.LATITUDE)
    val latitude: Int?,
    @ColumnInfo(name = CountryContract.Colums.LONGITUDE)
    val longitude: Int?

)
