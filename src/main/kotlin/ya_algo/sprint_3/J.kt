package ya_algo.sprint_3

import java.util.LinkedList

/**
 * Любимый вариант очереди Тимофея — очередь, написанная с использованием связного списка. Помогите ему с реализацией. Очередь должна поддерживать выполнение трёх команд:
 *
 * get() — вывести элемент, находящийся в голове очереди, и удалить его. Если очередь пуста, то вывести «error».
 * put(x) — добавить число x в очередь
 * size() — вывести текущий размер очереди
 *
 * */

fun main() {
    val number = readLine()?.toIntOrNull() ?: 0
    val queue = QueueOnLinkedListImpl()
    val ans = StringBuilder()

    repeat(number) {
        val input = readLine() ?: ""
        val command = input.split(" ")

        when (command.getOrNull(0)) {
            "get" -> {
                val result = queue.get()
                ans.append(result?.toString() ?: "error").append('\n')
            }
            "put" -> queue.put(command.getOrNull(1)?.toIntOrNull() ?: 0)
            "size" -> ans.append(queue.size()).append('\n')
        }
    }

    print(ans)
}


class QueueOnLinkedListImpl {
    private val linkedList: LinkedList<Int> = LinkedList()

    fun get(): Int? {
        return linkedList.removeLastOrNull()
    }

    fun put(x: Int) {
        linkedList.addFirst(x)
    }

    fun size(): Int {
        return linkedList.size
    }
}