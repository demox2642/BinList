package com.demox.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.demox.data.database.contracts.BankContract
import com.demox.data.database.models.Bank

@Dao
interface BankDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertBank(bank: Bank)

    @Query(
        "SELECT ${BankContract.Colums.ID} FROM ${BankContract.TABLE_NAME} WHERE ${BankContract.Colums.NAME}=:bankName"
    )
    suspend fun getBankId(bankName: String?): Long?
}
