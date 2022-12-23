package com.demox.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demox.data.database.contracts.BinListContract
import com.demox.data.database.models.BinList
import com.demox.data.database.models.BinListInfo

@Dao
interface BinListDao {

    @Insert
    suspend fun insertBinList(binList: BinList)

    @Query(
        "SELECT * FROM ${BinListContract.TABLE_NAME} WHERE ${BinListContract.Colums.ID}=:binListId"
    )
    suspend fun getBinListInfo(binListId: Long): BinListInfo?

    @Query(
        "SELECT * \n" +
            "    FROM    ${BinListContract.TABLE_NAME}\n" +
            "    WHERE   ${BinListContract.Colums.ID} = (SELECT MAX(${BinListContract.Colums.ID})  FROM ${BinListContract.TABLE_NAME})"
    )
    suspend fun getLastBinListInfo(): BinListInfo

    @Query(
        "SELECT * FROM ${BinListContract.TABLE_NAME} "
    )
    suspend fun getAllBinList(): List<BinList>
}
