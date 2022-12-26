package com.demox.binlist.di

import com.demox.domain.history.repository.HistoryRepository
import com.demox.domain.history.usecase.GetHistoryBinInfoUseCase
import com.demox.domain.history.usecase.GetHistoryBinListUseCase
import com.demox.search.repository.SearchRepository
import com.demox.search.usecase.GetBinListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesGetBinListUseCase(searchRepository: SearchRepository): GetBinListUseCase = GetBinListUseCase(searchRepository = searchRepository)

    @Provides
    fun providesGetHistoryBinInfoUseCase(historyRepository: HistoryRepository): GetHistoryBinInfoUseCase = GetHistoryBinInfoUseCase(searchRepository = historyRepository)

    @Provides
    fun providesGetHistoryBinListUseCase(historyRepository: HistoryRepository): GetHistoryBinListUseCase = GetHistoryBinListUseCase(searchRepository = historyRepository)
}
