package com.github.damontecres.wholphin.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.scale
import kotlin.math.pow

/**
 * Tracks whether the startup animation has already played in this app process,
 * so it runs once per launch and not again when the activity is recreated.
 */
object NetflixxIntroState {
    var played = false
}

private const val TOTAL_MS = 2600

// The four strokes of the "xx" mark are drawn one after another
private const val STROKE_START_MS = 150f
private const val STROKE_STAGGER_MS = 110f
private const val STROKE_DURATION_MS = 380f

// The glow behind the mark fades in once the strokes are mostly drawn
private const val GLOW_START_MS = 500f
private const val GLOW_DURATION_MS = 600f

// Then the mark flies toward the viewer and the app fades in behind it
private const val ZOOM_START_MS = 1500f
private const val ZOOM_DURATION_MS = 1000f
private const val MAX_ZOOM = 30f
private const val BACKGROUND_FADE_START_MS = 1900f
private const val BACKGROUND_FADE_DURATION_MS = 550f
private const val MARK_FADE_START_MS = 2150f
private const val MARK_FADE_DURATION_MS = 400f

private val NetflixxRed = Color(0xFFE0182D)
private val ZoomEasing = CubicBezierEasing(0.7f, 0f, 0.84f, 0f)

/**
 * The Netflixx startup animation: the red "xx" mark draws itself stroke by stroke on black,
 * glows, then flies toward the viewer while the app fades in behind it.
 *
 * It is drawn entirely on a [Canvas], and should be placed on top of the app's content.
 *
 * @param onFinished called once when the animation is over and this can be removed
 */
@Composable
fun NetflixxIntro(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val progress = remember { Animatable(0f) }
    val currentOnFinished by rememberUpdatedState(onFinished)
    LaunchedEffect(Unit) {
        progress.animateTo(1f, tween(TOTAL_MS, easing = LinearEasing))
        currentOnFinished()
    }
    Canvas(modifier) {
        // Only read the animation value here so each frame is just a redraw
        val ms = progress.value * TOTAL_MS

        val backgroundAlpha = 1f - phase(ms, BACKGROUND_FADE_START_MS, BACKGROUND_FADE_DURATION_MS)
        val markAlpha = 1f - phase(ms, MARK_FADE_START_MS, MARK_FADE_DURATION_MS)
        val glowAlpha = FastOutSlowInEasing.transform(phase(ms, GLOW_START_MS, GLOW_DURATION_MS))
        val zoom = ZoomEasing.transform(phase(ms, ZOOM_START_MS, ZOOM_DURATION_MS))
        // A slow push-in while the mark draws, then the fly-through
        val pushIn = 0.94f + 0.06f * FastOutSlowInEasing.transform(phase(ms, 0f, ZOOM_START_MS))
        val markScale = pushIn * MAX_ZOOM.pow(zoom)

        drawRect(color = Color.Black, alpha = backgroundAlpha)

        // Each x is two slanted bars with flat ends, like the letters in the logo
        val markHeight = size.minDimension * 0.17f
        val xWidth = markHeight * 0.98f
        val barWidth = markHeight * 0.30f
        val gap = markHeight * 0.02f
        val left = center.x - xWidth - gap / 2f
        val top = center.y - markHeight / 2f

        scale(scale = markScale, pivot = center) {
            if (glowAlpha > 0f && markAlpha > 0f) {
                val glowRadius = markHeight * 2.6f
                drawCircle(
                    brush =
                        Brush.radialGradient(
                            colors = listOf(NetflixxRed.copy(alpha = 0.30f), Color.Transparent),
                            center = center,
                            radius = glowRadius,
                        ),
                    radius = glowRadius,
                    center = center,
                    alpha = glowAlpha * markAlpha,
                )
            }
            for (i in 0 until 4) {
                val reveal =
                    FastOutSlowInEasing.transform(
                        phase(ms, STROKE_START_MS + i * STROKE_STAGGER_MS, STROKE_DURATION_MS),
                    )
                drawBar(
                    left = if (i < 2) left else left + xWidth + gap,
                    top = top,
                    width = xWidth,
                    height = markHeight,
                    barWidth = barWidth,
                    // Strokes alternate: "\" drawn downward, then "/" drawn upward
                    downward = i % 2 == 0,
                    reveal = reveal,
                    alpha = markAlpha,
                )
            }
        }
    }
}

/**
 * How far along (0 to 1) a part of the animation is, given when it starts and how long it lasts
 */
private fun phase(
    ms: Float,
    startMs: Float,
    durationMs: Float,
): Float = ((ms - startMs) / durationMs).coerceIn(0f, 1f)

/**
 * Draws one slanted bar of an "x", revealed from its starting end by [reveal] (0 to 1)
 */
private fun DrawScope.drawBar(
    left: Float,
    top: Float,
    width: Float,
    height: Float,
    barWidth: Float,
    downward: Boolean,
    reveal: Float,
    alpha: Float,
) {
    if (reveal <= 0f || alpha <= 0f) return
    val right = left + width
    val bottom = top + height
    val path =
        Path().apply {
            if (downward) {
                moveTo(left, top)
                lineTo(left + barWidth, top)
                lineTo(right, bottom)
                lineTo(right - barWidth, bottom)
            } else {
                moveTo(right - barWidth, top)
                lineTo(right, top)
                lineTo(left + barWidth, bottom)
                lineTo(left, bottom)
            }
            close()
        }
    val clipTop = if (downward) top else bottom - height * reveal
    val clipBottom = if (downward) top + height * reveal else bottom
    clipRect(left = left, top = clipTop, right = right, bottom = clipBottom) {
        drawPath(path = path, color = NetflixxRed, alpha = alpha)
    }
}
