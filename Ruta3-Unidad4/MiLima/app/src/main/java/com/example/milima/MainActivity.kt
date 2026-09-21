package com.example.milima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.milima.ui.MiLimaApp
import com.example.milima.ui.theme.MiLimaTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MiLimaTheme {

                val windowSizeClass =
                    calculateWindowSizeClass(this)

                MiLimaApp(
                    windowSizeClass = windowSizeClass
                )
            }
        }
    }
}