package practice.ya_contest.sprint_3_sorts_and_recursion.final

// https://contest.yandex.ru/contest/23815/run-report/108312360/

/**
 * Time complexity: Амортизационно 0(N * log(N))
 * Space comlexity: 0(1)
 *
 */


/**
 * Класс, который хранит информацию об участнике
 *
 * */
data class Participant(
    val user: String,
    val tasks: Int,
    val errors: Int,
)

/**
 * Преобразуем строку в объект Participant
 * */
fun String.toParticipant(): Participant {
    val (user, tasks, errors) = this.split(" ")
    return Participant(user = user, tasks = tasks.toInt(), errors = errors.toInt())
}

/**
 * Функция для обмена - поменять местами элементы в массиве
 * */


/**
 * Реализация быстрой сортировки через компаратор, поскольку много условий, по которым нужно сортировать участников, компаратор
 * отличного для этого подходит.
 *
 * Разделяем входной массив на два виртуальныx, под виртуальным будем понимать, что не храним в памяти подмассивы, а просто
 * храним ссылку на элемент
 *
 * После этого рекурсивно вызываем функцию сортировки
 *
 * И каждый раз проверяем что startIndex < endIndex
 * */

class QuickSort<T>(
    private val participants: MutableList<T>,
    private val comparator: Comparator<in T>,
) {
    fun quickSort(
        startIndex: Int = 0,
        endIndex: Int = participants.size - 1,
    ) {
        if (startIndex < endIndex) {
            val pivotIndex = partition(startIndex, endIndex)
            quickSort(startIndex, pivotIndex - 1)
            quickSort(pivotIndex + 1, endIndex)
        }
    }

    /**
     * participants - это изменяемый список (MutableList) объектов Participant, которые должны быть разделены.
     * comparator - это компаратор, используемый для сравнения элементов в списке participants.
     * startIndex и endIndex представляют диапазон индексов, который нужно учесть при разделении.
     * функция выбирает pivot, который определяется как элемент с индексом endIndex.
     * Инициализируется переменная i со значением startIndex - 1.
     * Происходит цикл for, который перебирает индексы от startIndex до endIndex - 1.
     * Внутри цикла, если элемент с индексом j меньше или равно пивоту на основе компаратора, то инкрементируется i и выполняется замена элементов с индексами i и j в списке participants.
     * По окончании цикла, pivot устанавливается на свою конечную позицию путем замены его с элементом с индексом i + 1.
     * В конце функция возвращает индекс pivot в отсортированном списке
     * */
    private fun partition(
        startIndex: Int,
        endIndex: Int
    ): Int {
        val pivot = participants[endIndex]
        var start = startIndex
        var end = endIndex - 1

        while (start <= end) {
            while (start <= end && comparator.compare(participants[start], pivot) <= 0) {
                start++
            }

            while (start <= end && comparator.compare(participants[end], pivot) > 0) {
                end--
            }

            if (start < end) {
                participants.swap(start, end)
            }
        }

        participants.swap(start, endIndex)
        return start
    }

    private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }
}


fun main() {
    val participantComparator = compareBy<Participant>(
        { -it.tasks },
        { it.errors },
        { it.user }
    )
    val participantsCount = readLine()!!.toInt()
    MutableList(participantsCount) { readLine()!!.toParticipant() }
        .also { participants -> QuickSort(participants, participantComparator).quickSort() }
        .forEach { println(it.user) }
}