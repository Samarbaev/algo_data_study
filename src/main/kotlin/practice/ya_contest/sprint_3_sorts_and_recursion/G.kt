package practice.ya_contest.sprint_3_sorts_and_recursion

/**
 * Условие:
 * Рита решила оставить у себя одежду только трёх цветов: розового, жёлтого и малинового.
 * После того как вещи других расцветок были убраны, Рита захотела отсортировать свой новый гардероб по цветам.
 * Сначала должны идти вещи розового цвета, потом —– жёлтого, и в конце —– малинового. Помогите Рите справиться с этой задачей.
 * Примечание: попробуйте решить задачу за один проход по массиву!
 *
 * Формат ввод:
 * В первой строке задано количество предметов в гардеробе: n –— оно не превосходит 1000000.
 * Во второй строке даётся массив, в котором указан цвет для каждого предмета.
 * Розовый цвет обозначен 0, жёлтый —– 1, малиновый –— 2.
 *
 * Формат вывода:
 * Нужно вывести в строку через пробел цвета предметов в правильном порядке.
 *
 * Testcase:
 * Ввод
 * 7
 * 0 2 1 2 0 0 1
 * Вывод
 * 0 0 0 1 1 2 2
 * */

fun main() {
    val size = readln().toInt()
    if (size == 0) return
    val objects = readln().split(" ").map { it.toInt() }
    println(countObject(objects).joinToString(" "))

}

fun countObject(objects: List<Int>): List<Int> {
    val counter = IntArray(3)
    val result = mutableListOf<Int>()

    for (element in objects) {
        counter[element]++
    }

    for (i in counter.indices) {
        for (j in counter[i] downTo 1) {
            result.add(i)
        }
    }

    return result
}