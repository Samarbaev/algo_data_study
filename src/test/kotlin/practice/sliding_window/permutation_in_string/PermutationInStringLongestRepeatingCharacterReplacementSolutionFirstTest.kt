package practice.sliding_window.permutation_in_string

import org.junit.jupiter.api.Assertions.*
import practice.leetcode.sliding_window.permutation_in_string.PermutationInStringSolutionBruteForce
import kotlin.test.Test

internal class PermutationInStringLongestRepeatingCharacterReplacementSolutionFirstTest {

    @Test
    fun testCase1() {
        val permutationInString = PermutationInStringSolutionBruteForce()
        val testStringFirst = "hello"
        val testStringSecond = "ooolleoooleh"
        assertFalse(permutationInString.checkInclusion(testStringFirst, testStringSecond))
    }
}