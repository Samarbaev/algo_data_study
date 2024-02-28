package practice.ya_contest.sprint_3_sorts_and_recursion.final

// https://contest.yandex.ru/contest/23815/run-report/107750012/
/**
 * Алгоритм начинается с установки текущих значений left и right, которые образуют полуинтервал, где выполняется поиск. Затем цикл продолжается до тех пор, пока полуинтервал right - left больше 1. Внутри цикла находится переменная middle, которая является индексом среднего элемента текущего полуинтервала.
 * Если элемент с индексом middle равен target, то функция возвращает индекс middle.
 * Далее выполняется проверка: если arr[middle] >= arr[left + 1], то левая часть полуинтервала (от left до middle) имеет правильный порядок элементов, иначе правая часть полуинтервала (от middle до right) имеет правильный порядок элементов.
 * В зависимости от результата проверки, функция изменяет значение left или right таким образом, чтобы новый полуинтервал содержал элемент target. Если цикл завершается, не найдя элемент target, то функция возвращает -1.
 * Таким образом, этот алгоритм использует модифицированный двоичный поиск для поиска элемента target в искаженном (неправильно переставленном) массиве arr.
 * */

/**
 * Time complexity - O(log(n))
 * Space complexity - 0(1)
 * */

object Solution {
    fun brokenSearch(arr: IntArray, target: Int): Int {
        var left = -1
        var right = arr.size

        while (right - left > 1) {
            val middle = left + (right - left) / 2

            if (arr[middle] == target) {
                return middle
            }

            if (arr[middle] >= arr[left + 1]) {
                if (target >= arr[left + 1] && target < arr[middle]) {
                    right = middle;
                } else {
                    left = middle;
                }
            } else {
                if (target <= arr[right - 1] && target > arr[middle]) {
                    left = middle
                } else {
                    right = middle
                }
            }
        }
        return -1
    }
}