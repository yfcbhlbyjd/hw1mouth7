package com.geektech.hw1mouth7.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.hw1mouth7.domain.utils.Resource
import com.geektech.hw1mouth7.domain.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    protected fun <T> Flow<com.geektech.hw1mouth7.domain.utils.Resource<T>>.collectFlow(_state: MutableStateFlow<com.geektech.hw1mouth7.domain.utils.UIState<T>>) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is com.geektech.hw1mouth7.domain.utils.Resource.Error -> {
                        _state.value = com.geektech.hw1mouth7.domain.utils.UIState.Error(it.massage!!)
                    }
                    is com.geektech.hw1mouth7.domain.utils.Resource.Loading -> {
                        _state.value = com.geektech.hw1mouth7.domain.utils.UIState.Loading()
                    }
                    is com.geektech.hw1mouth7.domain.utils.Resource.Success -> {
                        if (it.data != null) {
                            _state.value = com.geektech.hw1mouth7.domain.utils.UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}