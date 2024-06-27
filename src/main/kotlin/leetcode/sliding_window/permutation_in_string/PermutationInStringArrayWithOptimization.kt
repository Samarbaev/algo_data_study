package leetcode.sliding_window.permutation_in_string

/***
 * Вместо того, чтобы создавать хэш-таблицу заново для каждого окна, рассмотренного в s2, мы можем создать хэш-таблицу только один раз для первого окна s2.
 * Затем, когда мы сдвигаем окно, мы знаем, что мы удаляем один предыдущий символ и добавляем новый последующий символ в новое рассматриваемое окно.
 * Таким образом, мы можем обновить хэш-таблицу, обновив только индексы, связанные с этими двумя символами.
 * Снова для каждой обновленной хэш-таблицы мы сравниваем все элементы хэш-таблицы на равенство, чтобы получить нужный результат.
 *
 * Instead of generating the hashmap afresh for every window considered in s2, we can create the hashmap just once for the first window in s2.
 * Then, later on when we slide the window, we know that we remove one preceding character and add a new succeeding character to the new window considered.
 * Thus, we can update the hashmap by just updating the indices associated with those two characters only. Again, for every updated hashmap, we compare all the elements of the hashmap for equality to get the required result.
 *
 *
 */
class PermutationInStringArrayWithOptimization : PermutationInString {

    override fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        val frequencyCharForStringFirst = IntArray(26)
        val frequencyCharForStringSecond = IntArray(26)

        for(i in s1.indices) {
            frequencyCharForStringFirst[s1[i] - 'a']++
            frequencyCharForStringSecond[s2[i] - 'a']++
        }

        for (j in 0 until s2.length - s1.length) {
            if(frequencyCharForStringFirst.contentEquals(frequencyCharForStringSecond)) return true

            frequencyCharForStringSecond[s2[j + s1.length] - 'a']++
            frequencyCharForStringSecond[s2[j] - 'a']--
        }
        return frequencyCharForStringFirst.contentEquals(frequencyCharForStringSecond)
    }
}