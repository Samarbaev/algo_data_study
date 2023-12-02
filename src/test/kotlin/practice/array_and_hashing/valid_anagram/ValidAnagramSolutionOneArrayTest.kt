package practice.array_and_hashing.valid_anagram

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ValidAnagramSolutionOneArrayTest {

    private val solution = ValidAnagramSolutionOneArray()

    @Test
    fun testCase1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"))
    }

    @Test
    fun testCase2() {
        assertFalse(solution.isAnagram("rat", "car"))
    }
}