package com.demox.domain.history.repository

import com.demox.domain.history.model.BinInfo
import com.demox.domain.history.model.BinListItem
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getHistoryBinList(): Flow<List<BinListItem>>
    suspend fun getHistoryBinInfo(id: Long): Flow<BinInfo?>
}
