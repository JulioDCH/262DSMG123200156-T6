package com.example.milima.ui

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.milima.ui.screens.CategoryScreen
import com.example.milima.ui.screens.DetailScreen
import com.example.milima.ui.screens.HomeScreen

@Composable
fun MiLimaApp(
    windowSizeClass: WindowSizeClass
) {

    val navController = rememberNavController()

    val viewModel: MiLimaViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        NavHost(
            navController = navController,
            startDestination = "home"
        ) {

            composable("home") {

                HomeScreen(
                    windowWidthSizeClass =
                        windowSizeClass.widthSizeClass,

                    onCategorySelected = { category ->

                        viewModel.selectCategory(category)

                        navController.navigate(
                            "category/${Uri.encode(category)}"
                        )
                    }
                )
            }

            composable("category/{category}") { backStackEntry ->

                val category =
                    Uri.decode(
                        backStackEntry.arguments?.getString("category") ?: ""
                    )

                CategoryScreen(
                    category = category,
                    places = uiState.places,

                    windowWidthSizeClass =
                        windowSizeClass.widthSizeClass,

                    onPlaceSelected = { place ->

                        viewModel.selectPlace(place)

                        navController.navigate(
                            "detail/${place.id}"
                        )
                    },

                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable("detail/{placeId}") {

                val place = uiState.selectedPlace

                if (place != null) {

                    DetailScreen(
                        place = place,

                        windowWidthSizeClass =
                            windowSizeClass.widthSizeClass,

                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}