package practice.sliding_window

import org.junit.jupiter.api.Assertions.*
import practice.leetcode.sliding_window.longest_repeating_character_replacement.LongestRepeatingCharacterReplacementSolutionFirst
import kotlin.test.Test

internal class PermutationInStringLongestRepeatingCharacterReplacementSolutionFirstTest {


    @Test
    fun testCase1() {
        val longestRepeatingCharacterReplacementSolutionFirst = LongestRepeatingCharacterReplacementSolutionFirst()
        val testString = "ABAB"
        assertEquals(longestRepeatingCharacterReplacementSolutionFirst.characterReplacement(testString, 2), 4)
    }

    @Test
    fun testCase2() {
        val longestRepeatingCharacterReplacementSolutionFirst = LongestRepeatingCharacterReplacementSolutionFirst()
        val testString = "AABABBA"
        assertEquals(longestRepeatingCharacterReplacementSolutionFirst.characterReplacement(testString, 1), 4)
    }
}