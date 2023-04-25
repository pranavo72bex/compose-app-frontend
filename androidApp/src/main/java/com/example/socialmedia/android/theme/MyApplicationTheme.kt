package com.example.socialmedia.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.socialmedia.android.ui.screens.uii.DarkColors
import com.example.socialmedia.android.ui.screens.uii.LightColors
import com.example.socialmedia.android.theme.Shapes
import com.example.socialmedia.android.ui.screens.uii.Typography

@Composable
fun SocialAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}
