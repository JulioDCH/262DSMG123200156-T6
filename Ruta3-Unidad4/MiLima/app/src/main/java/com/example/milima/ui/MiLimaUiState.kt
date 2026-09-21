package com.example.milima.ui

import com.example.milima.model.Place

data class MiLimaUiState(
    val places: List<Place> = emptyList(),
    val selectedCategory: String? = null,
    val selectedPlace: Place? = null
)