package com.demox.search.usecase

import com.demox.search.repository.SearchRepository

class GetBinListUseCase(private val searchRepository: SearchRepository) {
    suspend fun getBinList(bin: String): String {
        return searchRepository.getBinList(bin = bin)
    }
}
