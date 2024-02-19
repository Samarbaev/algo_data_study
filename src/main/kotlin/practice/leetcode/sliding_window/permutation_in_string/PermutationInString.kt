package practice.leetcode.sliding_window.permutation_in_string


/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 **/

/***
 * Test case 1
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Test case 2
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 */
internal interface PermutationInString {

    fun checkInclusion(s1: String, s2: String): Boolean
}