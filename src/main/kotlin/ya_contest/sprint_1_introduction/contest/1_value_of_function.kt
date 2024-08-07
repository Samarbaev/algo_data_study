package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Вася делает тест по математике: вычисляет значение функций в различных точках.
 * Стоит отличная погода, и друзья зовут Васю гулять.
 * Но мальчик решил сначала закончить тест и только после этого идти к друзьям.
 * К сожалению, Вася пока не умеет программировать. Зато вы умеете.
 * Помогите Васе написать код функции, вычисляющей y = ax2 + bx + c.
 * Напишите программу, которая будет по коэффициентам a, b, c и числу x выводить значение функции в точке x.
 *
 * Формат ввода:
 * На вход через пробел подаются целые числа a, x, b, c. В конце ввода находится перенос строки.
 *
 * Формат вывода:
 * Выведите одно число — значение функции в точке x.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * -8 -5 -2 7
 * Вывод
 * -183
 *
 * Пример 2:
 * Ввод
 * 8 2 9 -10
 * Вывод
 * 40
 *
 */

private fun main() {
    val (a, x, b, c) = readln().split(" ").map { it.toInt() }
    println(calculate(a, b, c, x))
}

private fun calculate(a: Int, b: Int, c: Int, x: Int): Int {
    return a * x * x + b * x + c
}
