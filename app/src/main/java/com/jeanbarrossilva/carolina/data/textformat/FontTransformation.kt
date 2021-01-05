package com.jeanbarrossilva.carolina.data.textformat

import com.jeanbarrossilva.carolina.data.textformat.Transformation.Companion.Transformation
import com.jeanbarrossilva.carolina.extension.StringX.capitalized
import com.jeanbarrossilva.carolina.extension.StringX.mapJoiningWith

object FontTransformation {
     val values = arrayOf(
         Transformation { text ->
             text.mapJoiningWith {
                 when (it) {
                     'A' -> "𝓐"
                     'a' -> "𝓪"
                     'B' -> "𝓑"
                     'b' -> "𝓫"
                     'C' -> "𝓒"
                     'c' -> "𝓬"
                     'D' -> "𝓓"
                     'd' -> "𝓭"
                     'E' -> "𝓔"
                     'e' -> "𝓮"
                     'F' -> "𝓕"
                     'f' -> "𝓯"
                     'G' -> "𝓖"
                     'g' -> "𝓰"
                     'H' -> "𝓗"
                     'h' -> "𝓱"
                     'I' -> "𝓘"
                     'i' -> "𝓲"
                     'J' -> "𝓙"
                     'j' -> "𝓳"
                     'K' -> "𝓚"
                     'k' -> "𝓴"
                     'L' -> "𝓛"
                     'l' -> "𝓵"
                     'M' -> "𝓜"
                     'm' -> "𝓶"
                     'N' -> "𝓝"
                     'n' -> "𝓷"
                     'O' -> "𝓞"
                     'o' -> "𝓸"
                     'P' -> "𝓟"
                     'p' -> "𝓹"
                     'Q' -> "𝓠"
                     'q' -> "𝓺"
                     'R' -> "𝓡"
                     'r' -> "𝓻"
                     'S' -> "𝓢"
                     's' -> "𝓼"
                     'T' -> "𝓣"
                     't' -> "𝓽"
                     'U' -> "𝓤"
                     'u' -> "𝓾"
                     'V' -> "𝓥"
                     'v' -> "𝓿"
                     'W' -> "𝓦"
                     'w' -> "𝔀"
                     'X' -> "𝓧"
                     'x' -> "𝔁"
                     'Y' -> "𝓨"
                     'y' -> "𝔂"
                     'Z' -> "𝓩"
                     'z' -> "𝔃"
                     else -> it
                 }
             }
         },
         Transformation { text ->
             text.mapJoiningWith {
                 when (it) {
                     'A' -> "ᴀ"
                     'B' -> "ʙ"
                     'C' -> "ᴄ"
                     'D' -> "ᴅ"
                     'E' -> "ᴇ"
                     'F' -> "ғ"
                     'G' -> "ɢ"
                     'H' -> "ʜ"
                     'I' -> "ɪ"
                     'J' -> "ᴊ"
                     'K' -> "ᴋ"
                     'L' -> "ʟ"
                     'M' -> "ᴍ"
                     'N' -> "ɴ"
                     'O' -> "ᴏ"
                     'P' -> "ᴘ"
                     'Q' -> "ǫ"
                     'R' -> "ʀ"
                     'S' -> "s"
                     'T' -> "ᴛ"
                     'U' -> "ᴜ"
                     'V' -> "ᴠ"
                     'W' -> "ᴡ"
                     'X' -> "x"
                     'Y' -> "ʏ"
                     'Z' -> "ᴢ"
                     else -> it
                 }
             }
         },
         Transformation { text ->
             text
                 .capitalized
                 .mapJoiningWith {
                     when (it) {
                         'A' -> "∀"
                         'a' -> "ɐ"
                         'B' -> "q"
                         'b' -> 'q'
                         'C' -> "Ͻ"
                         'c' -> "ɔ"
                         'D' -> "ᗡ"
                         'd' -> "p"
                         'E' -> "Ǝ"
                         'e' -> "ǝ"
                         'F' -> "Ⅎ"
                         'f' -> "ɟ"
                         'G' -> "ƃ"
                         'g' -> "ƃ"
                         'h' -> "ɥ"
                         'i' -> "ı"
                         'J' -> "ſ"
                         'j' -> "ɾ"
                         'K' -> "ʞ"
                         'k' -> "ʞ"
                         'L' -> "˥"
                         'l' -> "ן"
                         'M' -> "W"
                         'm' -> "ɯ"
                         'n' -> "u"
                         'P' -> "Ԁ"
                         'p' -> "d"
                         'Q' -> "Ὁ"
                         'q' -> "b"
                         'R' -> "ᴚ"
                         'r' -> "ɹ"
                         'T' -> "⊥"
                         't' -> "ʇ"
                         'U' -> "∩"
                         'u' -> "n"
                         'V' -> "Λ"
                         'v' -> "ʌ"
                         'W' -> 'M'
                         'w' -> "ʍ"
                         'Y' -> "ʎ"
                         'y' -> "ʎ"
                         '.' -> "˙"
                         ',' -> "'"
                         ';' -> "؛"
                         '!' -> "¡"
                         '?' -> "¿"
                         '\'' -> ","
                         '\"' -> "„"
                         '(' -> ")"
                         ')' -> "("
                         '{' -> "}"
                         '}' -> "{"
                         else -> it
                     }
                 }
                 .reversed()
         }
     ).onEachIndexed { index, format -> format.title = "Font #${index + 1}" }
}