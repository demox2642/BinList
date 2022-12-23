package com.demox.data.search.repository

import android.util.Log
import com.demox.data.database.Database
import com.demox.data.search.service.SearchService
import com.demox.search.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchService: SearchService,
    private val database: Database
) : SearchRepository {

    override suspend fun getBinList(bin: String): String {
        val test = searchService.getBinList(bin = bin)
        Log.e("SearchRepositoryImpl", "${test.body()?.bank}")
        return bin
    }
}
