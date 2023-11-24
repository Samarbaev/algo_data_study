package practice.sliding_window.longest_repeating_character_replacement

/***
 * Решение:
 * 1) Идем по строке, символ, который попался увеличиваем счетчик в массиве frequencyArray для этого символа.
 * 2) Запоминаем максимальный элемент, который встречается
 * 3) Осуществляем проверку, если end + 1 - start - maxFrequency <= k - false,
 * условие не выполняется, значит мы превысили число замен и искать уже в это подстроке
 * смысла нет
 * 4) Из этой подстроки мы уберем стартовый элемент, путем увеличения start и уменьшаем значение
 * этого элемента из массива frequencyArray
 * 5) Вычисляем максимальный longestSubstringLength = end + 1 - start
 *
 * Solution:
 * 1) Iterate through the string and increment the counter in the frequencyArray for each encountered character.
 * 2) Keep track of the maximum frequency encountered.
 * 3) Check if the condition end + 1 - start - maxFrequency <= k is false.
 * If the condition is false, it means that we have exceeded the number of allowed replacements, and there is no point in searching within this substring.
 * 4) Remove the starting element from this substring by increasing the start index and decreasing the corresponding value in the frequencyArray.
 * 5) Calculate the maximum longestSubstringLength as end + 1 - start.
 *
 * Time complexity: O(n), where n is size string
 * Space complexity: O(m), where m = 26
 */

class LongestRepeatingCharacterReplacementSolutionFirst: LongestRepeatingCharacterReplacement {

    override fun characterReplacement(s: String, k: Int): Int {

        var start = 0
        val frequencyArray = IntArray(26)
        var maxFrequency = 0
        var longestSubstringLength = 0

        for(end in s.indices) {
            val currentChar = s[end] - 'A';
            frequencyArray[currentChar]++

            maxFrequency = maxOf(maxFrequency, frequencyArray[currentChar])

            val isValid = (end + 1 - start - maxFrequency <= k)
            if(!isValid) {
                val outgoingChar = s[start] - 'A'
                frequencyArray[outgoingChar]--
                start++
            }
            longestSubstringLength = end + 1 - start
        }
        return longestSubstringLength
    }
}