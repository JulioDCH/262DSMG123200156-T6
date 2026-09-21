package com.example.milima.ui

import com.example.milima.data.CityRepository
import androidx.lifecycle.ViewModel
import com.example.milima.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MiLimaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        MiLimaUiState(
            places = CityRepository.places
        )
    )

    val uiState: StateFlow<MiLimaUiState> = _uiState.asStateFlow()

    fun selectCategory(category: String) {
        _uiState.value = _uiState.value.copy(
            selectedCategory = category
        )
    }

    fun selectPlace(place: Place) {
        _uiState.value = _uiState.value.copy(
            selectedPlace = place
        )
    }
}