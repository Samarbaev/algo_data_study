package ya_contest.sprint_3_sorts_and_recursion.notes.sorts.bubble_sort

import ya_contest.sprint_3_sorts_and_recursion.notes.sorts.swap


fun IntArray.bubbleSortWithoutOptimization() {
    for (i in 0..this.size - 2) {
        for (j in 0..this.size - 2) {
            if (this[j] > this[j + 1]) {
                this.swap(
                    index1 = j,
                    index2 = j + 1
                )
            }
        }
    }
}

fun IntArray.bubbleSortFirstOptimization() {
    for (i in 0..this.size - 2) {
        for (j in 0..this.size - i - 2) {
            if (this[j] > this[j + 1]) {
                this.swap(
                    index1 = j,
                    index2 = j + 1
                )
            }
        }
    }
}

fun IntArray.bubbleSortSecondOptimization() {
    var i = 0
    var isExchange = true
    while (isExchange) {
        isExchange = false
        for (j in 0..this.size - i - 2) {
            if (this[j] > this[j + 1]) {
                this.swap(j, j + 1)
                isExchange = true
            }
        }
        i++
    }
}