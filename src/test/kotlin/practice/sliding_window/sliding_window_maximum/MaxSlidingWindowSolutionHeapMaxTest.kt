package practice.sliding_window.sliding_window_maximum

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class MaxSlidingWindowSolutionHeapMaxTest {

    private val solution = MaxSlidingWindowSolutionHeapMax()

    @Test
    fun testCase1() {
        val testIntArray = intArrayOf(1,3,-1,-3,5,3,6,7)
        val resultArray = intArrayOf(3,3,5,5,6,7)
        assertArrayEquals(solution.maxSlidingWindow(testIntArray, 3), resultArray)
    }

    @Test
    fun testCase2() {
        val testIntArray = intArrayOf(1)
        val resultArray = intArrayOf(1)
        assertArrayEquals(solution.maxSlidingWindow(testIntArray, 1), resultArray)
    }
}