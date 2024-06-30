package leetcode.sliding_window.permutation_in_string

/***
 *
 * Как уже обсуждалось одна строка будет перестановкой другой строки только в том случае, если обе строки содержат одинаковые символы с одинаковой частотой.
 * Мы можем рассмотреть каждую возможную подстроку в длинной строке s2, имеющую такую же длину, как s1, и проверить частоту появления символов в обеих строках.
 * Если частоты каждой буквы полностью совпадают, то перестановка s1 может быть подстрокой s2.
 * Для реализации этого подхода, вместо сортировки и сравнения элементов на равенство, мы используем хэш-таблицу s1map, которая хранит частоту появления всех символов в строке s1.
 * Мы рассматриваем каждую возможную подстроку s2 длиной, равной длине s1, находим соответствующую хэш-таблицу, s2map.
 * Таким образом, рассматриваемые подстроки можно рассматривать как окно длиной s1, проходящееся по s2.
 * Если полученные две хэш-таблицы идентичны для любого такого окна, мы можем заключить, что перестановка s1 является подстрокой s2, иначе - нет.
 *
 *
 * As discussed above, one string will be a permutation of another string only if both of them contain the same characters with the same frequency.
 * We can consider every possible substring in the long string s2 of the same length as that of s1 and check the frequency of occurrence of the characters appearing in the two.
 * If the frequencies of every letter match exactly, then only s1's permutation can be a substring of s2.
 * In order to implement this approach, instead of sorting and then comparing the elements for equality, we make use of a hashmap s1map which stores the frequency of occurrence of all the characters in the short string s1.
 * We consider every possible substring of s2 of the same length as that of s1, find its corresponding hashmap as well, namely s2map.
 * Thus, the substrings considered can be viewed as a window of length as that of s1 iterating over s2.
 * If the two hashmaps obtained are identical for any such window, we can conclude that s1's permutation is a substring of s2, otherwise not.
 */
class PermutationInStringSolutionMap : PermutationInString {

    override fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val hashMapForStringFirst = HashMap<Char, Int>()

        for (i in s1.indices) {
            hashMapForStringFirst[s1[i]] = hashMapForStringFirst.getOrDefault(s1[i], 0) + 1
        }

        for (i in 0..s2.length - s1.length) {
            val hashMapForStringSecond = HashMap<Char, Int>()
            for (j in s1.indices) {
                hashMapForStringSecond[s2[i + j]] = hashMapForStringSecond.getOrDefault(s2[i + j], 0) + 1
            }
            if (matches(hashMapForStringFirst, hashMapForStringSecond)) {
                return true
            }
        }
        return false
    }

    private fun matches(hashMapStringFirst: HashMap<Char, Int>, hashMapStringSecond: HashMap<Char, Int>): Boolean {
        for (key in hashMapStringFirst.keys) {
            if (hashMapStringFirst.getOrDefault(key, 0) - hashMapStringSecond.getOrDefault(key, 0) != 0) {
                return false
            }
        }
        return true
    }
}