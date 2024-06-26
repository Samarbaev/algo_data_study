package ya_contest.sprint_3_sorts_and_recursion.contest

/**
 *
 * Условие:
 * Перед сном Рита решила поиграть в игру на телефоне. Дан массив целых чисел, в котором каждый элемент обозначает длину стороны треугольника. Нужно определить максимально возможный периметр треугольника, составленного из сторон с длинами из заданного массива. Помогите Рите скорее закончить игру и пойти спать.
 * Напомним, что из трёх отрезков с длинами a ≤ b ≤ c можно составить треугольник, если выполнено неравенство треугольника c < a + b
 * Разберём пример:
 * даны длины сторон 6, 3, 3, 2. Попробуем в качестве наибольшей стороны выбрать 6. Неравенство треугольника не может выполниться, так как остались 3, 3, 2 —– максимальная сумма из них равна 6.
 * Без шестёрки оставшиеся три отрезка уже образуют треугольник со сторонами 3, 3, 2. Неравенство выполняется: 3 < 3 + 2. Периметр равен 3 + 3 + 2 = 8.
 *
 * Формат ввода:
 * В первой строке записано количество отрезков n, 3≤ n≤ 10000.
 * Во второй строке записано n неотрицательных чисел, не превосходящих 10 000, –— длины отрезков.
 *
 * Формат вывода:
 * Нужно вывести одно число —– наибольший периметр треугольника.
 * Гарантируется, что тройка чисел, которая может образовать треугольник, всегда есть.
 *
 * Testcase
 * Ввод
 * 4
 * 6 3 3 2
 * Вывод
 * 8
 * */

fun main() {
    val sides = readln().toInt()
    val sidesTriangle = readln().split(" ").map { it.toInt() }.sortedByDescending { it }
    println(maxP(sidesTriangle))
}

fun maxP(sidesTriangle: List<Int>) : Int {
    var maxP = 0

    for (index in 0 until sidesTriangle.size - 2) {
        if(sidesTriangle[index] < sidesTriangle[index + 1] + sidesTriangle[index + 2]) {
            val currentP = sidesTriangle[index] + sidesTriangle[index + 1] + sidesTriangle[index + 2]
            maxP = maxOf(currentP, maxP)
        }
    }

    return maxP
}