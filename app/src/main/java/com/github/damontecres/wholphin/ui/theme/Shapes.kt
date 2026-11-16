package com.github.damontecres.wholphin.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Shapes

/**
 * The Netflixx look uses squared-off corners everywhere instead of Material's pills and circles
 */
object NetflixxShapes {
    /** Buttons, text fields, list rows and other controls */
    val control = RoundedCornerShape(6.dp)

    /** Dialogs, panels and profile tiles */
    val panel = RoundedCornerShape(8.dp)
}

val AppShapes =
    Shapes(
        extraSmall = RoundedCornerShape(4.dp),
        small = RoundedCornerShape(6.dp),
        medium = RoundedCornerShape(6.dp),
        large = RoundedCornerShape(8.dp),
        extraLarge = RoundedCornerShape(8.dp),
    )

val AppShapesMaterial =
    androidx.compose.material3.Shapes(
        extraSmall = RoundedCornerShape(4.dp),
        small = RoundedCornerShape(6.dp),
        medium = RoundedCornerShape(6.dp),
        large = RoundedCornerShape(8.dp),
        extraLarge = RoundedCornerShape(8.dp),
    )
