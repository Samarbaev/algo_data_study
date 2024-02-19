package practice.ya_contest.sprint_3

/***
 * Алла получила задание, связанное с мониторингом работы различных серверов.
 * Требуется понять, сколько времени обрабатываются определённые запросы на конкретных серверах.
 * Эту информацию нужно хранить в матрице, где номер столбца соответствуют идентификатору запроса, а номер строки — идентификатору сервера.
 * Алла перепутала строки и столбцы местами. С каждым бывает. Помогите ей исправить баг.
 * Есть матрица размера m × n. Нужно написать функцию, которая её транспонирует.
 * Транспонированная матрица получается из исходной заменой строк на столбцы.
 * Например, для матрицы А (слева) транспонированной будет следующая матрица (справа):
 * [1 2 3]   [1 0 7 2]
 * [0 2 6]   [2 2 4 7]
 * [7 4 1]   [3 6 1 0]
 * [2 7 0]
 *
 * Формат ввода:
 * В первой строке задано число n — количество строк матрицы.
 * Во второй строке задано m — число столбцов, m и n не превосходят 1000. В следующих n строках задана матрица. Числа в ней не превосходят по модулю 1000.
 *
 * Формат вывода:
 * Напечатайте транспонированную матрицу в том же формате, который задан во входных данных. Каждая строка матрицы выводится на отдельной строке, элементы разделяются пробелами.
 *
 */

fun main() {
    val n = readLine()?.toIntOrNull() ?: 0

    val m = readLine()?.toIntOrNull() ?: 0

    if(n == 0 && m == 0) {
       return
    }

    val matrix = mutableListOf<List<Int>>()

    for (i in 0 until n) {
        val rowInput = readLine()
        val rowElements: List<Int> = rowInput!!.split(" ")!!.map { it.toInt() }
        matrix.add(rowElements)
    }

    val transposedMatrix = transMatrix(matrix)

    for (row in transposedMatrix) {
        println(row.joinToString(" "))
    }

}

fun transMatrix(matrix: List<List<Int>>): List<List<Int>> {
    val rows = matrix[0].size
    val columns = matrix.size

    val ans = MutableList<MutableList<Int>>(size = rows) { MutableList(size = columns) { 0 } }

    for (i in 0 until matrix[0].size) {
        for (j in matrix.indices) {
            ans[i][j] = matrix[j][i]
        }
    }
    return ans
}
