package com.cryptobytes.ps_shipments.utils

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class StringUtilTest {
    @Test
    fun `verify hasNumbers returns true when the String has numbers in it`() {
        //Given
        val stringWithNumbers = "Has numbers 1234"

        //When
        val result = StringUtil.hasNumbers(stringWithNumbers)

        //Then
        Assert.assertTrue(result)
    }

    @Test
    fun `verify hasNumbers returns false when the String does not have numbers in it`() {
        //Given
        val stringWithNoNumbers = "No numbers here!"

        //When
        val result = StringUtil.hasNumbers(stringWithNoNumbers)

        //Then
        Assert.assertFalse(result)
    }

    @Test
    fun `verify removeWhiteSpace removes the white space`() {
        //Given
        val stringWithSpace = "No numbers here!"

        //When
        val result = StringUtil.removeWhitespace(stringWithSpace)

        //Then
        Assert.assertFalse(result.contains(" "))
    }

    @Test
    @Parameters(value = [
        "aeiou, 5",
        "abcdefg, 2",
        "abcdefgi, 3",
        "7475#%$&^, 0",
        "3485sdruifjgh%$, 2",
        ", 0",
        "o, 1"
    ])
    fun `verify getVowelCount returns correct count`(inputString: String, expected: Int) {
        //When
        val actual = StringUtil.getVowelCount(inputString)

        //Then
        Assert.assertEquals(expected, actual)
    }

    @Test
    @Parameters(value = [
        "Test, 3",
        "123Test321, 3",
    ])
    fun `verify getConsonantsCount returns correct count`(inputString: String, expected: Int) {
        //When
        val actual = StringUtil.getConsonantsCount(inputString)

        //Then
        Assert.assertEquals(expected, actual)
    }
}