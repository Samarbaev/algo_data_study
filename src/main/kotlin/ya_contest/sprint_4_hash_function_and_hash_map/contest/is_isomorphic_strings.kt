package ya_contest.sprint_4_hash_function_and_hash_map.contest

import java.util.*

/***
 * Условие:
 * Жители Алгосского архипелага придумали новый способ сравнения строк. Две строки считаются равными, если символы одной из них можно заменить на символы другой так, что первая строка станет точной копией второй строки. При этом необходимо соблюдение двух условий:
 * Порядок вхождения символов должен быть сохранён.
 * Одинаковым символам первой строки должны соответствовать одинаковые символы второй строки. Разным символам —– разные.
 * Например, если строка s = «abacaba», то ей будет равна строка t = «xhxixhx», так как все вхождения «a» заменены на «x», «b» –— на «h», а «c» –— на «i». Если же первая строка s=«abc», а вторая t=«aaa», то строки уже не будут равны, так как разные буквы первой строки соответствуют одинаковым буквам второй.
 *
 * Формат ввода:
 * В первой строке записана строка s, во второй –— строка t. Длины обеих строк не превосходят 106. Обе строки содержат хотя бы по одному символу и состоят только из маленьких латинских букв.
 * Строки могут быть разной длины.
 *
 * Формат вывода:
 * Выведите «YES», если строки равны (согласно вышеописанным правилам), и «NO» в ином случае.
 *
 * Testcase:
 * Ввод
 * mxyskaoghi
 * qodfrgmslc
 * Вывод
 * YES
 */

fun main() {
    val s = readLine()!!
    val t = readLine()!!
    if (isIsomorphic(s, t)) {
        println("YES")
    } else println("NO")

}

fun isIsomorphic(first: String, second: String): Boolean {
    if (first.length != second.length) return false

    val mapFirstToSecond = IntArray(256)
    Arrays.fill(mapFirstToSecond, -1)
    val mapSecondToFirst = IntArray(256)
    Arrays.fill(mapSecondToFirst, -1)

    for (index in first.indices) {
        val charFromFirstString = first[index]
        val charFromSecondString = second[index]

        if (mapFirstToSecond[charFromFirstString.code] == -1 && mapSecondToFirst[charFromSecondString.code] == -1) {
            mapFirstToSecond[charFromFirstString.code] = charFromSecondString.code
            mapSecondToFirst[charFromSecondString.code] = charFromFirstString.code
        } else if (!(mapFirstToSecond[charFromFirstString.code] == charFromSecondString.code && mapSecondToFirst[charFromSecondString.code] == charFromFirstString.code)) {
            return false
        }
    }
    return true
}
