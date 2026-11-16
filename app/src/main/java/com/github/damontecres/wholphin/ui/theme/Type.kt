package com.github.damontecres.wholphin.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.tv.material3.Typography
import com.github.damontecres.wholphin.R

/**
 * Inter, used for all text in the app in place of the system font
 */
val Inter =
    FontFamily(
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_medium, FontWeight.Medium),
        Font(R.font.inter_semibold, FontWeight.SemiBold),
        Font(R.font.inter_bold, FontWeight.Bold),
    )

private val tvDefaults = Typography()

val AppTypography =
    Typography(
        displayLarge = tvDefaults.displayLarge.copy(fontFamily = Inter),
        displayMedium = tvDefaults.displayMedium.copy(fontFamily = Inter),
        displaySmall = tvDefaults.displaySmall.copy(fontFamily = Inter),
        headlineLarge = tvDefaults.headlineLarge.copy(fontFamily = Inter),
        headlineMedium = tvDefaults.headlineMedium.copy(fontFamily = Inter),
        headlineSmall = tvDefaults.headlineSmall.copy(fontFamily = Inter),
        titleLarge = tvDefaults.titleLarge.copy(fontFamily = Inter),
        titleMedium = tvDefaults.titleMedium.copy(fontFamily = Inter),
        titleSmall = tvDefaults.titleSmall.copy(fontFamily = Inter),
        bodyLarge = tvDefaults.bodyLarge.copy(fontFamily = Inter),
        bodyMedium = tvDefaults.bodyMedium.copy(fontFamily = Inter),
        bodySmall = tvDefaults.bodySmall.copy(fontFamily = Inter),
        labelLarge = tvDefaults.labelLarge.copy(fontFamily = Inter),
        labelMedium = tvDefaults.labelMedium.copy(fontFamily = Inter),
        labelSmall = tvDefaults.labelSmall.copy(fontFamily = Inter),
    )

private val materialDefaults = androidx.compose.material3.Typography()

/**
 * The same typeface for the few places that use the non-TV Material components
 */
val AppTypographyMaterial =
    androidx.compose.material3.Typography(
        displayLarge = materialDefaults.displayLarge.copy(fontFamily = Inter),
        displayMedium = materialDefaults.displayMedium.copy(fontFamily = Inter),
        displaySmall = materialDefaults.displaySmall.copy(fontFamily = Inter),
        headlineLarge = materialDefaults.headlineLarge.copy(fontFamily = Inter),
        headlineMedium = materialDefaults.headlineMedium.copy(fontFamily = Inter),
        headlineSmall = materialDefaults.headlineSmall.copy(fontFamily = Inter),
        titleLarge = materialDefaults.titleLarge.copy(fontFamily = Inter),
        titleMedium = materialDefaults.titleMedium.copy(fontFamily = Inter),
        titleSmall = materialDefaults.titleSmall.copy(fontFamily = Inter),
        bodyLarge = materialDefaults.bodyLarge.copy(fontFamily = Inter),
        bodyMedium = materialDefaults.bodyMedium.copy(fontFamily = Inter),
        bodySmall = materialDefaults.bodySmall.copy(fontFamily = Inter),
        labelLarge = materialDefaults.labelLarge.copy(fontFamily = Inter),
        labelMedium = materialDefaults.labelMedium.copy(fontFamily = Inter),
        labelSmall = materialDefaults.labelSmall.copy(fontFamily = Inter),
    )
