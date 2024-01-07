package basic_theory.algorithms.combinatorics.generate_permutations



/**
 * Описание алгоритма:
 *
 * Пусть a[] - массив исходных данных
 * 1) Ищем первый максимальный индекс i, для которого a[i] >= a[i+1] (идем с конца)
 * 2) Ищем максимальный индекс j для которого а[j] >= a[i] (Идем с конца
 * 3) Поменять местами a[j] и a[i]
 * 4) Записываем элементы от a[i+1]..a[n] в обратном
 *
 * Алгоритм отработает для генерации перестановок с повторениями
 * */
class PermutationIterativeImpl : Permutation {
    override fun generatePermute(nums: IntArray) : List<List<Int>> {
        val ans: MutableList<List<Int>> = mutableListOf()
        ans.add(nums.toList())
        while (true) {
            // начинаем с предпоследнего элемента
            var i = nums.size - 2
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--
            }
            if (i < 0) {
                break
            }
            // начинаем с последнего элемента
            var k = nums.size - 1
            while (k >= 0 && nums[i] >= nums[k]) {
                k--
            }
            swap(nums, i, k)
            reversed(nums, i + 1, nums.size - 1)
            ans.add(nums.toList())
        }
        return ans
    }

    /**
     * Утилитарная функция для того, чтобы поменять элементы местами
     * */
    private fun swap(array: IntArray, start: Int, end: Int) {
        val tmp = array[start]
        array[start] = array[end]
        array[end] = tmp
    }

    /**
     * Развернуть элементы массива в обратно порядке с указанных позиций
     * */
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