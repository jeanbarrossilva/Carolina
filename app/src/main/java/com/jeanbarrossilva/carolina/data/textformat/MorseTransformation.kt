package com.jeanbarrossilva.carolina.data.textformat

import com.jeanbarrossilva.carolina.data.Morse

enum class MorseTransformation(override var title: String) : Transformation, Morse {
    STANDARD("Morse") {
        override fun convert(text: String) = text.toMorseCode()
    }
}