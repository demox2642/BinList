package com.demox.search.repository

import com.demox.search.model.BinInfo
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getBinList(bin: String): Flow<BinInfo?>
}
