package com.demox.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demox.data.database.contracts.BankContract

@Entity(
    tableName = BankContract.TABLE_NAME
)

data class Bank(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BankContract.Colums.ID)
    val id: Long? = null,
    @ColumnInfo(name = BankContract.Colums.NAME)
    val name: String?,
    @ColumnInfo(name = BankContract.Colums.PHONE)
    val phone: String?,
    @ColumnInfo(name = BankContract.Colums.URL)
    val url: String?,
    @ColumnInfo(name = BankContract.Colums.TOWN)
    val town: String?
)
