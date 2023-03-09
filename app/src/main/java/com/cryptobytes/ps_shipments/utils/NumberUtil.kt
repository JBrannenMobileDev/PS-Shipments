package com.cryptobytes.ps_shipments.utils

class NumberUtil {
    companion object {
        fun isEven(num: Int) : Boolean {
            return num % 2 == 0
        }

        fun hasCommonFactor(minFactor: Int, num1: Int, num2: Int) : Boolean {
            var i = minFactor
            while (i <= num1 && i <= num2) {
                // Checks if i is factor of both integers
                if (num1 % i == 0 && num2 % i == 0) return true
                ++i
            }
            return false
        }
    }
}