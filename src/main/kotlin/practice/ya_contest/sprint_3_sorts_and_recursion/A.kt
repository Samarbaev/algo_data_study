package practice.ya_contest.sprint_3_sorts_and_recursion

/**
 * Условие:
 * Рита по поручению Тимофея наводит порядок в правильных скобочных последовательностях (ПСП), состоящих только из круглых скобок (). Для этого ей надо сгенерировать все ПСП длины 2n в алфавитном порядке —– алфавит состоит из ( и ) и открывающая скобка идёт раньше закрывающей.
 * Помогите Рите —– напишите программу, которая по заданному n выведет все ПСП в нужном порядке.
 *
 * Рассмотрим второй пример. Надо вывести ПСП из четырёх символов. Таких всего две:
 * (())
 * ()()
 *
 * (()) идёт раньше ()(), так как первый символ у них одинаковый, а на второй позиции у первой ПСП стоит (, который идёт раньше ).
 *
 * Формат ввода:
 * На вход функция принимает n — целое число от 0 до 10.
 *
 * Формат вывода:
 * Функция должна напечатать все возможные скобочные последовательности заданной длины в алфавитном (лексикографическом) порядке.
 *
 * Testcase:
 * Ввод
 * 3
 *
 * Вывод
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * */
fun main() {

    val n = readln().toInt()
    Solution().generateParetness(n)
}

class Solution {

    fun generateParetness(n: Int) {
        val result = mutableListOf<String>()
        nextParetness(result, "", n, 0)
    }

    private fun nextParetness(
        result: MutableList<String>,
        current: String,
        open: Int,
        close: Int
    ) {
        if (open == 0 && close == 0) {
            result.add(current)
            println(current)
            return
        }

        if (open > 0) nextParetness(result, "$current(", open - 1, close + 1)

        if (close > 0) nextParetness(result, "$current)", open, close - 1)

    }
}