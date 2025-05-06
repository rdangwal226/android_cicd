package com.exmaple.localization.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SharedMainViewModel : ViewModel() {
    //State
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()


    //Event

    fun onEvent(event:UiEvent){
        when(event){
            is UiEvent.Increment -> _state.update { it.copy(counter = it.counter + 1) }
            is UiEvent.Decrement -> _state.update { it.copy(counter = it.counter - 1) }
        }
    }

    data class UiState(val counter: Int = 0)

    sealed class UiEvent {
        object Increment : UiEvent()
        object Decrement : UiEvent()
    }
}