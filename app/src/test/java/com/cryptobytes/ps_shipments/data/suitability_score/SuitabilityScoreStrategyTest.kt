package com.cryptobytes.ps_shipments.data.suitability_score

import com.cryptobytes.ps_shipments.data.suitablility_score.strategy.SuitabilityScoreStrategy
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class SuitabilityScoreStrategyTest {
    @Test
    @Parameters(value = [
        "Adam Reed, 2234 Summer Way, 0.0, 4",         //uses OddStrategy
        "Jessica Peters, 334 Delmonte St, 0.0, 7.5",  //uses EvenStrategy
        "Adam T, 334 Jensons Way, 0.0, 4.5",          //uses EvenStrategy CommonFactorStrategy
    ])
    fun `verify calculate returns correct score`(name: String, address: String, initialScore: Double, expected: Double) {
        //When
        val actual = SuitabilityScoreStrategy().calculate(name, address, initialScore)

        //Then
        Assert.assertEquals(expected, actual, 0.0)
    }
}