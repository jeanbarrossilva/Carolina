package com.jeanbarrossilva.carolina.data

import com.jeanbarrossilva.carolina.data.textformat.*
import com.jeanbarrossilva.carolina.extension.ListX.move

class TransformationGroup<T : Transformation>(val title: String = "", private val formats: Array<T>) {
    val hasTitle = title.isNotBlank()

    fun getFormats() = formats.toList().sortedBy { it.title }.move({ format: Transformation -> format == StandardTransformation.NORMAL } to 0)

    companion object {
        val values = listOf(
            TransformationGroup(formats = StandardTransformation.values()),
            TransformationGroup("Fonts", FontTransformation.values),
            TransformationGroup("Hashtags", HashtagsTransformation.values()),
            TransformationGroup("Morse", MorseTransformation.values()),
            TransformationGroup("Space replacement", SpaceReplacementTransformation.values()),
            TransformationGroup("Zalgo", ZalgoTransformation.values())
        )
    }
}