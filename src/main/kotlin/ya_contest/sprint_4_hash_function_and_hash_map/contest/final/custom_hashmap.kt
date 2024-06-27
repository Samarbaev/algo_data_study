package ya_contest.sprint_4_hash_function_and_hash_map.contest.final

/**
 * https://contest.yandex.ru/contest/24414/run-report/110921766/
 *
 * 1) Общая информация
 * Решение коллизий через метод цепочек
 * Хранилище данных - массив table.
 * Элементы массива - объекты Entry, содержащие ключ, значение и ссылку на следующий элемент (для разрешения коллизий).
 * Начальный размер массива - 16, коэффициент заполнения - 0.75.
 *
 * 2) Добавление пары ключ-значение:
 * Рассчитывается индекс в массиве на основе хэш-кода ключа.
 * Если по индексу уже есть элемент: проверяется, совпадает ли его ключ с добавляемым.
 * При совпадении обновляется значение. При несовпадении новый элемент добавляется в связный список по этому индексу.
 * Если по индексу нет элементов, создается новый и помещается в массив.
 * Увеличивает размер (size) и, если необходимо, перераспределяет элементы (increaseCapacity)
 *
 * 3) Получение значения по ключу:
 * Рассчитывается индекс в массиве.
 * Проходится по цепочке элементов по этому индексу, пока не найдется элемент с нужным ключом.
 * Если элемент не найден, возвращается null.
 *
 * 4) Удаление пары по ключу:
 * Рассчитывается индекс в массиве.
 * Проходится по цепочке элементов по этому индексу, пока не найдется элемент с нужным ключом:
 * При совпадении удаляется из цепочки. Уменьшает размер (size).
 *
 * 5) Перераспределение элементов (increaseCapacity):
 * Создается новый массив вдвое большего размера.
 * Все элементы из старого массива перераспределяются по новому массиву, учитывая их хэш-коды и новый размер.
 * Старый массив заменяется новым.
 *
 * Временная оценка операций:
 *
 * Средний случай:
 * put: O(1) - поиск места в массиве, добавление элемента.
 * get: O(1) - поиск элемента в массиве.
 * delete: O(1) - поиск элемента в массиве, удаление из цепочки.
 *
 * Худший случай:
 * put: O(n) - при коллизиях, когда много элементов имеют одинаковый хэш-код, поиск места может занять время, пропорциональное количеству элементов в цепочке.
 * get: O(n) - при коллизиях, поиск элемента может занять время, пропорциональное количеству элементов в цепочке.
 * delete: O(n) - при коллизиях, поиск элемента может занять время, пропорциональное количеству элементов в цепочке.
 *
 * Оценка по памяти -  O(n)
 **/
class BasicHashMap<K, V>(private val capacity: Int = 16, private val loadFactor: Double = 0.75) {

    private data class Entry<K, V>(val key: K, var value: V, var next: Entry<K, V>? = null)

    private var table: Array<Entry<K, V>?> = Array(capacity) { null }
    private var size = 0

    init {
        require(loadFactor < 1.0) { "Load factor can't be more than 1.0, but it's set to $loadFactor" }
    }

    fun put(key: K, value: V) {
        findEntry(key) { entry, _, index ->

            if (entry != null) {
                entry.value = value
            } else {
                val newEntry = Entry(key, value)
                newEntry.next = table[index]
                table[index] = newEntry
                size++
            }
        }

        if (shouldIncreaseCapacity()) {
            increaseCapacity()
        }
    }

    fun get(key: K): V? {
        return findEntry(key) { entry, _, _ ->
            entry?.value
        }
    }

    fun delete(key: K): V? {
        findEntry(key) { entry, prevEntry, index ->
            if (entry != null) {
                if (prevEntry == null) {
                    table[index] = entry.next
                } else {
                    prevEntry.next = entry.next
                }
                size--
                return entry.value
            }
            return null
        }
    }


    private inline fun <R> findEntry(key: K, body: (entry: Entry<K, V>?, prevEntry: Entry<K, V>?, index: Int) -> R): R {
        var prevEntry: Entry<K, V>? = null
        val index = (key.hashCode() and Int.MAX_VALUE) % table.size
        var entry = table[index]

        while (entry != null) {
            if (entry.key == key) {
                return body(entry, null, index)
            }
            prevEntry = entry
            entry = entry.next
        }
        return body(null, prevEntry, index)
    }

    private fun shouldIncreaseCapacity(): Boolean {
        return size >= table.size * loadFactor
    }

    private fun increaseCapacity() {
        val newCapacity = table.size * 2
        val newTable: Array<Entry<K, V>?> = Array(newCapacity) { null }

        for (i in table.indices) {
            var entry = table[i]

            while (entry != null) {
                val index = (entry.key.hashCode() and Int.MAX_VALUE) % table.size
                val newIndex = index and (newCapacity - 1)
                val next = entry.next

                entry.next = newTable[newIndex]
                newTable[newIndex] = entry

                entry = next
            }
        }

        table = newTable
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val map = BasicHashMap<Int, Int>(n)
    val output = StringBuilder()

    for (i in 0 until n) {
        val cmd = readLine()!!.split(" ")
        when (cmd[0]) {
            "get" -> output.appendLine(map.get(cmd[1].toInt()) ?: "None")
            "put" -> map.put(cmd[1].toInt(), cmd[2].toInt())
            "delete" -> output.appendLine(map.delete(cmd[1].toInt()) ?: "None")
        }
    }
    print(output.toString())
}
