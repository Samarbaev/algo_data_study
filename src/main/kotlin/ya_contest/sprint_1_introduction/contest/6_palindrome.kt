package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Помогите Васе понять, будет ли фраза палиндромом.
 * Учитываются только буквы и цифры, заглавные и строчные буквы считаются одинаковыми.
 * Решение должно работать за O(N), где N — длина строки на входе.
 *
 * Формат ввода:
 * В единственной строке записана фраза или слово. Буквы могут быть только латинские.
 * Длина текста не превосходит 20000 символов.
 * Фраза может состоять из строчных и прописных латинских букв, цифр, знаков препинания.
 *
 * Формат вывода:
 * Выведите «True», если фраза является палиндромом, и «False», если не является.
 *
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * A man, a plan, a canal: Panama
 * Вывод
 * True
 *
 * Пример 2:
 * Ввод
 * zo
 * Вывод
 * False
 */

private fun main() {
    val sentence = readln()
    if(isPalindrome(sentence)) println("True") else println("False")

}

private fun isPalindrome(string: String): Boolean {
    var left = 0
    var right = string.length - 1
    while (left < right) {
        while (left < right && !string[left].isLetterOrDigit()) left++
        while (left < right && !string[right].isLetterOrDigit()) right--

        if(string[left].lowercaseChar() != string[right].lowercaseChar()) return false

        left++
        right--

    }
    return true
}