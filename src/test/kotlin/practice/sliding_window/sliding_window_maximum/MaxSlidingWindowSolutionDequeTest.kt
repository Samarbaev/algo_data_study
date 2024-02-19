package practice.sliding_window.sliding_window_maximum

import org.junit.jupiter.api.Assertions.*
import practice.leetcode.sliding_window.sliding_window_maximum.MaxSlidingWindowSolutionDeque
import kotlin.test.Test

internal class MaxSlidingWindowSolutionDequeTest {

    private val solutionDeque = MaxSlidingWindowSolutionDeque()

    @Test
    fun testCase1() {
        val testArray = intArrayOf(1,3,-1,-3,5,3,6,7)
        assertArrayEquals(solutionDeque.maxSlidingWindow(testArray, 3), intArrayOf(3,3,5,5,6,7))
    }

    @Test
    fun testCase2() {
        val testArray = intArrayOf(1)
        assertArrayEquals(solutionDeque.maxSlidingWindow(testArray,1), intArrayOf(1))
    }
}