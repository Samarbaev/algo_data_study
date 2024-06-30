package leetcode.sliding_window.permutation_in_string

/**
 * Вместо использования специальной структуры данных HashMap только для хранения частоты появления символов,
 * мы можем воспользоваться более простой структурой данных - массивом, чтобы сохранить частоты.
 * Данная задача предполагает, что строки содержат только строчные буквы алфавита ('a' - 'z').
 * Поэтому нам потребуется создать массив размером 26. Остальную часть процесса можно оставить такой же, как и в предыдущем подходе.
 *
 * Instead of making use of a special HashMap datastructure just to store the frequency of occurence of characters,
 * we can use a simpler array data structure to store the frequencies.
 * Given strings contains only lowercase alphabets ('a' to 'z').
 * So we need to take an array of size 26.The rest of the process remains the same as the last approach.
 * */

class PermutationInStringSolutionArray: PermutationInString {

    override fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val frequencyArrayStringFirst = IntArray(26)

        for (i in s1.indices) {
            frequencyArrayStringFirst[s1[i] - 'a']++
        }

        for (i in 0..s2.length - s1.length) {
            val frequencyArrayStringSecond = IntArray(26)
            for (j in s1.indices) {
                frequencyArrayStringSecond[s2[i + j] - 'a']++
            }
            if (frequencyArrayStringFirst.contentEquals(frequencyArrayStringSecond)) {
                return true
            }
        }
        return false
    }
}