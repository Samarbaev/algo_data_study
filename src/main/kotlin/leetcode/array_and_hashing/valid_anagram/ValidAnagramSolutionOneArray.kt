package leetcode.array_and_hashing.valid_anagram

/***
 * Создаем массив counter, который будет запоминать количество входа для каждого элемента
 *
 * Далее, итерируем по любой из строк, так как они должны быть одного размера.
 * Для первой строки и текущего символа увеличиваем счетчик в массиве,
 * для второй строки и текущего символа уменьшаем счетчик в массиве
 *
 * Далее итерируемся по counter, если какой-то из символов не равен 0, то возвращаем false
 *
 * Create a counter array that will remember the input count for each element
 *
 * Next, we iterate over any of the lines, since they must be the same size.
 * For the first line and the current character, we increase the counter in the array,
 * for the second line and the current character we decrease the counter in the array
 *
 * Next we iterate through counter, if any of the characters is not equal to 0, then we return false
 *
 */
class ValidAnagramSolutionOneArray: ValidAnagram {
    override fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false

        val counter = IntArray(26)

        for (i in s.indices) {
            counter[s[i] - 'a']++
            counter[t[i] - 'a']--
        }

        for (count in counter) {

            if (count != 0) {
                return false
            }
        }
        return true
    }
}