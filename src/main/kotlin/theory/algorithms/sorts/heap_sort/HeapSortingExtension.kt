package theory.algorithms.sorts.heap_sort

import java.util.PriorityQueue


fun IntArray.heapSortWithStdBinaryHeap() {
    val heap = PriorityQueue(this.toMutableList())

    for (j in 0 until this.size) {
        this[j] = heap.peek()
        heap.remove(heap.peek())
    }
}