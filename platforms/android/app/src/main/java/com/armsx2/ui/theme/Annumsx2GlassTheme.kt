package com.armsx2.ui.theme

enum class Annumsx2GlassMode { Standard, OledGlass, ClassicGlass }

data class Annumsx2GlassSpec(
    val oledBlack: Boolean,
    val surfaceAlpha: Float,
    val blurDp: Float,
    val highlightAlpha: Float
)

object Annumsx2GlassTheme {
    fun spec(mode: Annumsx2GlassMode, lowEndDevice: Boolean): Annumsx2GlassSpec {
        val requested = when (mode) {
            Annumsx2GlassMode.Standard -> Annumsx2GlassSpec(false, 1.0f, 0f, 0f)
            Annumsx2GlassMode.OledGlass -> Annumsx2GlassSpec(true, .72f, 18f, .14f)
            Annumsx2GlassMode.ClassicGlass -> Annumsx2GlassSpec(false, .78f, 14f, .20f)
        }
        return if (lowEndDevice && mode != Annumsx2GlassMode.Standard)
            requested.copy(blurDp = minOf(requested.blurDp, 6f))
        else requested
    }
}
