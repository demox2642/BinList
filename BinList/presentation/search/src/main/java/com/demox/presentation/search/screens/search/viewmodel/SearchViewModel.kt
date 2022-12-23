package com.demox.presentation.search.screens.search.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demox.search.model.BinInfo
import com.demox.search.usecase.GetBinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: GetBinListUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo = _binInfo.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            searchUseCase.getBinList("45717360").collectLatest {
                Log.e("VM", "$it")
                _binInfo.value = it
            }
        }
    }
}
