package practice.ya_contest.sprint_4_hash_function_and_hash_map.final

/***
 * https://contest.yandex.ru/contest/24414/run-report/110397423/
 *
 * Работа алгоритма:
 * 1) Индексирование
 * Собираем перевернутый индекс. Он связывает слова с документами, где они встречаются.
 * Слово - это ключ, который помогает найти документ.
 * 2) Поиск
 * Вводим запрос - набор слов. Ищем для каждого слова из запроса документы в перевернутом индексе.
 * Считаем, сколько раз каждое слово из запроса встречается в документе.
 * Суммируем эти числа для всех слов из запроса. Полученная сумма - это релевантность документа.
 * Чем больше сумма, тем лучше документ соответствует запросу.
 * 3) Выдача:
 * Сортируем документы по убыванию релевантности.
 * Если релевантности совпадают, сортируем по возрастанию ID документа.
 *
 * Space complexity: O(nk)
 * Time complexity: O(nk) - индексирование, O(n * log(k)) - поиск.
 */

fun countIndices(files: List<List<String>>): Map<String, Map<Int, Int>> {
    val index = HashMap<String, HashMap<Int, Int>>()

    for ((filename, words) in files.withIndex()) {
        val wordCount = HashMap<String, Int>()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }

        for ((word, weight) in wordCount) {
            index.getOrPut(word) { HashMap() }[filename] = weight
        }
    }

    return index
}

fun handelQueries(index: Map<String, Map<Int, Int>>, string: String, limit: Int = 5, nDocs: Int = 10_000): List<Int> {
    val result = Array(nDocs) { intArrayOf(0, it) }

    for (word in string.split(" ").toSet()) {
        if (word in index.keys) {
            for ((filename, weight) in index[word]!!) {
                result[filename][0] += weight
            }
        }
    }

    val sortedDocs = result.filter { it[0] > 0 }
        .sortedByDescending { it[0] }
        .map { array -> ++array[1] }

    return sortedDocs.take(limit)
}


fun main() {
    val n = readln().toInt()
    val documents = mutableListOf<List<String>>()
    repeat(n) {
        val words = readln().split(" ")
        documents.add(words)
    }

    val searchIndex = countIndices(documents)

    val m = readln().toInt()
    repeat(m) {
        val query = readln()
        val result = handelQueries(searchIndex, query, limit = 5, nDocs = n + 1)
        println(result.joinToString(" "))
    }
}