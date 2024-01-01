package basic_theory.algorithms.combinatorics.generate_permutations_without_duplicates
fun main() {
//    PermutationIterativeImpl().permute(intArrayOf(1,1,2)).forEach {
//        println(it)
//    }
}


/**
 * Строим дерево рекурсий, и таким образом генерируем все перестановки.
 *
 * Алгоритм, не подходит для генерации перестановок с повторениями.
 *
 * */
class PermutationRecursiveImpl : Permutation {
    override fun permute(nums: IntArray): List<List<Int>> {
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