package com.demox.presentation.history.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demox.domain.history.model.BinInfo
import com.demox.domain.history.usecase.GetHistoryBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryDetailVM @Inject constructor(
    private val getHistoryBinInfoUseCase: GetHistoryBinInfoUseCase
) : ViewModel() {
    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo = _binInfo.asStateFlow()

    fun getBinInfo(id: Long) {
        viewModelScope.launch {
            getHistoryBinInfoUseCase.getHistoryBinInfo(id).collectLatest {
                _binInfo.value = it
            }
        }
    }
}
