package com.jeanbarrossilva.carolina.data.textformat

import android.util.Base64
import com.jeanbarrossilva.carolina.extension.CharX.combiningLongStrokeOverlay
import com.jeanbarrossilva.carolina.extension.CharX.fullBlock
import com.jeanbarrossilva.carolina.extension.CharX.isPunctuation
import com.jeanbarrossilva.carolina.extension.CharX.plus
import com.jeanbarrossilva.carolina.extension.StringX.capitalized
import com.jeanbarrossilva.carolina.extension.StringX.lowerCased
import com.jeanbarrossilva.carolina.extension.StringX.mapJoiningWith
import com.jeanbarrossilva.carolina.extension.StringX.upperCased

enum class StandardTransformation(override var title: String) : Transformation {
    NORMAL("Normal") {
        override fun convert(text: String) = text
    },
    ASCII("ASCII") {
        override fun convert(text: String) = text.mapJoiningWith(" ") { it.toInt() }
    },
    BASE64("Base64") {
        override fun convert(text: String) = Base64.encodeToString(text.toByteArray(), 0) ?: text
    },
    BINARY("Binary") {
        override fun convert(text: String) = text.mapJoiningWith(" ") { Integer.toBinaryString(it.toInt()) }
    },
    DOUBLE_SPACED("Double-spaced") {
        override fun convert(text: String) = text.replace(" ", "  ")
    },
    FULL_STOPS("Full stops") {
        override fun convert(text: String) = text.split(' ').joinToString(separator = " ") { word ->
            if (word.lastOrNull()?.isPunctuation() == true) word.replace(word.last(), '.').capitalized else "${word.capitalized}."
        }
    },
    HEXADECIMAL("Hexadecimal") {
        override fun convert(text: String) = text.mapJoiningWith(" ") { Integer.toHexString(it.toInt()) }
    },
    LOWER_CASED("Lower-cased") {
        override fun convert(text: String) = text.lowerCased
    },
    REVERSED("Reversed") {
        override fun convert(text: String) = text.reversed()
    },
    SECRET_MESSAGE("Secret message") {
        override fun convert(text: String) = text.mapJoiningWith { if (!it.isWhitespace()) fullBlock else it }
    },
    SPACED("Spaced") {
        override fun convert(text: String) = text.toList().joinToString(separator = " ")
    },
    STRIKETHROUGH("Strikethrough") {
        override fun convert(text: String) = text.mapJoiningWith { if (!it.isWhitespace()) it.plus(combiningLongStrokeOverlay) else it }
    },
    UPPER_CASED("Upper-cased") {
        override fun convert(text: String) = text.upperCased
    }
}