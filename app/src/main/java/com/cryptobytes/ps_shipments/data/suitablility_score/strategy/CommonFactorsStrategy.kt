package com.cryptobytes.ps_shipments.data.suitablility_score.strategy

import com.cryptobytes.ps_shipments.data.suitablility_score.strategy.CommonFactorsStrategy.StrategyConstants.MULTIPLIER_VALUE
import com.cryptobytes.ps_shipments.utils.NumberUtil
import com.cryptobytes.ps_shipments.utils.StringUtil

class CommonFactorsStrategy : BaseStrategy {
    object StrategyConstants {
        const val MULTIPLIER_VALUE = 0.5
    }

    override fun calculate(name: String, address: String, value: Double): Double {
        var resultValue = value
        if(NumberUtil.hasCommonFactor(
                2,
                determineDriverNameLength(name),
                determineStreetNameLength(address))
        ) {
            resultValue += (value * MULTIPLIER_VALUE)
        }
        return resultValue
    }

    private fun determineDriverNameLength(name: String) : Int {
        return StringUtil.removeWhitespace(name).length
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