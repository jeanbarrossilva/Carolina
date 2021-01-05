package com.jeanbarrossilva.carolina.extension

import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color as ComposeColor

object ColorX {
    fun Color(hex: String) = ComposeColor(AndroidColor.parseColor(hex))
}