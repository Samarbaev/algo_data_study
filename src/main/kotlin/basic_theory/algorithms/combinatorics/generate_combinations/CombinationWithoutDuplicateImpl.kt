package basic_theory.algorithms.combinatorics.generate_combinations


/**
 * Итеративная реализация генерации всех сочетаний из n по k
 *
 * */
class CombinationWithoutDuplicateImpl : Combination {

    override fun combine(n: Int, k: Int): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        val firstCombination = MutableList(size = k) { 0 }
        for (i in 0 until k) {
            firstCombination[i] = i + 1
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
        for (i in k - 1 downTo  0) {
            if (combination[i] < n - k + i + 1) {
                ++combination[i]
                for (j in i + 1 until k) {
                    combination[j] = combination[j - 1] + 1
                }
                return combination
            }
        }
        return null
    }
}