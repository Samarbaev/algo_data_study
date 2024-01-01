package basic_theory.algorithms.combinatorics.generate_permutations_without_duplicates

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PermutationIterativeImplTest {

    private val permutation = PermutationIterativeImpl()


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
        assertTrue(permutation.permute(input).containsAll(output))
    }

    @Test
    fun testCasePermutationWithoutUniqueElements() {
        val input = intArrayOf(1, 1, 3)
        val output = listOf(
            listOf(1, 1, 3),
            listOf(1, 3, 1),
            listOf(3, 1, 1),
        )
        assertTrue(permutation.permute(input).containsAll(output))
    }

    @Test
    fun testCase2() {
        val input = intArrayOf()
        val output = listOf<List<Int>>(emptyList())
        assertTrue(permutation.permute(input) == output)

    }
}