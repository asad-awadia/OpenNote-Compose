package com.yangdai.opennote.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


@Composable
fun OpenNoteTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    color: Int = 0,
    content: @Composable () -> Unit
) {
    val colorScheme = when (color) {
        1 -> if (darkMode) DarkPurpleColors else LightPurpleColors
        2 -> if (darkMode) DarkBlueColors else LightBlueColors
        3 -> if (darkMode) DarkGreenColors else LightGreenColors
        4 -> if (darkMode) DarkOrangeColors else LightOrangeColors
        5 -> if (darkMode) DarkRedColors else LightRedColors

        else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val context = LocalContext.current
            if (darkMode) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        } else {
            if (darkMode) DarkPurpleColors else LightPurpleColors
        }
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkMode
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
