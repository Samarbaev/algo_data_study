package basic_theory.algorithms.combinatorics.generate_combinations

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CombinationWithoutDuplicateImplTest {

    private val combinationWithoutDuplicateImpl = CombinationWithoutDuplicateImpl()

    @Test
    fun testCase() {
        val input = listOf(1, 2, 3)
        val output = listOf(
            listOf(1, 2, 3),
            listOf(1, 2, 4),
            listOf(1, 3, 4),
            listOf(2, 3, 4),
        )
        assertEquals(combinationWithoutDuplicateImpl.combine(4, 3), output)

    }
}