package ya_contest.sprint_3_sorts_and_recursion.contest

/**
 * Условие:
 * На IT-конференции присутствовали студенты из разных вузов со всей страны.
 * Для каждого студента известен ID университета, в котором он учится.
 * Тимофей предложил Рите выяснить, из каких k вузов на конференцию пришло больше всего учащихся.
 *
 * Формат ввода:
 * В первой строке дано количество студентов в списке —– n (1 ≤ n ≤ 15 000).
 * Во второй строке через пробел записаны n целых чисел —– ID вуза каждого студента.
 * Каждое из чисел находится в диапазоне от 0 до 10 000.
 * В третьей строке записано одно число k.
 *
 * Формат вывода:
 * Выведите через пробел k ID вузов с максимальным числом участников.
 * Они должны быть отсортированы по убыванию популярности (по количеству гостей от конкретного вуза).
 * Если более одного вуза имеет одно и то же количество учащихся, то выводить их ID нужно в порядке возрастания.
 *
 * Testcase:
 * Ввод
 * 7
 * 1 2 3 1 2 3 4
 * 3
 * Вывод
 * 1 2 3
 * */

fun main() {
    val size = readln().toInt()
    val students = readLine()!!.split(" ").map { it.toInt() }
    val k = readLine()!!.toInt()
    countMaxKey(students, k)
}

fun countMaxKey(lists: List<Int>, k: Int) {
    val map = mutableMapOf<Int, Int>()

    for(list in lists) {
        map[list] = map.getOrDefault(list, 0) + 1
    }

    val sortedMap = map.toList().sortedWith(
        compareByDescending<Pair<Int, Int>> { it.second }
            .thenBy { it.first }
    )
    sortedMap.take(k).map { it.first }.also {println(it.joinToString(" "))}

}