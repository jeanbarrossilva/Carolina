package com.jeanbarrossilva.carolina.extension

object MutableListX {
    fun <E> MutableList<E>.move(movement: Pair<(E) -> Boolean, Int>): MutableList<E> {
        movement.let { (predicate, finalIndex) ->
            find(predicate)?.let { element ->
                remove(element)
                add(finalIndex, element)
            }
        }
        return this
    }
}