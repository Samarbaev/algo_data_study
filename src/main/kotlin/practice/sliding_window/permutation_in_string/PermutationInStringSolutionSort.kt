package practice.sliding_window.permutation_in_string

import java.util.*

/**
 * Идея этого подхода заключается в том, что одна строка является перестановкой другой строки только в том случае, если обе строки содержат одинаковые символы в одинаковом количестве.
 * Строка x является перестановкой другой строки y только в том случае, если sorted(x)=sorted(y).
 * Для проверки этого мы можем отсортировать обе строки и сравнить их. Мы сортируем короткую строку s1 и все подстроки s2, сортируем их и сравниваем с отсортированной строкой s1.
 * Если они полностью совпадают, то перестановка s1 является подстрокой s2, иначе нет.
 *
 *
 *
 * The idea behind this approach is that one string will be a permutation of another string only if both of them contain the same characters the same number of times.
 * One string x is a permutation of other string y only if sorted(x)=sorted(y).
 * In order to check this, we can sort the two strings and compare them. We sort the short string s1 and all the substrings of s2, sort them and compare them with the sorted s1 string.
 * If the two match completely, s1's permutation is a substring of s2, otherwise not.
 *
 * Time complexity: 0(s1*log(s1) + (s2 - s1) * s1 * log(s1))
 * Space complexity: 0(s1), where s1 is size s1
 * */
class PermutationInStringSolutionSort : PermutationInString {

    override fun checkInclusion(s1: String, s2: String): Boolean {
        val sortedStringS1 = sort(s1)
        for (i in 0..s2.length - s1.length) {
            if (sortedStringS1 == sort(s2.substring(i, i + s1.length)))
                return true
        }
        return false
    }

    private fun sort(s: String): String {
        val temp = s.toCharArray()
        Arrays.sort(temp)
        return String(temp)
    }
}