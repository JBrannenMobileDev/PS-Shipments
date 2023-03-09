package com.cryptobytes.ps_shipments.data.suitablility_score.strategy
import com.cryptobytes.ps_shipments.utils.NumberUtil
import com.cryptobytes.ps_shipments.utils.StringUtil

class SuitabilityScoreStrategy : BaseStrategy {
    override fun calculate(name: String, address: String, value: Double): Double {
        val initScore = 0.0
        return if(NumberUtil.isEven(determineStreetNameLength(address))) {
            EvenNameStrategy().calculate(name, address, initScore)
        } else {
            OddNameStrategy().calculate(name, address, initScore)
        }
    }

    private fun determineStreetNameLength(address: String) : Int {
        val words = address.split(" ").toList()
        var length = 0
        for(word in words) {
            if(!StringUtil.hasNumbers(word) && !word.contains("Apt.", ignoreCase = true) && !word.contains("Suite", ignoreCase = true)) {
                length += word.length
            }
        }
        return length
    }
}