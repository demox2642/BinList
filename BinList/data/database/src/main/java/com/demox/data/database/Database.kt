package com.demox.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demox.data.database.dao.BankDao
import com.demox.data.database.dao.BinListDao
import com.demox.data.database.dao.CountryDao
import com.demox.data.database.models.Bank
import com.demox.data.database.models.BinList
import com.demox.data.database.models.Country

@Database(
    entities = [Bank::class, BinList::class, Country::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun bankDao(): BankDao
    abstract fun countryDao(): CountryDao
    abstract fun binListDao(): BinListDao
}
