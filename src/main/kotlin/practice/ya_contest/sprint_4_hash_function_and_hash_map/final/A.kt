package practice.ya_contest.sprint_4_hash_function_and_hash_map.final

/***
 * https://contest.yandex.ru/contest/24414/run-report/110687232/
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

fun main() {
    val countDocuments = readLine()!!.toInt()
    val documents = Array(countDocuments) { readLine()!! }

    val index = buildIndex(documents)

    val countQueries = readLine()!!.toInt()
    repeat(countQueries) {
        val query = readLine()!!
        val result = findMostRelevantDocuments(query, index)
        println(result.joinToString(" "))
    }
}

fun buildIndex(documents: Array<String>): Map<String, List<Pair<Int, Int>>> {
    val index = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
    documents.forEachIndexed { docId, text ->
        val wordFrequency = text.split(" ").groupingBy { it }.eachCount()
        wordFrequency.forEach { (word, frequency) ->
            index.getOrPut(word) { mutableListOf() }.add(Pair(docId, frequency))
        }
    }
    return index
}

fun findMostRelevantDocuments(query: String, index: Map<String, List<Pair<Int, Int>>>): List<Int> {
    val relevanceScores = mutableMapOf<Int, Int>()
    query.split(" ").distinct().forEach { word ->
        index[word]?.forEach { (docId, frequency) ->
            relevanceScores[docId] = relevanceScores.getOrDefault(docId, 0) + frequency
        }
    }
    return relevanceScores.toList().sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first }).map { it.first + 1 }.take(5)
}