package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Представьте себе онлайн-игру для поездки в метро: игрок нажимает на кнопку, и на экране появляются три случайных числа.
 * Если все три числа оказываются одной чётности, игрок выигрывает.
 * Напишите программу, которая по трём числам определяет, выиграл игрок или нет.
 *
 * Формат ввода:
 * В первой строке записаны три случайных целых числа a, b и c. Числа не превосходят 10ˆ9 по модулю.
 *
 * Формат вывода:
 * Выведите «WIN», если игрок выиграл, и «FAIL» в противном случае.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * 1 2 -3
 * Вывод
 * FAIL
 *
 * Пример 2:
 * Ввод
 * 7 11 7
 * Вывод
 * WIN
 *
 * Пример 3:
 * Ввод
 * 6 -2 0
 * Вывод
 * WIN
 *
 */

private fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    if(isValid(a,b,c)) println("WIN") else println("FAIL")
}

private fun isValid(a:Int, b: Int, c: Int): Boolean {
    return (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 != 0 && b % 2 != 0 && c % 2 != 0)
}