package ya_contest.sprint_5_binary_trees.contest

/**
 * Условие:
 * Ребятам стало интересно, сколько может быть различных деревьев поиска, содержащих в своих узлах все уникальные числа от 1 до n.
 * Помогите им найти ответ на этот вопрос.
 *
 * Формат ввода:
 * В единственной строке задано число n. Оно не превосходит 15.
 *
 * Формат вывода:
 * Нужно вывести число, равное количеству различных деревьев поиска, в узлах которых могут быть размещены числа от 1 до n включительно.
 *
 * */
fun main() {
    val n = readln().toInt()
    println(numTrees(n))
}

fun numTrees(n: Int): Int {
    val catalan = IntArray(n + 1)
    catalan[0] = 1
    catalan[1] = 1
    for (i in 2..n) {
        for (j in 1..i) {
            catalan[i] += catalan[j - 1] * catalan[i - j]
        }
    }
    return catalan[n]
}