package com.demox.data.database.models

import androidx.room.* // ktlint-disable no-wildcard-imports
import com.demox.data.database.contracts.BankContract
import com.demox.data.database.contracts.BinListContract
import com.demox.data.database.contracts.CountryContract
import java.util.*

@Entity(
    tableName = BinListContract.TABLE_NAME,

    foreignKeys = [
        androidx.room.ForeignKey(
            entity = Bank::class,
            parentColumns = [BankContract.Colums.ID],
            childColumns = [BinListContract.Colums.BANK_ID]
        ),
        ForeignKey(
            entity = Country::class,
            parentColumns = [CountryContract.Colums.ID],
            childColumns = [BinListContract.Colums.COUNTRY_ID]
        )
    ]
)

data class BinList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BinListContract.Colums.ID)
    val id: Long,
    @ColumnInfo(name = BinListContract.Colums.DATE)
    val date: Long = getDateTime(),
    @ColumnInfo(name = BinListContract.Colums.BANK_ID)
    val bank_id: Long?,
    @ColumnInfo(name = BinListContract.Colums.BRAND)
    val brand: String,
    @ColumnInfo(name = BinListContract.Colums.COUNTRY_ID)
    val country_id: Long?,
    @ColumnInfo(name = BinListContract.Colums.LENTH)
    val length: Int?,
    @ColumnInfo(name = BinListContract.Colums.LUHN)
    val luhn: Boolean?,
    @ColumnInfo(name = BinListContract.Colums.SHEME)
    val scheme: String,
    @ColumnInfo(name = BinListContract.Colums.TYPE)
    val type: String
)

private fun getDateTime(): Long {
    val calendar = Calendar.getInstance()
    return calendar.timeInMillis
}

data class BinListInfo(
    @Embedded
    val binList: BinList,
    @Relation(
        parentColumn = BinListContract.Colums.COUNTRY_ID,
        entityColumn = CountryContract.Colums.ID
    )
    val country: Country,
    @Relation(
        parentColumn = BinListContract.Colums.BANK_ID,
        entityColumn = BankContract.Colums.ID
    )
    val bank: Bank
)
