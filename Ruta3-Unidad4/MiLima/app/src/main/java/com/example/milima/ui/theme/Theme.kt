package com.example.milima.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = Color(0xFF1976A8),
    onPrimary = Color.White,

    secondary = Color(0xFF4F8FB5),
    onSecondary = Color.White,

    tertiary = Color(0xFF5C7FA3),
    onTertiary = Color.White,

    background = Color(0xFFF7FAFC),
    onBackground = Color(0xFF17212B),

    surface = Color.White,
    onSurface = Color(0xFF17212B)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8CC8EE),
    onPrimary = Color(0xFF00344D),

    secondary = Color(0xFFA8CCE3),
    onSecondary = Color(0xFF123447),

    tertiary = Color(0xFFB4CAE5),
    onTertiary = Color(0xFF20364D)
)

@Composable
fun MiLimaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}