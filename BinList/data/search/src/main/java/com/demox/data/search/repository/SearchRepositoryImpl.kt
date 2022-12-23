package com.demox.data.search.repository

import androidx.room.withTransaction
import com.demox.data.database.Database
import com.demox.data.database.models.Bank
import com.demox.data.database.models.BinList
import com.demox.data.database.models.BinListInfo
import com.demox.data.database.models.Country
import com.demox.data.search.model.ServerResponse
import com.demox.data.search.service.SearchService
import com.demox.search.model.BinInfo
import com.demox.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchService: SearchService,
    private val database: Database
) : SearchRepository {

    override suspend fun getBinList(bin: String): Flow<BinInfo?> {
        val response = searchService.getBinList(bin = bin)

        return flow {
            emit(
                insertToDataBase(response).let {
                    BinInfo(
                        bank_town = it!!.bank.town,
                        bank_cityname = it.bank.name,
                        bank_cityphone = it.bank.phone,
                        bank_cityurl = it.bank.url,
                        country_currency = it.country.currency,
                        country_latitude = it.country.latitude,
                        country_longitude = it.country.longitude,
                        country_name = it.country.name,
                        brand = it.binList.brand,
                        length = it.binList.length,
                        luhn = it.binList.luhn,
                        scheme = it.binList.scheme,
                        type = it.binList.type
                    )
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun insertToDataBase(response: Response<ServerResponse>): BinListInfo? {
        var binInfo: BinListInfo? = null

        if (response.isSuccessful) {
            val content = response.body()
            database.withTransaction {
                if (content?.country?.name?.let { database.countryDao().getCountryId(it) } == null) {
                    database.countryDao().insertCountry(
                        Country(
                            numeric = content?.country?.numeric?.toLong(),
                            alpha2 = content?.country?.alpha2,
                            name = content?.country?.name!!,
                            emoji = content.country.emoji,
                            currency = content.country.currency,
                            latitude = content.country.latitude,
                            longitude = content.country.longitude
                        )
                    )
                }
            }

            database.withTransaction {
                if (content?.bank?.name?.let { database.bankDao().getBankId(it) } == null) {
                    database.bankDao().insertBank(
                        Bank(
                            name = content!!.bank.name,
                            phone = content.bank.phone,
                            url = content.bank.url,
                            town = content.bank.city
                        )
                    )
                }
            }

            database.withTransaction {
                database.binListDao().insertBinList(
                    BinList(
                        bank_id = getBankId(content?.bank?.name!!),
                        brand = content.brand,
                        country_id = getCountryId(content.country.name),
                        length = content.number.length,
                        luhn = content.number.luhn,
                        scheme = content.scheme,
                        type = content.type

                    )
                )
            }
            binInfo = database.binListDao().getLastBinListInfo()
        }
        return binInfo
    }

    private suspend fun getCountryId(name: String): Long? {
        return database.countryDao().getCountryId(name)
    }

    private suspend fun getBankId(name: String): Long? {
        return database.bankDao().getBankId(name)
    }
}
