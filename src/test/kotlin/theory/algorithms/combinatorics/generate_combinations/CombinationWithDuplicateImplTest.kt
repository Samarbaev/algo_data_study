package theory.algorithms.combinatorics.generate_combinations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import practice.leetcode.combinatorics.generate_combinations.CombinationWithDuplicateImpl

internal class CombinationWithDuplicateImplTest {

    private val combinationWithDuplicateImpl = CombinationWithDuplicateImpl()

    @Test
    fun testCase1() {
        val input = listOf(1,1,1)
        val output = listOf(
            listOf(1,1,1),
            listOf(1,1,2),
            listOf(1,1,3),
            listOf(1,1,4),
            listOf(1,2,2),
            listOf(1,2,3),
            listOf(1,2,4),
            listOf(1,3,3),
            listOf(1,3,4),
            listOf(1,4,4),
            listOf(2,2,2),
            listOf(2,2,3),
            listOf(2,2,4),
            listOf(2,3,3),
            listOf(2,3,4),
            listOf(2,4,4),
            listOf(3,3,3),
            listOf(3,3,4),
            listOf(3,4,4),
            listOf(4,4,4),
        )
        assertTrue(combinationWithDuplicateImpl.generateCombine(4,3) == output)
    }
}