package com.cryptobytes.ps_shipments.data.suitablility_score.strategy

import com.cryptobytes.ps_shipments.data.suitablility_score.strategy.OddNameStrategy.StrategyConstants.MULTIPLIER_VALUE
import com.cryptobytes.ps_shipments.utils.StringUtil

class OddNameStrategy : BaseStrategy {
    object StrategyConstants {
        const val MULTIPLIER_VALUE = 1.0
    }

    override fun calculate(name: String, address: String, value: Double): Double {
        val score = StringUtil.getConsonantsCount(name) * MULTIPLIER_VALUE
        return CommonFactorsStrategy().calculate(name, address, score)
    }
}