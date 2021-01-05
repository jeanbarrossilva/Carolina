package com.jeanbarrossilva.carolina.data.textformat

import com.jeanbarrossilva.carolina.extension.CharX.isPunctuation
import com.jeanbarrossilva.carolina.extension.StringX.decapitalized
import com.jeanbarrossilva.carolina.extension.StringX.mapJoiningWith

enum class HashtagsTransformation(description: String) : Transformation {
    STANDARD("Hashtags") {
        override fun convert(text: String) = text.split(' ').let { words ->
            words.joinToString(separator = "") { word -> if (word == words.first()) "#$word" else " #$word" }
        }
    },
    WITHOUT_PUNCTUATION("Without punctuation") {
        override fun convert(text: String) = STANDARD.convert(text).mapJoiningWith { if (it.isPunctuation()) "" else it }
    },
    WITHOUT_PUNCTUATION_WITH_LINE_BREAKS("Without punctuation with line breaks") {
        override fun convert(text: String) = WITHOUT_PUNCTUATION.convert(text).replace(' ', '\n')
    },
    WITHOUT_PUNCTUATION_WITH_LINE_BREAKS_LOWER_CASED("Without punctuation lower-cased") {
        override fun convert(text: String): String = StandardTransformation.LOWER_CASED.convert(WITHOUT_PUNCTUATION_WITH_LINE_BREAKS.convert(text))
    };

    override var title = "Hashtags ${description.decapitalized}"
}