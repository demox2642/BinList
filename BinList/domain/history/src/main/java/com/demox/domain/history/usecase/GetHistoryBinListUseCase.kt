package com.demox.domain.history.usecase

import com.demox.domain.history.repository.HistoryRepository

class GetHistoryBinListUseCase(private val searchRepository: HistoryRepository) {
    suspend fun getHistoryBinList() = searchRepository.getHistoryBinList()
}
