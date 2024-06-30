package ya_contest.sprint_3_sorts_and_recursion.contest

/**
 * Условие:
 * Вечером ребята решили поиграть в игру «Большое число».
 * Даны числа. Нужно определить, какое самое большое число можно из них составить.
 *
 * Формат ввода:
 * В первой строке записано n — количество чисел. Оно не превосходит 100.
 * Во второй строке через пробел записаны n неотрицательных чисел, каждое из которых не превосходит 1000.
 *
 * Формат вывода:
 * Нужно вывести самое большое число, которое можно составить из данных чисел.
 *
 * Testcase:
 * Ввод
 * 3
 * 15 56 2
 * Вывод
 * 56215
 * */

fun main() {
    val n = readLine()?.toIntOrNull() ?: 0
    val numbers = readLine()?.split(" ")?.map { it.toIntOrNull() ?: 0 } ?: listOf()

    val sortedNumbers = numbers.sortedWith { num1, num2 ->
        val num1AsString = num1.toString()
        val num2AsString = num2.toString()
        "$num2AsString$num1AsString".toInt().compareTo("$num1AsString$num2AsString".toInt())
    }

    println(sortedNumbers.joinToString(""))
}