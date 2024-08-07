package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Чтобы подготовиться к семинару, Гоше надо прочитать статью по эффективному менеджменту.
 * Так как Гоша хочет спланировать день заранее, ему необходимо оценить сложность статьи.
 * Он придумал такой метод оценки: берётся случайное предложение из текста и в нём ищется самое длинное слово. Его длина и будет условной сложностью статьи.
 * Помогите Гоше справиться с этой задачей.
 *
 * Формат ввода:
 * В первой строке дана длина текста L (1 ≤ L ≤ 105).
 * В следующей строке записан текст, состоящий из строчных латинских букв и пробелов. Слово —– последовательность букв, не разделённых пробелами. Пробелы могут стоять в самом начале строки и в самом её конце. Текст заканчивается переносом строки, этот символ не включается в число остальных L символов.
 *
 * Формат вывода:
 * В первой строке выведите самое длинное слово. Во второй строке выведите его длину.
 * Если подходящих слов несколько, выведите то, которое встречается раньше.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * 19
 * i love segment tree
 * Вывод
 * segment
 * 7
 *
 * Пример 2:
 * Ввод
 * 21
 * frog jumps from river
 * Вывод
 * jumps
 * 5
 */

private fun main() {
    val n = readln().toInt()
    val string = readln()
    val theLongestWord = string.trim().split(' ').maxByOrNull { it.length }
    println(theLongestWord)
    println(theLongestWord?.length)
}