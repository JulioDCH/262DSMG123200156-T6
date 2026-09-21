package com.example.milima.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    onCategorySelected: (String) -> Unit
) {

    val categories = listOf(
        "☕ Cafeterías",
        "🍽️ Restaurantes",
        "🌳 Parques",
        "🛍️ Centros comerciales",
        "🏛️ Cultura"
    )

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(
                start = 24.dp,
                top = 30.dp,
                end = 24.dp,
                bottom = 32.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Mi Lima 🇵🇪",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Descubre lugares y actividades para disfrutar en Lima.",
            style = MaterialTheme.typography.bodyLarge
        )

        when (windowWidthSizeClass) {

            WindowWidthSizeClass.Expanded -> {

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    categories.chunked(2).forEach { rowCategories ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            rowCategories.forEach { categoryWithIcon ->

                                val category =
                                    categoryWithIcon.substringAfter(" ")

                                Card(
                                    onClick = {
                                        onCategorySelected(category)
                                    },
                                    modifier = Modifier.weight(1f)
                                ) {

                                    Text(
                                        text = categoryWithIcon,
                                        style = MaterialTheme.typography.titleLarge,
                                        modifier = Modifier.padding(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            WindowWidthSizeClass.Medium,
            WindowWidthSizeClass.Compact -> {

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    categories.forEach { categoryWithIcon ->

                        val category =
                            categoryWithIcon.substringAfter(" ")

                        Card(
                            onClick = {
                                onCategorySelected(category)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = categoryWithIcon,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}