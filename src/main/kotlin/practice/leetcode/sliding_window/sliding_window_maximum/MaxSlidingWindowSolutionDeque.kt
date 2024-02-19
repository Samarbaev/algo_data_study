package practice.leetcode.sliding_window.sliding_window_maximum

import java.util.*

/***
 * 1. Создается пустая очередь `deque` (двусвязный список) и массив `result` для хранения результатов. Размер массива `result` вычисляется как `nums.size - k + 1`, так как для каждого окна размером `k` будет один результат.
 * 2. Первый цикл `for` выполняется для первого окна. Используя переменную `i`, происходит перебор элементов с индексами от 0 до `k-1`.
 * Внутренний цикл `while` проверяет, есть ли элементы в очереди `deque` и является ли текущий элемент (`nums[i]`) больше или равен последнему элементу в очереди (`nums[deque.peekLast()]`).
 * Если это верно, то последний элемент удаляется из очереди, так как он больше не является потенциальным кандидатом быть максимальным значением в окне.
 * Затем текущий индекс `i` добавляется в конец очереди `deque`.
 * После окончания цикла, первый элемент в очереди `deque` будет являться максимальным элементом в первом окне. Значение этого элемента помещается в `result[0]`.
 * 3. Создается переменная `count`, которая используется для индексации элементов в массиве `result`. Ее начальное значение задается как 1, так как первый максимальный элемент уже был помещен в `result[0]`.
 * 4. Второй цикл `for` начинается с индекса `k` и продолжается до конца массива `nums`.
 * Первым шагом проверяется условие `if`, чтобы узнать, если первый элемент в очереди `deque` равен `i - k`. Если это верно, это означает, что первый элемент в очереди находится за пределами текущего окна и должен быть удален.
 * Затем выполняется внутренний цикл `while`, который проверяет, есть ли элементы в очереди `deque` и является ли текущий элемент (`nums[i]`) больше или равен последнему элементу в очереди (`nums[deque.peekLast()]`). Если это верно, последний элемент удаляется, так как он больше не является потенциальным кандидатом на быть максимальным значением в окне.
 * Текущий индекс `i` добавляется в конец очереди `deque`.
 * Значение первого элемента в очереди `deque` становится максимальным значением для текущего окна. Значение этого элемента добавляется в `result[count]`.
 * Затем переменная `count` увеличивается на 1.
 * 5. В конце функции массив `result` возвращается как результирующий массив, содержащий максимальные значения для каждого окна.
 *
 *
 * 1. An empty queue `deque` (doubly linked list) and an array `result` are created to store the results. The size of the `result` array is calculated as `nums.size - k + 1`, since there will be one result for each window of size `k`.
 * 2. The first `for` loop is executed for the first window. Using the variable `i`, the elements with indices from 0 to `k-1` are iterated.
 * The inner `while` loop checks whether there are elements in the `deque` queue and whether the current element (`nums[i]`) is greater than or equal to the last element in the queue (`nums[deque.peekLast()]`).
 * If this is true, then the last element is removed from the queue since it is no longer a potential candidate to be the maximum value in the window.
 * The current index `i` is then added to the end of the `deque` queue.
 * After the loop ends, the first element in the `deque` queue will be the maximum element in the first window. The value of this element is placed in `result[0]`.
 * 3. A `count` variable is created, which is used to index the elements in the `result` array. Its initial value is set to 1, since the first maximum element has already been placed in `result[0]`.
 * 4. The second `for` loop starts at index `k` and continues until the end of the `nums` array.
 * The first step is to check the `if` condition to see if the first element in the `deque` queue is `i - k`. If this is true, it means that the first element in the queue is outside the current window and should be removed.
 * The inner `while` loop is then executed to check whether there are elements in the `deque` queue and whether the current element (`nums[i]`) is greater than or equal to the last element in the queue (`nums[deque.peekLast()] `). If this is true, the last element is removed since it is no longer a potential candidate to be the maximum value in the window.
 * The current index `i` is added to the end of the `deque` queue.
 * The value of the first element in the `deque` queue becomes the maximum value for the current window. The value of this element is added to `result[count]`.
 * Then the `count` variable is incremented by 1.
 * 5. At the end of the function, the `result` array is returned as a result array containing the maximum values for each window.
 *
 * Time complexity: O(n)
 * Space complexity: O(k), where k is deque size
 */
class MaxSlidingWindowSolutionDeque {

    // peek - get index element from deque
    // poll - get and extract index element from deque

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque: Deque<Int> = LinkedList()
        val result = IntArray(nums.size - k + 1)
        for (i in 0 until k) {
            // если есть элемент в текущей итерации больше или равен, чем текущий в очереди
            // смысла хранить его в очереди - нет
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast()
            }
            // добавляем элемент в конец очереди
            deque.offerLast(i)
        }
        // добавляем первый элемент из очереди в результирующий ответ
        result[0] = nums[deque.peekFirst()]
        // нулевой элемент добавили в результат => следующий будет с 1ого
        var count = 1
        // в списке элементов с 0-ого до k-ого - максимум найдет, теперь нужно двигать окно с позиции k
        // пока не дойдет до последнего элемента
        for (i in k until nums.size) {
            // если условие выполняется, то это значит, что первый элемент в очереди находится за пределами текущего окна
            // его необходио удалить
            if (deque.peekFirst() == i - k) {
                deque.pollFirst()
            }
            // если очередь не пустая и текущий элемент больше посленего добавленного,то
            // мы его может без проблем удалить
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast()
            }
            // добавляет элемент в очередб
            deque.offerLast(i)
            // добавляем максимальный элемент и результирующий массив
            result[count] = nums[deque.peekFirst()]
            // увеличиваем счетчик
            ++count
        }
        // возвращаем результат
        return result
    }
}