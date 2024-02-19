package theory.algorithms.combinatorics.generate_combinations

/**
 * Итеративная реализация генерации всех сочетаний с повторениями из n по k
 *
 * */
class CombinationWithDuplicateImpl : Combination {

    override fun generateCombine(n: Int, k: Int): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        val firstCombination = MutableList(size = k) { 0 }
        for (i in 0 until k) {
            firstCombination[i] = 1
        }
        val first = firstCombination.toList()
        ans.add(first.toMutableList())

        while (true) {
            val cur = nextCombine(firstCombination, n, k)
            if (cur.isNullOrEmpty()) {
                break
            } else {
                ans.add(cur.toMutableList())
            }
        }

        return ans
    }

    /**
     * 1) Начинаем итерироваться с j = k - 1, так как массив начинается с 0-ого элемента
     * 2) Уменьшает j на 1, пока выполняется условие j >= 0 && curCombination[j] >= n
     *    Таким образом, мы проверяем, что элемент на j-ой позиции больше либо равен максимлаьного n
     *    Значит, нужно j--
     * 3) Проверяем условие, если j < 0 => return null
     *    Таким образом, мы проверяем, что все цифры в сочетании уже были выбраны
     * 4) Увеличиваем curCombination[j]++
     * 5) Если j == k - 1 => return curCombination
     * 6) Далее в цикле с m = j + 1 .. k =>  curCombination[m] = curCombination[j]
     * 7) Возвращаем curCombination
     *
     * */
    override fun nextCombine(curCombination: MutableList<Int>, n: Int, k: Int): List<Int>? {
        var j = k - 1
        while (j >= 0 && curCombination[j] >= n) {
            j--
        }
        if (j < 0) return null

        curCombination[j]++

        if (j == k - 1) return curCombination

        for (m in j + 1 until k) {
            curCombination[m] = curCombination[j]
        }
        return curCombination

    }

}