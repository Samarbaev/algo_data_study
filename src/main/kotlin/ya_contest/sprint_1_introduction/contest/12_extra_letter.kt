package ya_contest.sprint_1_introduction.contest

/***
 * Условие:
 * Васе очень нравятся задачи про строки, поэтому он придумал свою. Есть 2 строки s и t, состоящие только из строчных букв.
 * Строка t получена перемешиванием букв строки s и добавлением 1 буквы в случайную позицию. Нужно найти добавленную букву.
 *
 * Формат ввода:
 * На вход подаются строки s и t, разделённые переносом строки. Длины строк не превосходят 1000 символов.
 * Строки не бывают пустыми.
 *
 * Формат вывода:
 * Выведите лишнюю букву.
 *
 * Ограничение:
 * Ограничение времени - 1 секунда
 * Ограничение памяти - 64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод стандартный вывод или output.txt
 *
 * Пример 1:
 * Ввод
 * abcd
 * abcde
 * Вывод
 * e
 *
 * Пример 2:
 * Ввод
 * go
 * ogg
 * Вывод
 * g
 */

private fun main() {
    val original = readln()
    val changeOriginal = readln()
    isExtraCharacter(original, changeOriginal)
}

private fun isExtraCharacter(first: String, second: String) {
    val counterChars = IntArray(26) { 0 }

    for (index in first.indices) {
        counterChars[first[index] - 'a']++
    }
    for (index in second.indices) {
        if(counterChars[second[index] - 'a'] == 0) {
            println(second[index])
            break
        } else {
            counterChars[second[index] - 'a']--
        }
    }
}
