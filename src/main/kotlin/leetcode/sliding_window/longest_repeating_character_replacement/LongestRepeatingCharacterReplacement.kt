package leetcode.sliding_window.longest_repeating_character_replacement
/***
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.

 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */

/*** Test case 1
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Test case 2
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exist other ways to achieve this answer too.
 */
interface LongestRepeatingCharacterReplacement {

    fun characterReplacement(s: String, k: Int): Int
}