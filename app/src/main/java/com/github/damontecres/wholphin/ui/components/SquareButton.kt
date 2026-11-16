package com.github.damontecres.wholphin.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.tv.material3.ButtonColors
import androidx.tv.material3.ButtonDefaults
import com.github.damontecres.wholphin.ui.theme.NetflixxShapes
import androidx.tv.material3.Button as TvButton

/**
 * The stock TV [androidx.tv.material3.Button], but with the Netflixx squared-off corners instead of a pill
 */
@Composable
fun SquareButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.colors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit,
) = TvButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    shape = ButtonDefaults.shape(shape = NetflixxShapes.control),
    colors = colors,
    contentPadding = contentPadding,
    interactionSource = interactionSource,
    content = content,
)
