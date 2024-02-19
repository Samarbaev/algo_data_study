package theory.algorithms.combinatorics.generate_permutations


/**
 * Строим дерево рекурсий, и таким образом генерируем все перестановки.
 *
 * Алгоритм, не подходит для генерации перестановок с повторениями.
 *
 * */
class PermutationRecursiveImpl : Permutation {
    override fun generatePermute(nums: IntArray): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = ArrayList()
        generatePermutation(ArrayList(), ans, nums)
        return ans
    }

    private fun generatePermutation(
        cur: MutableList<Int>,
        ans: MutableList<MutableList<Int>>,
        nums: IntArray
    ) {
        if(cur.size == nums.size) {
            ans.add(ArrayList(cur))
            return
        }
        for (num in nums) {
            if (!cur.contains(num)) {
                cur.add(num)
                generatePermutation(cur, ans, nums)
                cur.removeAt(cur.size - 1)
            }
        }
    }
}