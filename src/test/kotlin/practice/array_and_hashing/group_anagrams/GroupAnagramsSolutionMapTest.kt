package practice.array_and_hashing.group_anagrams

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import practice.leetcode.array_and_hashing.group_anagrams.GroupAnagramsSolutionMap

internal class GroupAnagramsSolutionMapTest {

    private val solution = GroupAnagramsSolutionMap()

    @Test
    fun testGroupAnagrams() {
        val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        val expected = listOf(listOf("eat", "tea", "ate"), listOf("tan", "nat"), listOf("bat"))
        val actual = solution.groupAnagrams(strs)

        assertEquals(expected.size, actual.size, "Sizes of expected and actual lists are different")
        assertTrue(expected.containsAll(actual), "Actual list doesn't contain all expected sublists")
    }
}