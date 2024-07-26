package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Тимофей записал два числа в двоичной системе счисления и попросил Гошу вывести их сумму, также в двоичной системе.
 * Встроенную в язык программирования возможность сложения двоичных чисел применять нельзя.
 * Помогите Гоше решить задачу.
 * Решение должно работать за O(N), где N – количество разрядов максимального числа на входе.
 *
 * Формат ввода:
 * Два числа в двоичной системе счисления, каждое на отдельной строке. Длина каждого числа не превосходит 10 000 символов.
 *
 * Формат вывода:
 * Одно число в двоичной системе счисления.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * 1010
 * 1011
 * Вывод
 * 10101
 *
 *
 * Пример 2:
 * Ввод
 * 1
 * 1
 * Вывод
 * 10
 */

private fun main() {
    val firstNumber = readln()
    val secondNumber = readln()
    println(getSum(firstNumber, secondNumber))
}

private fun getSum(firstNumber: String, secondNumber: String): String {
    val maxLengthNumber = maxOf(firstNumber.length, secondNumber.length)
    val paddedFirstNumber = firstNumber.padStart(maxLengthNumber, '0')
    val paddedSecondNumber = secondNumber.padStart(maxLengthNumber, '0')

    var result = ""
    var carry = 0
    for (i in maxLengthNumber - 1 downTo 0) {
        val sum =
            paddedFirstNumber[i].digitToInt() + paddedSecondNumber[i].digitToInt() + carry
        carry = sum / 2

        result += (sum % 2).toString()
    }

    if (carry == 1) {
        result += "1"
    }

    return result.reversed()
}