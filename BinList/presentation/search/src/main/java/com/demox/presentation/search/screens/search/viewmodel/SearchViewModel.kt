package com.demox.presentation.search.screens.search.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demox.search.usecase.GetBinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: GetBinListUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            val test = searchUseCase.getBinList("45717360")
            Log.e("VM", "$test")
        }
    }
}
