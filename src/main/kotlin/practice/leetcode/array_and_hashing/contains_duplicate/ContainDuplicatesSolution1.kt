package practice.leetcode.array_and_hashing.contains_duplicate

class ContainDuplicatesSolution1 : ContainDuplicates {
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