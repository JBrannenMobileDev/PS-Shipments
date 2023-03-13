package com.cryptobytes.ps_shipments.utils

import org.junit.Assert
import org.junit.Test

class NumberUtilTest {
    @Test
    fun `verify isEven returns true when number is even`() {
        //Given
        val evenNumber = 2

        //When
        val result = NumberUtil.isEven(evenNumber)

        //Then
        Assert.assertTrue(result)
    }

    @Test
    fun `verify isEven returns false when number is odd`() {
        //Given
        val oddNumber = 3

        //When
        val result = NumberUtil.isEven(oddNumber)

        //Then
        Assert.assertFalse(result)
    }

    @Test
    fun `verify hasCommonFactor returns true when numbers share common factor greater than min factor`() {
        //Given
        val minFactor = 2
        val num1 = 10
        val num2 = 5

        //When
        val result = NumberUtil.hasCommonFactor(minFactor, num1, num2)

        //Then
        Assert.assertTrue(result)
    }

    @Test
    fun `verify hasCommonFactor returns false when numbers do not share common factor greater than min factor`() {
        //Given
        val minFactor = 6
        val num1 = 10
        val num2 = 5

        //When
        val result = NumberUtil.hasCommonFactor(minFactor, num1, num2)

        //Then
        Assert.assertFalse(result)
    }
}