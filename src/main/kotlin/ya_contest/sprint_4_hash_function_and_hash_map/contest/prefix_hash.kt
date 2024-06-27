package ya_contest.sprint_4_hash_function_and_hash_map.contest

/**
 * Условие:
 * Алла не остановилась на достигнутом – теперь она хочет научиться быстро вычислять хеши произвольных подстрок данной строки. Помогите ей!
 * На вход поступают запросы на подсчёт хешей разных подстрок. Ответ на каждый запрос должен выполняться за O(1). Допустимо в начале работы программы сделать предподсчёт для дальнейшей работы со строкой.
 * Напомним, что полиномиальный хеш считается по формуле
 * h(s) = (S1 * a ^ (n-1) + S2 * a ^ (n-2) + ... + S(n-1) + Sn) % M
 * В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.
 *
 * Формат ввода:
 * В первой строке дано число a (1 ≤ a ≤ 1000) — основание, по которому считается хеш.
 * Во второй строке дано число m (1 ≤ m ≤ 107) — модуль.
 * В третьей строке дана строка s (0 ≤ |s| ≤ 106), состоящая из больших и маленьких латинских букв.
 * В четвертой строке дано число запросов t — натуральное число от 1 до 105. В каждой из следующих t строк записаны через пробел два числа l и r – индексы начала и конца очередной подстроки. (1 ≤ l ≤ r ≤ |s|).
 *
 * Формат вывода:
 * Для каждого запроса выведите на отдельной строке хеш заданной в запросе подстроки.
 *
 * Testcase:
 *
 * Ввод:
 * 1000
 * 1000009
 * abcdefgh
 * 7
 * 1 1
 * 1 5
 * 2 3
 * 3 4
 * 4 4
 * 1 8
 * 5 8
 *
 * Вывод:
 * 97
 * 225076
 * 98099
 * 99100
 * 100
 * 436420
 * 193195
 * */

fun main() {
    val a = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val s = readLine()!!

    val hashArray = LongArray(s.length)
    hashArray[0] = s[0].code.toLong()
    for (i in 1 until s.length) {
        hashArray[i] = (hashArray[i - 1] * a + s[i].code) % m
    }

    val t = readLine()!!.toInt()
    repeat(t) {
        val (l, r) = readLine()!!.split(" ").map { it.toInt() }
        val leftHash = if (l == 1) 0 else hashArray[l - 2]
        val substringHash = (hashArray[r - 1] - leftHash * powMod(a.toLong(), r - l + 1, m) + m) % m
        println(substringHash)
    }
}

fun powMod(base: Long, exponent: Int, modulo: Int): Long {
    var result = 1L
    var b = base % modulo

    var e = exponent
    while (e > 0) {
        if (e % 2 != 0) {
            result = (result * b) % modulo
        }

        b = (b * b) % modulo
        e /= 2
    }

    return result
}
// Draft
// "abc"
// hash("a") = (a.code) mod R = 97
// hash("ab") = (a.code * q + b.code) mod R = (97 * q + b.code) mod R =
// hash("abc") = (a.code * q^2 + b.code * q + c) mod R =
// hash = (prefix_hashes[r] - prefix_hashes[l-1] + p^N) % mod
// Начинаю выводить, пусть есть

// hash("cde") = (hash("abcde") - hash("ab") * q^3) mod R (1)
// q^3(a.code * q + b.code) =
// hash("abcde") = (a.code * q^4 + b.code * q^3 + c.code * q^2 + d.code * q + e.code) mod R (2)
// hash("ab") = (a.code * q + b.code) mod R (3)
// Из (2) вычитаю (3)
// hash("abcde) - hash("ab") = (a.code * q^4 + b.code * q^3 + c.code * q^2 + d.code * q + e.code - a.code * q - b.code) mod R
//  hash("abcde) - hash("ab") = (a.code * q^3 + b.code * q^2 + c.code * q^2 + d.code * q + e.code) mod R
// Не понимаю что делать дальше? Можно ли вынести (a.code * q + b.code) за скобки? Или можно операцию mod R
