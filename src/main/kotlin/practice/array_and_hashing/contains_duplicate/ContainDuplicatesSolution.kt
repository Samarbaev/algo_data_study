package practice.array_and_hashing.contains_duplicate

/**
 * Создаем mutableMapOf<Int, Int> и добавляем в нее значения из nums
 * Перед добавлением делаем проверку, если ключ существует - возвращаем true
 *
 * Create a mutableMapOf<Int, Int> and add numbers to it
 * Before adding, we check, if the key exists, we return true
 * */
class ContainDuplicatesSolution : ContainDuplicates {
    override fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            if(map.containsKey(nums[i])){
                return true
            }
            map[nums[i]] = i
        }
        return false
    }
}