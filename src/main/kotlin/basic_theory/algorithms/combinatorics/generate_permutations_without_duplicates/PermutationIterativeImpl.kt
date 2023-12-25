package basic_theory.algorithms.combinatorics.generate_permutations_without_duplicates

class PermutationIterativeImpl : Permutation {
    /**
     * Описание алгоритма:
     * Пусть a[] - массив исходных данных
     * 1) Ищем первый a[i] >= a[i+1] (идем с конца)
     * 2) Найти максимальный индекс j для которого а[j] >= a[i]
     * 3) поменять местами a[j] и a[i]
     * 4) повернуть хвост в обратном порядке
     * */
    override fun permute(nums: IntArray): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        nums.sort()
        ans.add(nums.toMutableList())
        while (true) {
            var i = nums.size - 2
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--
            }
            if (i < 0) {
                break
            }
            var k = nums.size - 1
            while (k >= 0 && nums[i] >= nums[k]) {
                k--
            }
            swap(nums, i, k)
            reversed(nums, i + 1, nums.size - 1)
            ans.add(nums.toMutableList())
        }
        return ans
    }

    private fun swap(array: IntArray, start: Int, end: Int) {
        val tmp = array[start]
        array[start] = array[end]
        array[end] = tmp
    }

    private fun reversed(array: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            swap(array, i, j)
            i++
            j--
        }
    }
}