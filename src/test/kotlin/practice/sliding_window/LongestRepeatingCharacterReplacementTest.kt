package practice.sliding_window

import org.junit.jupiter.api.Assertions.*
import practice.sliding_window.longest_repeating_character_replacement.SolutionFirst
import kotlin.test.Test

internal class LongestRepeatingCharacterReplacementTest{


    @Test
    fun testCase1() {
        val solutionFirst = SolutionFirst()
        val testString = "ABAB"
        assertEquals(solutionFirst.characterReplacement(testString, 2), 4)
    }

    @Test
    fun testCase2() {
        val solutionFirst = SolutionFirst()
        val testString = "AABABBA"
        assertEquals(solutionFirst.characterReplacement(testString, 1), 4)
    }
}