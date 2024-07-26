package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Напишите программу, которая определяет, будет ли положительное целое число степенью четвёрки.
 * Подсказка: степенью четвёрки будут все числа вида 4ˆn, где n – целое неотрицательное число.
 *
 * Формат ввода:
 * На вход подаётся целое число в диапазоне от 1 до 10000.
 *
 * Формат вывода:
 * Выведите «True», если число является степенью четырёх, «False» –— в обратном случае.
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
 * 15
 * Вывод
 * False
 *
 * Пример 2:
 * Ввод
 * 16
 * Вывод
 * True
 *
 */

private fun main() {
    val number = readln().toInt()
    if (isDegreeNumberFour(number)) println("True") else println("False")
}

private fun isDegreeNumberFour(value: Int): Boolean {
    if(value == 0 || value < 0) return false
    var num = value
    while (num > 1) {
        if(num % 4 != 0) return false
        num /= 4
    }
    return true
}