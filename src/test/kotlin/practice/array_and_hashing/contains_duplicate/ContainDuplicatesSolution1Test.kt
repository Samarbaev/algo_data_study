package practice.array_and_hashing.contains_duplicate

import org.junit.jupiter.api.Test
import practice.leetcode.array_and_hashing.contains_duplicate.ContainDuplicatesSolution
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ContainDuplicatesSolutionTest {

    private val solution = ContainDuplicatesSolution()

    @Test
    fun testCase1() {
        val testArray = intArrayOf(1,2,3,1)
        assertTrue(solution.containsDuplicate(testArray))
    }

    @Test
    fun testCase2() {
        val testArray = intArrayOf(1,2,3,4)
        assertFalse(solution.containsDuplicate(testArray))
    }
}