package practice.array_and_hashing.two_sum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TwoSumSolutionTest {

    private val solution = TwoSumSolution()

    @Test
    fun testCase1() {
        val testArray = intArrayOf(2,7,11,15)
        assertArrayEquals(solution.twoSum(testArray, 9), intArrayOf(0,1))
    }

    @Test
    fun testCase2() {
        val testArray = intArrayOf(3,2,4)
        assertArrayEquals(solution.twoSum(testArray, 6), intArrayOf(1,2))
    }

    @Test
    fun testCase3() {
        val testArray = intArrayOf(3,3)
        assertArrayEquals(solution.twoSum(testArray, 6), intArrayOf(0,1))
    }
}