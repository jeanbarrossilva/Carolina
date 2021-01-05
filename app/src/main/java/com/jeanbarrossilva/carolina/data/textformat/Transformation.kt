package com.jeanbarrossilva.carolina.data.textformat

interface Transformation {
    var title: String

    fun convert(text: String): String

    companion object {
        fun Transformation(title: String = "", conversion: (String) -> String) = object : Transformation {
            override var title = title

            override fun convert(text: String) = conversion(text)
        }
    }
}