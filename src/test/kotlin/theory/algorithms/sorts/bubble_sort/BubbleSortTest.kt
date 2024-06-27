package theory.algorithms.sorts.bubble_sort

import org.junit.jupiter.api.Assertions.*
import practice.ya_contest.sprint_3_sorts_and_recursion.notes.sorts.bubble_sort.bubbleSortFirstOptimization
import practice.ya_contest.sprint_3_sorts_and_recursion.notes.sorts.bubble_sort.bubbleSortSecondOptimization
import practice.ya_contest.sprint_3_sorts_and_recursion.notes.sorts.bubble_sort.bubbleSortWithoutOptimization
import kotlin.test.Test

internal class BubbleSortTest {

    @Test
    fun testSortBubbleSortWithoutOptimisation() {
        val unsortedArray = intArrayOf(2,5,1,-2,3)
        unsortedArray.bubbleSortWithoutOptimization()
        assertTrue(unsortedArray.contentEquals(intArrayOf(-2, 1, 2, 3, 5)))
    }

    @Test
    fun testEmptyArrayBubbleSortWithoutOptimisation() {
        val emptyArray = intArrayOf()
        emptyArray.bubbleSortWithoutOptimization()
        assertTrue(emptyArray.isEmpty())
    }

    @Test
    fun testSortBubbleSortWitFirstOptimisation() {
        val unsortedArray = intArrayOf(2,5,1,-2,3)
        unsortedArray.bubbleSortFirstOptimization()
        assertTrue(unsortedArray.contentEquals(intArrayOf(-2, 1, 2, 3, 5)))
    }

    @Test
    fun testEmptyArrayBubbleSortWithFirstOptimisation() {
        val emptyArray = intArrayOf()
        emptyArray.bubbleSortFirstOptimization()
        assertTrue(emptyArray.isEmpty())
    }

    @Test
    fun testSortBubbleSortWitSecondOptimisation() {
        val unsortedArray = intArrayOf(2,5,1,-2,3)
        unsortedArray.bubbleSortSecondOptimization()
        assertTrue(unsortedArray.contentEquals(intArrayOf(-2, 1, 2, 3, 5)))
    }

    @Test
    fun testEmptyArrayBubbleSortWitSecondOptimisation() {
        val emptyArray = intArrayOf()
        emptyArray.bubbleSortSecondOptimization()
        assertTrue(emptyArray.isEmpty())
    }



}