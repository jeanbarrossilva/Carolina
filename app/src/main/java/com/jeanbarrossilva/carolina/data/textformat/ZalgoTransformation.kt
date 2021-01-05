package com.jeanbarrossilva.carolina.data.textformat

import com.jeanbarrossilva.carolina.data.Zalgo

enum class ZalgoTransformation(override var title: String) : Transformation, Zalgo {
    STANDARD("Zalgo") {
        override val numberOfVerticalCombiningCharacters = 1
        override val numberOfHorizontalCombiningCharacters = 1
    },
    POSSESSED("Possessed") {
        override val numberOfHorizontalCombiningCharacters = 2
        override val numberOfVerticalCombiningCharacters = 2
    };

    override fun convert(text: String) = text.withVerticalCombiningCharacters.withHorizontalCombiningCharacters
}