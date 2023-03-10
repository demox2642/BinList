package com.demox.presentation.search.screens.search.screens.main.viewmodel

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

    private val _errorDialogState = MutableStateFlow(false)
    val errorDialogState = _errorDialogState.asStateFlow()

    private val _noBin = MutableStateFlow(false)
    val noBin = _noBin.asStateFlow()

    private val _binSearchText = MutableStateFlow("")
    val binSearchText = _binSearchText.asStateFlow()

    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo = _binInfo.asStateFlow()

    private val _buttonState = MutableStateFlow(true)
    val buttonState = _buttonState.asStateFlow()

    fun onBinSearchTextChange(text: String) {
        if (text.length <= 16) {
            _binSearchText.value = text.replace("-", "").replace("*", "").replace("+", "").replace(".", "").replace(",", "").replace(" ", "")
        }
    }

    fun searchBinInfo() {
        if (_binSearchText.value.length < 8) {
            _errorDialogState.value = true
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                searchUseCase.getBinList(_binSearchText.value).collectLatest {
                    Log.e("VM", "$it")
                    _binInfo.value = it
                    if (it == null) {
                        _noBin.value = true
                    }
                }
            }
        }
    }

    fun noBinDialogDis() {
        _binSearchText.value = ""
        _noBin.value = false
    }

    fun noErrorDialog() {
        _errorDialogState.value = false
    }
}
