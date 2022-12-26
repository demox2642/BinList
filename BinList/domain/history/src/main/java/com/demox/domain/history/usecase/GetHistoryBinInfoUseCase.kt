package com.demox.domain.history.usecase

import com.demox.domain.history.repository.HistoryRepository

class GetHistoryBinInfoUseCase(private val searchRepository: HistoryRepository) {
    suspend fun getHistoryBinInfo(id: Long) = searchRepository.getHistoryBinInfo(id)
}
