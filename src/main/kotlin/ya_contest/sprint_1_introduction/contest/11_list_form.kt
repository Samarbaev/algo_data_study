package ya_contest.sprint_1_introduction.contest

import kotlin.math.max

/***
 * Условие:
 * Вася просил Аллу помочь решить задачу. На этот раз по информатике.
 * Для неотрицательного целого числа X списочная форма – это массив его цифр слева направо. К примеру, для 1231 списочная форма будет [1,2,3,1]. На вход подается количество цифр числа Х, списочная форма неотрицательного числа Х и неотрицательное число K. Число К не превосходят 10000. Длина числа Х не превосходит 1000.
 * Нужно вернуть списочную форму числа X + K.
 * Не используйте встроенные средства языка для сложения длинных чисел.
 *
 * Формат ввода:
 * В первой строке — длина списочной формы числа X. На следующей строке — сама списочная форма с цифрами записанными через пробел.
 * В последней строке записано число K, 0 ≤ K ≤ 10000.
 *
 * Формат вывода:
 * Выведите списочную форму числа X+K.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * 4
 * 1 2 0 0
 * 34
 * Вывод
 * 1 2 3 4
 *
 * Пример 2:
 * Ввод
 * 2
 * 9 5
 * 17
 * Вывод
 * 1 1 2
 */

private fun main() {
    val n = readln()
    val first = readln()
    val second = readln()

    println(sumFirstAndSecond(first.replace(" ", ""), second))
}

private fun sumFirstAndSecond(first: String, second: String): String {
    val maxLength = maxOf(first.length, second.length)
    val paddedFirst = first.padStart(maxLength, '0')
    val paddedSecond = second.padStart(maxLength, '0')

    val result = mutableListOf<Int>()
    var carry = 0

    for (index in maxLength - 1 downTo 0) {
        val sum = paddedFirst[index].digitToInt() + paddedSecond[index].digitToInt() + carry
        carry = sum / 10

        result += (sum % 10)
    }

    if (carry != 0) {
        result += carry
    }
    return result.reversed().joinToString(" ")

}