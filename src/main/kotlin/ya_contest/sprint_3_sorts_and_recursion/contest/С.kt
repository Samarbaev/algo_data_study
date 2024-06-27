package ya_contest.sprint_3_sorts_and_recursion.contest

/**
 * Условие:
 * Гоша любит играть в игру «Подпоследовательность»: даны 2 строки, и нужно понять, является ли первая из них подпоследовательностью второй.
 * Когда строки достаточно длинные, очень трудно получить ответ на этот вопрос, просто посмотрев на них.
 * Помогите Гоше написать функцию, которая решает эту задачу.
 *
 * Формат ввода:
 * В первой строке записана строка s.
 * Во второй —- строка t.
 * Обе строки состоят из маленьких латинских букв, длины строк не превосходят 150000. Строки не могут быть пустыми.
 *
 * Формат вывода:
 * Выведите True, если s является подпоследовательностью t, иначе —– False.
 *
 * Testcase:
 * Ввод
 * abc
 * ahbgdcu
 *
 * Вывод
 * True
 * */

fun main() {

    val pattern = readln()
    val string = readln()
    if (isSubsequence(pattern, string)) println("True") else println("False")
}

fun isSubsequence(pattern: String, string: String): Boolean {
    var count = 0
    for (letter in string) {
        if (count == pattern.length) return true
        if (letter == pattern[count]) count++
    }
    return count == pattern.length
}