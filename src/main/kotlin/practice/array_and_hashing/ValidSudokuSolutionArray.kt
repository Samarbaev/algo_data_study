package practice.array_and_hashing

/***
 * Заводим 3 булевых массива, на каждую строку, на каждый столбец и на каждый квадрат, размеров 3х3
 * И дальше идем по массиву и проверяем, если символ не точка, то нужно проверить, а встречалась ли эта цифра, если встречалась, то
 * возвращаем false. И эту проверку нужно сделать для строки, столбца и квадрата 3х3.
 * Если вышли из цикла, то возвращаем true
 *
 * Then we iterate over the array and check if the character is not a dot. If it is not a dot, we need to check if this digit has been encountered before.
 * If it has been encountered, we return false. We need to perform this check for the row, column, and the 3x3 square.
 * If we exit the loop, we return true.
 */

class ValidSudokuSolutionArray : ValidSudoku {
    override fun isValidSudoku(board: Array<CharArray>): Boolean {
        val size = 9
        val iWasDigit = Array(size) { BooleanArray(size) { false } }
        val jWasDigit = Array(size) { BooleanArray(size) { false } }
        val ijWasDigit = Array(size / 3) { Array(size / 3) { BooleanArray(size) { false } } }

        for (i in board.indices) {
            for (j in board.indices) {
                val char = board[i][j]
                if (char == '.') {
                    continue
                }
                val digit = char - '1'
                if (iWasDigit[i][digit]) {
                    return false
                }
                iWasDigit[i][digit] = true

                if (jWasDigit[j][digit]) {
                    return false
                }
                jWasDigit[j][digit] = true
                if (ijWasDigit[i / 3][j / 3][digit]) {
                    return false
                }
                ijWasDigit[i / 3][j / 3][digit] = true
            }
        }
        return true
    }
}