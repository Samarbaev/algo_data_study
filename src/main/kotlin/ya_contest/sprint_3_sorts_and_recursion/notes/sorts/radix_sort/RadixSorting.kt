package ya_contest.sprint_3_sorts_and_recursion.notes.sorts.radix_sort

fun IntArray.radixSort(): IntArray {
    var result = this
    val max = max()

    var place = 1
    while (max / place > 0) {
        result = result.countingSort(place)
        place *= 10
    }

    return result
}

fun IntArray.countingSort(place: Int): IntArray {
    val result = IntArray(size)
    val count = IntArray(10)

    for (i in result.indices) {
        val digit = (this[i] / place) % 10
        count[digit] += 1
    }

    for (i in 1 until count.size) {
        count[i] += count[i - 1]
    }

    for (i in size - 1 downTo 0) {
        val digit = (this[i] / place) % 10
        result[count[digit] - 1] = this[i]
        count[digit]--
    }

    return result
}

fun IntArray.max(): Int {
    var max = Int.MIN_VALUE
    for (i in 1 until size - 1)
       max = maxOf(max, this[i])
    return max
}