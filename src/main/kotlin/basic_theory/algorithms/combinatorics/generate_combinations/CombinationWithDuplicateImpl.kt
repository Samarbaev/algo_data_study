package basic_theory.algorithms.combinatorics.generate_combinations

/**
 * Итеративная реализация генерации всех сочетаний с повторениями из n по k
 *
 * */
class CombinationWithDuplicateImpl : Combination {

    override fun combine(n: Int, k: Int): List<List<Int>> {
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

    private fun nextCombine(combination: MutableList<Int>, n: Int, k: Int): List<Int>? {
        var j = k - 1
        while (j >= 0 && combination[j] >= n) {
            j--
        }
        if (j < 0) return null

        combination[j]++

        if (j == k - 1) return combination

        for (m in j + 1 until k) {
            combination[m] = combination[j]
        }
        return combination

    }

}