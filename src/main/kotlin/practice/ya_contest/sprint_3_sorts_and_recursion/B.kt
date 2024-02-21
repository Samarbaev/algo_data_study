package practice.ya_contest.sprint_3_sorts_and_recursion

/**
 * Условие:
 * На клавиатуре старых мобильных телефонов каждой цифре соответствовало несколько букв. Примерно так:
 * 2:'abc', 3:'def', 4:'ghi', 5:'jkl', 6:'mno', 7:'pqrs', 8:'tuv', 9:'wxyz'
 * Вам известно в каком порядке были нажаты кнопки телефона, без учета повторов.
 * Напечатайте все комбинации букв, которые можно набрать такой последовательностью нажатий.
 *
 * Формат ввода:
 * На вход подается строка, состоящая из цифр 2-9 включительно. Длина строки не превосходит 10 символов.
 *
 * Формат вывода:
 * Выведите все возможные комбинации букв через пробел в лексикографическом (алфавитном) порядке по возрастанию.
 *
 * Testcase:
 *
 * Ввод
 * 23
 * Вывод
 * ad ae af bd be bf cd ce cf
 *
 * */


fun main() {
    val digits = readln()
    val result = mutableListOf<String>()
    val alphabet = listOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    generateCombine(digits, alphabet, result, "")
    println(result.joinToString(" "))

}

fun generateCombine(digits: String, alphabet: List<String>, result: MutableList<String>, current: String) {
    if(current.length == digits.length) {
        result.add(current)
        return
    }

    for(letter in alphabet[digits[current.length].digitToInt()]) {
        generateCombine(digits, alphabet, result, "$current$letter")
    }
}