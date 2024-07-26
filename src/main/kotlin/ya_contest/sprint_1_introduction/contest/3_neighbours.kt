package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Дана матрица. Нужно написать функцию, которая для элемента возвращает всех его соседей.
 * Соседним считается элемент, находящийся от текущего на одну ячейку влево, вправо, вверх или вниз.
 * Диагональные элементы соседними не считаются.
 * Например, в матрице A соседними элементами для (0, 0) будут 2 и 0. А для (2, 1) – 1, 2, 7, 7.
 *   0 1 2
 * 0 1 2 3
 * 1 0 2 6
 * 2 7 4 1
 * 3 2 7 0
 *
 * Формат ввода:
 * В первой строке задано n — количество строк матрицы. Во второй — количество столбцов m.
 * Числа m и n не превосходят 1000. В следующих n строках задана матрица.
 * Элементы матрицы — целые числа, по модулю не превосходящие 1000.
 * В последних двух строках записаны координаты элемента, соседей которого нужно найти.
 * Индексация начинается с нуля.
 *
 * Формат вывода:
 * Напечатайте нужные числа в возрастающем порядке через пробел.
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
 * 3
 * 1 2 3
 * 0 2 6
 * 7 4 1
 * 2 7 0
 * 3
 * 0
 * Вывод
 * 7 7
 *
 * Пример 2:
 * Ввод
 * 4
 * 3
 * 1 2 3
 * 0 2 6
 * 7 4 1
 * 2 7 0
 * 0
 * 0
 * Вывод
 * 0 2
 *
 * Пример 3:
 *
 */

private data class Matrix(val rows: Int, val columns: Int, val data: List<IntArray>)

private fun main() {
    val matrix = readMatrix()
    val x = readln().toInt()
    val y = readln().toInt()
    val neighbours = getNeighbours(matrix, x, y)
    neighbours.forEach { print("$it ") }
}

private fun getNeighbours(matrix: Matrix, row: Int, column: Int): List<Int> {
    val result = mutableListOf<Int>()

    // right
    if (column < matrix.columns - 1) result.add(matrix.data[row][column + 1])
    // left
    if (column > 0) result.add(matrix.data[row][column - 1])
    // top
    if (row > 0) result.add(matrix.data[row - 1][column])
    //bottom
    if (row < matrix.rows - 1) result.add(matrix.data[row + 1][column])
    result.sort()
    return result
}

private fun readMatrix(): Matrix {
    val n = readln().toInt()
    val m = readln().toInt()
    val matrix = buildList(n) {
        for (i in 0 until n) {
            add(readln().split(" ").map { it.toInt() }.toIntArray())
        }
    }
    return Matrix(n, m, matrix)
}