package com.example.socialmedia.android.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import com.example.socialmedia.android.ui.screens.uii.LargeSpacing
import com.example.socialmedia.android.ui.screens.uii.MediumSpacing
import com.example.socialmedia.android.ui.screens.uii.SmallSpacing

val Shapes = Shapes(
    small = RoundedCornerShape(SmallSpacing),
    medium = RoundedCornerShape(MediumSpacing),
    large = RoundedCornerShape(LargeSpacing)
)