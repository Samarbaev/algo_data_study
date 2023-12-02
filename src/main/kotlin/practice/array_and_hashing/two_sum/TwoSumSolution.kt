package practice.array_and_hashing.two_sum

/**
 * 1. Создаем Map<Int, Int>.
 * 2. Итерируем по nums и проверяем есть ли в map значение diff
 *   2.1 diff = k - nums[i], если есть возвращаем массив intArrayOf(map.getOrDefault(nums[i], -1), i)
 *   2.2 добавляем  map[nums[i]] = i

 * 3. Если таких значений не нашлось возвращаем intArrayOf(-1, -1)
 * */
class TwoSumSolution : TwoSum {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (map.containsKey(diff)) {
                return intArrayOf(map.getOrDefault(diff, -1), i)
            }
            map[nums[i]] = i
        }
        return intArrayOf(-1, -1)
    }
}