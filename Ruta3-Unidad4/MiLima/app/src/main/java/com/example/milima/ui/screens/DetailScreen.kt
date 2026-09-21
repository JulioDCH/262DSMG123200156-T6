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
fun DetailScreen(
    place: Place,
    windowWidthSizeClass: WindowWidthSizeClass,
    onBack: () -> Unit
) {

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
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Button(
            onClick = onBack
        ) {
            Text("← Atrás")
        }

        when (windowWidthSizeClass) {

            WindowWidthSizeClass.Expanded -> {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    Image(
                        painter = painterResource(id = place.imageRes),
                        contentDescription = place.name,
                        modifier = Modifier
                            .weight(1f)
                            .height(360.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Text(
                            text = place.name,
                            style = MaterialTheme.typography.headlineLarge
                        )

                        Text(
                            text = place.category,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier.padding(24.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {

                                Text(
                                    text = "Sobre este lugar",
                                    style = MaterialTheme.typography.titleLarge
                                )

                                Text(
                                    text = place.description,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }

            WindowWidthSizeClass.Medium,
            WindowWidthSizeClass.Compact -> {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Image(
                        painter = painterResource(id = place.imageRes),
                        contentDescription = place.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = place.category,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier.padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            Text(
                                text = "Sobre este lugar",
                                style = MaterialTheme.typography.titleLarge
                            )

                            Text(
                                text = place.description,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}