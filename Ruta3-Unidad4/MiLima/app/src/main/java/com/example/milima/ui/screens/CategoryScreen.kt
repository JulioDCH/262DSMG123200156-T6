package com.example.milima.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.milima.model.Place

@Composable
fun CategoryScreen(
    category: String,
    places: List<Place>,
    windowWidthSizeClass: WindowWidthSizeClass,
    onPlaceSelected: (Place) -> Unit,
    onBack: () -> Unit
) {

    val filteredPlaces = places.filter {
        it.category == category
    }

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

        Button(
            onClick = onBack
        ) {
            Text("← Atrás")
        }

        Text(
            text = category,
            style = MaterialTheme.typography.headlineLarge
        )

        if (filteredPlaces.isEmpty()) {

            Text(
                text = "No hay lugares disponibles en esta categoría.",
                style = MaterialTheme.typography.bodyLarge
            )

        } else {

            Text(
                text = "${filteredPlaces.size} lugares para descubrir",
                style = MaterialTheme.typography.bodyLarge
            )

            when (windowWidthSizeClass) {

                WindowWidthSizeClass.Expanded -> {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        filteredPlaces.chunked(2).forEach { rowPlaces ->

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {

                                rowPlaces.forEach { place ->

                                    Card(
                                        onClick = {
                                            onPlaceSelected(place)
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) {

                                        Column(
                                            modifier = Modifier.padding(20.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {

                                            Image(
                                                painter = painterResource(
                                                    id = place.imageRes
                                                ),
                                                contentDescription = place.name,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(180.dp),
                                                contentScale = ContentScale.Crop
                                            )

                                            Text(
                                                text = place.name,
                                                style = MaterialTheme.typography.titleLarge
                                            )

                                            Text(
                                                text = place.description,
                                                style = MaterialTheme.typography.bodyMedium
                                            )

                                            Text(
                                                text = "Ver detalles →",
                                                style = MaterialTheme.typography.labelLarge
                                            )
                                        }
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

                        filteredPlaces.forEach { place ->

                            Card(
                                onClick = {
                                    onPlaceSelected(place)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Column(
                                    modifier = Modifier.padding(20.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {

                                    Image(
                                        painter = painterResource(
                                            id = place.imageRes
                                        ),
                                        contentDescription = place.name,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(180.dp),
                                        contentScale = ContentScale.Crop
                                    )

                                    Text(
                                        text = place.name,
                                        style = MaterialTheme.typography.titleLarge
                                    )

                                    Text(
                                        text = place.description,
                                        style = MaterialTheme.typography.bodyMedium
                                    )

                                    Text(
                                        text = "Ver detalles →",
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}