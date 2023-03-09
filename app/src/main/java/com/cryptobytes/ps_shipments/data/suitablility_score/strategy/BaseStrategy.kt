package com.cryptobytes.ps_shipments.data.suitablility_score.strategy

interface BaseStrategy {
    fun calculate(name: String, address: String, value: Double): Double
}