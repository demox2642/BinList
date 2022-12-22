package com.demox.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demox.data.database.contracts.CountryContract
import com.demox.data.database.models.Country
@Dao
interface CountryDao {
    @Insert
    suspend fun insertCountry(country: Country)

    @Query(
        "SELECT ${CountryContract.Colums.ID} FROM ${CountryContract.TABLE_NAME} WHERE ${CountryContract.Colums.NAME}=:countryName"
    )
    suspend fun getCountryId(countryName: String): Long?
}
