package com.jeanbarrossilva.carolina.extension

import java.util.*

object StringX {
    val String.capitalized get() = capitalize(Locale.ROOT)
    val String.decapitalized get() = decapitalize(Locale.ROOT)
    val String.lowerCased get() = toLowerCase(Locale.ROOT)
    val String.upperCased get() = toUpperCase(Locale.ROOT)

    fun <T> String.mapJoiningWith(separator: String = "", block: (Char) -> T) = map { block(it) }.joinToString(separator)
}