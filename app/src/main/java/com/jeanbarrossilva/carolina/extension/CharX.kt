package com.jeanbarrossilva.carolina.extension

object CharX {
    const val combiningLongStrokeOverlay = '\u0336'
    const val fullBlock = '\u2588'
    const val leftArrow = '→'

    fun Char.isPunctuation() = this in arrayOf('.', ',', ';', '!', '?')

    fun Char.plus(char: Char) = "$this$char"
}