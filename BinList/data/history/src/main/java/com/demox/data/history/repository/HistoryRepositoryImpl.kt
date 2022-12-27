package com.demox.data.history.repository

import com.demox.data.database.Database
import com.demox.domain.history.model.BinInfo
import com.demox.domain.history.model.BinListItem
import com.demox.domain.history.repository.HistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val database: Database
) : HistoryRepository {
    override suspend fun getHistoryBinList(): Flow<List<BinListItem>> {
        return flow {
            emit(
                database.binListDao().getAllBinList().map {
                    BinListItem(
                        id = it.id!!,
                        binNum = it.binNum,
                        data = it.date
                    )
                }
            )
        }
    }

    override suspend fun getHistoryBinInfo(id: Long): Flow<BinInfo?> {
        return flow {
            emit(
                database.binListDao().getBinListInfo(id).let {
                    if (it == null) {
                        null
                    } else {
                        BinInfo(
                            bank_town = it.bank?.town,
                            bank_name = it.bank?.name,
                            bank_phone = it.bank?.phone,
                            bank_url = it.bank?.url,
                            prepaid = it.binList.prepaid,
                            country_currency = it.country?.currency,
                            country_latitude = it.country?.latitude,
                            country_longitude = it.country?.longitude,
                            country_name = it.country?.name,
                            brand = it.binList.brand.toString(),
                            length = it.binList.length,
                            luhn = it.binList.luhn,
                            scheme = it.binList.scheme,
                            type = it.binList.type
                        )
                    }
                }
            )
        }.flowOn(Dispatchers.IO)
    }
}
