package theory.algorithms.combinatorics.generate_permutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import practice.leetcode.combinatorics.generate_permutations.PermutationRecursiveImpl

internal class PermutationRecursiveImplTest {
    private val permutation = PermutationRecursiveImpl()


    @Test
    fun testCasePermutationWithUniqueElements() {
        val input = intArrayOf(1, 2, 3)
        val output = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 2, 1),
            listOf(3, 1, 2),
        )
        assertTrue(permutation.generatePermute(input).containsAll(output))
    }

    @Test
    fun testCase2() {
        val input = intArrayOf()
        val output = listOf<List<Int>>(emptyList())
        assertTrue(permutation.generatePermute(input) == output)

    }
}