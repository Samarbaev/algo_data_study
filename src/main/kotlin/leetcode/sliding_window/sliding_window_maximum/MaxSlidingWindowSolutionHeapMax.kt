package leetcode.sliding_window.sliding_window_maximum

import java.util.PriorityQueue

/***
 * Нужно извлекать максимальный элемент. За 0(1) с этой задачей справляется Heap.
 * Для решения этой задачки попробуем использовать эту структуру данных
 * Идея заключается в том, чтобы добавить все элементы от 0 до k в sliding window и после этого
 * двигать границы этого окна и извлекать максимальный элемент из текущего окна.
 *
 * To extract the maximum element, we can use a Heap data structure, which can handle this task in O(1) time complexity.
 * To solve this problem, let's try using this data structure.
 * The idea is to initially add all elements from 0 to k into the sliding window.
 * Then, we move the boundaries of this window and extract the maximum element from the current window.
 *
 * Time complexity:
 * Space complexity:
 */
class MaxSlidingWindowSolutionHeapMax : MaxSlidingWindow {

    override fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val heapMax = PriorityQueue<Int>() { a, b -> b - a }
        val resultMaxArray = IntArray(nums.size - (k - 1))

        for (i in 0 until k) heapMax.add(nums[i])

        var left = 0
        while (left <= nums.size - k) {
            resultMaxArray[left] = heapMax.peek()
            heapMax.remove(nums[left])

            if(left + k < nums.size) heapMax.add(nums[left + k])
            ++left
        }
        return resultMaxArray
    }
}