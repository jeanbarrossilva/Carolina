package com.jeanbarrossilva.carolina.ui.default

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.asFontFamily
import androidx.compose.ui.text.font.font
import com.jeanbarrossilva.carolina.R
import com.jeanbarrossilva.carolina.extension.ColorX.Color

object CarolinaTheme {
    private val typography = Typography(FontFamily.robotoSlab)

    object Color {
        private val primary = Color("#FF73FF")
        private val primaryVariant = Color("#7B2CBF")
        private val secondary = Color("#FF0A54")

        object Palette {
            private val light = lightColors(primary, primaryVariant, secondary)
            private val dark = darkColors(primary, primaryVariant, secondary)

            @Composable
            fun dynamic() = if (isSystemInDarkTheme()) dark else light
        }
    }

    object FontFamily {
        val robotoSlab = font(R.font.roboto_slab).asFontFamily()
    }

    @Composable
    private fun Get(content: @Composable () -> Unit) {
        MaterialTheme(Color.Palette.dynamic(), typography, content = content)
    }

    @Composable
    fun Wrap(content: @Composable () -> Unit) {
        Get(content)
    }

    @Composable
    fun Fill(content: @Composable () -> Unit) {
        Get {
            Surface(
                Modifier.fillMaxSize(),
                content = content
            )
        }
    }
}