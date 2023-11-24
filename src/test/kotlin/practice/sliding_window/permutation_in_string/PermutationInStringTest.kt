package practice.sliding_window.permutation_in_string

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PermutationInStringTest {

    private val solutionFirst = PermutationInStringSolutionBruteForce()

    private val solutionSecond = PermutationInStringSolutionSort()

    private val solutionThird = PermutationInStringSolutionMap()

    private val solutionFourth = PermutationInStringSolutionArray()

    private val solutionFifth = PermutationInStringArrayWithOptimization()

    @Test
    fun solutionFirstTestCase1() {
        val testFirstString = "ab"
        val testSecondString = "eidbaooo"

        assertTrue(solutionFirst.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionFirstTestCase2() {
        val testFirstString = "ab"
        val testSecondString = "eidboaoo"
        assertFalse(solutionFirst.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionSecondTestCase1() {
        val testFirstString = "ab"
        val testSecondString = "eidbaooo"
        assertTrue(solutionSecond.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionSecondTestCase2() {
        val testFirstString = "ab"
        val testSecondString = "eidboaoo"
        assertFalse(solutionSecond.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionThirdTestCase1() {
        val testFirstString = "ab"
        val testSecondString = "eidbaooo"
        assertTrue(solutionThird.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionThirdTestCase2() {
        val testFirstString = "ab"
        val testSecondString = "eidboaoo"
        assertFalse(solutionThird.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionFourthTestCase1() {
        val testFirstString = "ab"
        val testSecondString = "eidbaooo"
        assertTrue(solutionFourth.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionFourthTestCase2() {
        val testFirstString = "ab"
        val testSecondString = "eidboaoo"
        assertFalse(solutionFourth.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionFifthTestCase1() {
        val testFirstString = "ab"
        val testSecondString = "eidbaooo"
        assertTrue(solutionFifth.checkInclusion(testFirstString, testSecondString))
    }

    @Test
    fun solutionFifthTestCase2() {
        val testFirstString = "ab"
        val testSecondString = "eidboaoo"
        assertFalse(solutionFifth.checkInclusion(testFirstString, testSecondString))
    }
}