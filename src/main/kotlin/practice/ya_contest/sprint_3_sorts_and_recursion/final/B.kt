package practice.ya_contest.sprint_3_sorts_and_recursion.final

// https://contest.yandex.ru/contest/23815/run-report/108273632/

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
    val str = this.split(" ")
    return Participant(user = str[0], tasks = str[1].toInt(), errors = str[2].toInt())
}

/**
 * Функция для обмена - поменять местами элементы в массиве
 * */
fun MutableList<Participant>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

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
fun quickSort(
    participants: MutableList<Participant>,
    comparator: Comparator<in Participant>,
    startIndex: Int,
    endIndex: Int,
) {
    if (startIndex < endIndex) {
        val pivotIndex = partition(participants, comparator, startIndex, endIndex)
        quickSort(participants, comparator, startIndex, pivotIndex - 1)
        quickSort(participants, comparator, pivotIndex + 1, endIndex)
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
fun partition(
    participants: MutableList<Participant>,
    comparator: Comparator<in Participant>,
    startIndex: Int,
    endIndex: Int
): Int {
    val pivot = participants[endIndex]
    var i = startIndex - 1

    for (j in startIndex until endIndex) {
        if (comparator.compare(participants[j], pivot) <= 0) {
            i++
            participants.swap(i, j)
        }
    }

    participants.swap(i + 1, endIndex)
    return i + 1
}

fun main() {
    /**
     * Создаем компаратор
     * */
    val participantComparator = Comparator<Participant> { p1, p2 ->
        when {
            p1.tasks > p2.tasks -> -1
            p1.tasks < p2.tasks -> 1
            p1.errors > p2.errors -> 1
            p1.errors < p2.errors -> -1
            else -> p1.user.compareTo(p2.user)
        }
    }
    val number = readLine()!!.toInt()
    val competitors = mutableListOf<Participant>()
    repeat(number) {
        val inputCompetitor = readLine()!!.toParticipant()
        competitors.add(inputCompetitor)
    }
    val left = 0
    quickSort(competitors, participantComparator, left, competitors.size - 1)
    competitors.forEach { println(it.user) }
}