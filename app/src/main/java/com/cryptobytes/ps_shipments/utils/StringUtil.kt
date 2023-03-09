package com.cryptobytes.ps_shipments.utils

import androidx.compose.ui.text.toLowerCase
import java.util.*

class StringUtil {
    companion object {
        fun getVowelCount(value: String) : Int {
            var count = 0
            value.lowercase().forEach{ char ->
                when(char) {
                    'a', 'e', 'i', 'o', 'u' -> count++
                }
            }
            return count
        }

        fun getConsonantsCount(value: String) : Int {
            val letters = value.lettersOnly().lowercase()
            var count = 0
            letters.forEach{ char ->
                when(char) {
                    'a', 'e', 'i', 'o', 'u' -> Unit
                    else -> count++
                }
            }
            return count
        }

        fun removeWhitespace(value: String) : String {
            return value.filterNot { it.isWhitespace() }
        }

        fun hasNumbers(word: String) : Boolean {
            for(char in word) {
                if(char.isDigit()) {
                    return true
                }
            }
            return false
        }

        private fun String.lettersOnly(): String{
            val regex = Regex("[^A-Za-z]")
            return regex.replace(this, "")
        }
    }
}