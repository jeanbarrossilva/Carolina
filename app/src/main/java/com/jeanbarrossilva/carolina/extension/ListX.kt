package com.jeanbarrossilva.carolina.extension

object ListX {
    fun <E> List<E>.move(movement: Pair<(E) -> Boolean, Int>): List<E> = with(MutableListX) { toMutableList().move(movement) }
}