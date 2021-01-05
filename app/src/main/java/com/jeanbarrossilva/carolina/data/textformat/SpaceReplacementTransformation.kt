package com.jeanbarrossilva.carolina.data.textformat

import com.jeanbarrossilva.carolina.data.Emoji
import com.jeanbarrossilva.carolina.extension.CharX.leftArrow

enum class SpaceReplacementTransformation(private val replacement: String) : Transformation {
    CLAPPING_HANDS(Emoji.clappingHands),
    DOT("."),
    FACE_WITH_TEARS_OF_JOY(Emoji.faceWithTearsOfJoy);

    override var title = "Space $leftArrow $replacement"

    override fun convert(text: String) = text.replace(" ", replacement)
}