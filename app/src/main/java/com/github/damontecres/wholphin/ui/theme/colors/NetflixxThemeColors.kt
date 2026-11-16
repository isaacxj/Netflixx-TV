package com.github.damontecres.wholphin.ui.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme
import com.github.damontecres.wholphin.ui.theme.ThemeColors

// Netflixx: near-black with the red of the netflixx logo as the accent
// (focus rings, progress and seek bars, selected tabs).
val NetflixxThemeColors =
    object : ThemeColors {
        val primaryLight = Color(0xFFB3121F)
        val onPrimaryLight = Color(0xFFFFFFFF)
        val primaryContainerLight = Color(0xFFFFDAD8)
        val onPrimaryContainerLight = Color(0xFF410006)
        val secondaryLight = Color(0xFF5F5E5E)
        val onSecondaryLight = Color(0xFFFFFFFF)
        val secondaryContainerLight = Color(0xFFE5E2E1)
        val onSecondaryContainerLight = Color(0xFF1C1B1B)
        val tertiaryLight = Color(0xFF8E0F1A)
        val onTertiaryLight = Color(0xFFFFFFFF)
        val tertiaryContainerLight = Color(0xFFFFDAD8)
        val onTertiaryContainerLight = Color(0xFF410006)
        val errorLight = Color(0xFFBA1A1A)
        val onErrorLight = Color(0xFFFFFFFF)
        val errorContainerLight = Color(0xFFFFDAD6)
        val onErrorContainerLight = Color(0xFF93000A)
        val backgroundLight = Color(0xFFFFFBFA)
        val onBackgroundLight = Color(0xFF1C1B1B)
        val surfaceLight = Color(0xFFFFFBFA)
        val onSurfaceLight = Color(0xFF1C1B1B)
        val surfaceVariantLight = Color(0xFFE7E1E0)
        val onSurfaceVariantLight = Color(0xFF494645)
        val outlineLight = Color(0xFF7A7675)
        val outlineVariantLight = Color(0xFFCBC5C4)
        val scrimLight = Color(0xFF000000)
        val inverseSurfaceLight = Color(0xFF313030)
        val inverseOnSurfaceLight = Color(0xFFF4F0EF)
        val inversePrimaryLight = Color(0xFFFFB3B0)
        val surfaceDimLight = Color(0xFFDDD9D8)
        val surfaceBrightLight = Color(0xFFFFFBFA)
        val surfaceContainerLowestLight = Color(0xFFFFFFFF)
        val surfaceContainerLowLight = Color(0xFFF7F3F2)
        val surfaceContainerLight = Color(0xFFF1EDEC)
        val surfaceContainerHighLight = Color(0xFFEBE7E6)
        val surfaceContainerHighestLight = Color(0xFFE5E2E1)

        val primaryDark = Color(0xFFE0182D)
        val onPrimaryDark = Color(0xFFFFFFFF)
        val primaryContainerDark = Color(0xFF5C0A12)
        val onPrimaryContainerDark = Color(0xFFFFDAD8)
        val secondaryDark = Color(0xFFC9C6C5)
        val onSecondaryDark = Color(0xFF1E1E25)
        val secondaryContainerDark = Color(0xFF2E2E36)
        val onSecondaryContainerDark = Color(0xFFECEAE8)
        val tertiaryDark = Color(0xFFFF5A66)
        val onTertiaryDark = Color(0xFF2A0005)
        val tertiaryContainerDark = Color(0xFF6B0E17)
        val onTertiaryContainerDark = Color(0xFFFFDAD8)
        val errorDark = Color(0xFFFFB4AB)
        val onErrorDark = Color(0xFF690005)
        val errorContainerDark = Color(0xFF93000A)
        val onErrorContainerDark = Color(0xFFFFDAD6)
        val backgroundDark = Color(0xFF0B0B0E)
        val onBackgroundDark = Color(0xFFF2F0EB)
        val surfaceDark = backgroundDark
        val onSurfaceDark = Color(0xFFF2F0EB)
        val surfaceVariantDark = Color(0xFF26262D)
        val onSurfaceVariantDark = Color(0xFFC9C5BC)
        val outlineDark = Color(0xFF8E8A82)
        val outlineVariantDark = Color(0xFF34343C)
        val scrimDark = Color(0xFF000000)
        val inverseSurfaceDark = Color(0xFFF2F0EB)
        val inverseOnSurfaceDark = Color(0xFF1E1E25)
        val inversePrimaryDark = Color(0xFFE0182D)
        val surfaceDimDark = Color(0xFF0B0B0E)
        val surfaceBrightDark = Color(0xFF34343C)
        val surfaceContainerLowestDark = Color(0xFF070709)
        val surfaceContainerLowDark = Color(0xFF121216)
        val surfaceContainerDark = Color(0xFF16161B)
        val surfaceContainerHighDark = Color(0xFF1E1E25)
        val surfaceContainerHighestDark = Color(0xFF282830)

        override val lightSchemeMaterial: ColorScheme =
            androidx.compose.material3.lightColorScheme(
                primary = primaryLight,
                onPrimary = onPrimaryLight,
                primaryContainer = primaryContainerLight,
                onPrimaryContainer = onPrimaryContainerLight,
                secondary = secondaryLight,
                onSecondary = onSecondaryLight,
                secondaryContainer = secondaryContainerLight,
                onSecondaryContainer = onSecondaryContainerLight,
                tertiary = tertiaryLight,
                onTertiary = onTertiaryLight,
                tertiaryContainer = tertiaryContainerLight,
                onTertiaryContainer = onTertiaryContainerLight,
                error = errorLight,
                onError = onErrorLight,
                errorContainer = errorContainerLight,
                onErrorContainer = onErrorContainerLight,
                background = backgroundLight,
                onBackground = onBackgroundLight,
                surface = surfaceLight,
                onSurface = onSurfaceLight,
                surfaceVariant = surfaceVariantLight,
                onSurfaceVariant = onSurfaceVariantLight,
                scrim = scrimLight,
                inverseSurface = inverseSurfaceLight,
                inverseOnSurface = inverseOnSurfaceLight,
                inversePrimary = inversePrimaryLight,
            )

        override val lightScheme =
            lightColorScheme(
                primary = primaryLight,
                onPrimary = onPrimaryLight,
                primaryContainer = primaryContainerLight,
                onPrimaryContainer = onPrimaryContainerLight,
                secondary = secondaryLight,
                onSecondary = onSecondaryLight,
                secondaryContainer = secondaryContainerLight,
                onSecondaryContainer = onSecondaryContainerLight,
                tertiary = tertiaryLight,
                onTertiary = onTertiaryLight,
                tertiaryContainer = tertiaryContainerLight,
                onTertiaryContainer = onTertiaryContainerLight,
                error = errorLight,
                onError = onErrorLight,
                errorContainer = errorContainerLight,
                onErrorContainer = onErrorContainerLight,
                background = backgroundLight,
                onBackground = onBackgroundLight,
                surface = surfaceLight,
                onSurface = onSurfaceLight,
                surfaceVariant = surfaceVariantLight,
                onSurfaceVariant = onSurfaceVariantLight,
                scrim = scrimLight,
                inverseSurface = inverseSurfaceLight,
                inverseOnSurface = inverseOnSurfaceLight,
                inversePrimary = inversePrimaryLight,
                border = inversePrimaryLight,
            )

        override val darkSchemeMaterial =
            androidx.compose.material3.darkColorScheme(
                primary = primaryDark,
                onPrimary = onPrimaryDark,
                primaryContainer = primaryContainerDark,
                onPrimaryContainer = onPrimaryContainerDark,
                secondary = secondaryDark,
                onSecondary = onSecondaryDark,
                secondaryContainer = secondaryContainerDark,
                onSecondaryContainer = onSecondaryContainerDark,
                tertiary = tertiaryDark,
                onTertiary = onTertiaryDark,
                tertiaryContainer = tertiaryContainerDark,
                onTertiaryContainer = onTertiaryContainerDark,
                error = errorDark,
                onError = onErrorDark,
                errorContainer = errorContainerDark,
                onErrorContainer = onErrorContainerDark,
                background = backgroundDark,
                onBackground = onBackgroundDark,
                surface = surfaceDark,
                onSurface = onSurfaceDark,
                surfaceVariant = surfaceVariantDark,
                onSurfaceVariant = onSurfaceVariantDark,
                scrim = scrimDark,
                inverseSurface = inverseSurfaceDark,
                inverseOnSurface = inverseOnSurfaceDark,
                inversePrimary = inversePrimaryDark,
            )

        override val darkScheme =
            darkColorScheme(
                primary = primaryDark,
                onPrimary = onPrimaryDark,
                primaryContainer = primaryContainerDark,
                onPrimaryContainer = onPrimaryContainerDark,
                secondary = secondaryDark,
                onSecondary = onSecondaryDark,
                secondaryContainer = secondaryContainerDark,
                onSecondaryContainer = onSecondaryContainerDark,
                tertiary = tertiaryDark,
                onTertiary = onTertiaryDark,
                tertiaryContainer = tertiaryContainerDark,
                onTertiaryContainer = onTertiaryContainerDark,
                error = errorDark,
                onError = onErrorDark,
                errorContainer = errorContainerDark,
                onErrorContainer = onErrorContainerDark,
                background = backgroundDark,
                onBackground = onBackgroundDark,
                surface = surfaceDark,
                onSurface = onSurfaceDark,
                surfaceVariant = surfaceVariantDark,
                onSurfaceVariant = onSurfaceVariantDark,
                scrim = scrimDark,
                inverseSurface = inverseSurfaceDark,
                inverseOnSurface = inverseOnSurfaceDark,
                inversePrimary = inversePrimaryDark,
                border = inversePrimaryDark,
            )
    }
