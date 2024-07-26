package ya_contest.sprint_1_introduction.contest

import java.lang.StringBuilder

/***
 * Условие:
 * Вася реализовал функцию, которая переводит целое число из десятичной системы в двоичную.
 * Но, кажется, она получилась не очень оптимальной.
 * Попробуйте написать более эффективную программу.
 * Не используйте встроенные средства языка по переводу чисел в бинарное представление.
 *
 * Формат ввода:
 * На вход подаётся целое число в диапазоне от 0 до 10000.
 *
 * Формат вывода:
 * Выведите двоичное представление этого числа.
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
 * 5
 * Вывод
 * 101
 *
 * Пример 2:
 * Ввод
 * 14
 * Вывод
 * 1110
 */
private const val SOLUTION_IS_FIRST = 1
private const val SOLUTION_IS_SECOND = 2
private fun main() {
    println("Введите способ решение: 1ый или 2ой")
    val solution = readln().toInt()
    println("Введите десятичное число для преобразования")
    val value = readln().toInt()
    when (solution) {
        SOLUTION_IS_FIRST -> {
            println(convertToBinaryArray(value))
        }
        SOLUTION_IS_SECOND -> {
            println(convertToBinary(value))
        }
        else -> throw Exception("Ввели неизвестный способ решения задачи")
    }

}

// Solution 1
private fun convertToBinaryArray(value: Int) : String {
    if (value == 0) return "0"
    if (value == 1) return "1"

    val mutableList = mutableListOf<Int>()
    var num: Int = value
    do {
        mutableList.add(num % 2)
        num /= 2
    } while (num > 1)
    mutableList.add(num % 2)

    return mutableList.reversed().joinToString("")
}
// Solution 2
private fun convertToBinary(value: Int): String {
    if (value == 0) return "0"

    var num = value
    val stringBuilder = StringBuilder()

    while (num > 0) {
        stringBuilder.append(num % 2)
        num /= 2
    }

    return stringBuilder.reverse().toString()
}