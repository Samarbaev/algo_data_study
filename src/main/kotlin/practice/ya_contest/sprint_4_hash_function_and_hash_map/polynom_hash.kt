package practice.ya_contest.sprint_4_hash_function_and_hash_map

/**
 * Условие:
 * Алле очень понравился алгоритм вычисления полиномиального хеша.
 * Помогите ей написать функцию, вычисляющую хеш строки s.
 * В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.
 * Полиномиальный хеш считается по формуле:
 * h(s) = (S1 * a ^ (n-1) + S2 * a ^ (n-2) + ... + S(n-1) + Sn) % M
 *
 * Формат ввода:
 * В первой строке дано число a (1 ≤ a ≤ 1000) – основание, по которому считается хеш.
 * Во второй строке дано число m (1 ≤ m ≤ 109) — модуль.
 * В третьей строке дана строка s (0 ≤ |s| ≤ 106), состоящая из больших и маленьких латинских букв.
 *
 * Формат вывода:
 * Выведите целое неотрицательное число –— хеш заданной строки.
 *
 * Testcase:
 *
 * Ввод:
 * 123
 * 100003
 * a
 *
 * Вывод:
 * 97
 * */

fun calculatePolHash(a: Long, m: Long, input: String): Long {
    var hash: Long = 0
    var p: Long = 1 // Initialize power of base (a)

    for (char in input.reversed()) {
        hash = (hash + char.code * p) % m
        p = (p * a) % m // Update power iteratively
    }

    return hash
}

fun main() {
    val a = readLine()!!.toLong()
    val m = readLine()!!.toLong()
    val inputString = readLine()!!

    println(calculatePolHash(a, m, inputString))
}

