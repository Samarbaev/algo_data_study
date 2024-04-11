package practice.ya_contest.sprint_4_hash_function_and_hash_map

/**
 * Условие:
 * Жители Алгосов любят устраивать турниры по спортивному программированию. Все участники разбиваются на пары и соревнуются друг с другом.
 * А потом два самых сильных программиста встречаются в финальной схватке, которая состоит из нескольких раундов.
 * Если в очередном раунде выигрывает первый участник, в таблицу с результатами записывается 0, если второй, то 1. Ничьей в раунде быть не может.
 * Нужно определить наибольший по длине непрерывный отрезок раундов, по результатам которого суммарно получается ничья.
 * Например, если дана последовательность 0 0 1 0 1 1 1 0 0 0, то раунды с 2-го по 9-й (нумерация начинается с единицы) дают ничью.
 *
 * Формат ввода:
 * В первой строке задаётся n (0 ≤ n ≤ 105) –— количество раундов. Во второй строке через пробел записано n чисел –— результаты раундов. Каждое число равно либо 0, либо 1.
 *
 * Формат вывода:
 * Выведите длину найденного отрезка
 *
 * Testcase:
 * Ввод:
 * 2
 * 0 1
 * Вывод:
 * 2
 * */
fun findLongestTieStreak(roundsResults: List<String>): Int {
    // Считаем количество очков
    var scoreDifference = 0
    // Запоминем текущий индекс
    var startIndex = -1
    // кладем в map в качестве ключа количество очков и индекс
    val indicesByScoreDifference = mutableMapOf<Int, Int>(scoreDifference to startIndex)
    // максимальная непрерывная длина
    var longestStreak = 0
    // идем по списку
    for ((index, result) in roundsResults.withIndex()) {
        // если текущее значение равно "0" -> scoreDifference = scoreDifference + 1
        // иначе scoreDifference = scoreDifference - 1
        scoreDifference += if (result == "0") 1 else -1

        // проверяем не содержится ли ключ scoreDifference в indicesByScoreDifference
        // если нет, то кладем ключ и текущий индекс
        if (scoreDifference !in indicesByScoreDifference) {
            indicesByScoreDifference[scoreDifference] = index
            continue
        }

        // Вычисляем текущую непрерывную длину
        val currentStreak = index - indicesByScoreDifference[scoreDifference]!!

        // проверяем текущая currentStreak больше longestStreak
        // если больше то  longestStreak = currentStreak
        //   startIndex = indicesByScoreDifference[scoreDifference]!! + 1
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak
            startIndex = indicesByScoreDifference[scoreDifference]!! + 1
        }
    }

    return longestStreak
}

fun main() {
    val n = readLine()!!.toInt()
    val strings = readLine()!!.split(" ")
    val result = findLongestTieStreak(strings)
    println(result)
}
