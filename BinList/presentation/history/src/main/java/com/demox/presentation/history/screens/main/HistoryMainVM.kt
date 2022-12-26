package com.demox.presentation.history.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demox.domain.history.model.BinListItem
import com.demox.domain.history.usecase.GetHistoryBinListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryMainVM @Inject constructor(
    private val getHistoryBinListUseCase: GetHistoryBinListUseCase
) : ViewModel() {
    private val _binList = MutableStateFlow(emptyList<BinListItem>())
    val binList = _binList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getHistoryBinListUseCase.getHistoryBinList().collectLatest {
                _binList.value = it
            }
        }
    }
}
