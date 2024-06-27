package leetcode.hashmap

// Разобраться с задачами и вынести их в отдельные пакеты
//import java.util.*
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//    val n = scanner.nextInt()
//    val documents = ArrayList<HashSet<String>>()
//    documents.add(HashSet())
//    for (i in 0 until n) {
//        val words = HashSet<String>()
//        repeat(scanner.nextInt()) {
//            words.add(scanner.next())
//        }
//        documents.add(words)
//    }
//
//    val searchIndex = buildFullIndex(documents)
//
//    val m = scanner.nextInt()
//    for (i in 0 until m) {
//        val query = scanner.nextLine().trim()
//        val result = freeTextQuery(searchIndex, query)
//        for (documentId in result) {
//            print("$documentId ")
//        }
//        println()
//    }
//}
//

//
//fun main() {
//    val size = readln().toInt()
//    val strs = readln().split(" ")
//    val result = mutableMapOf<String, MutableList<Int>>()
//    for (index in strs.indices) {
//        val key = IntArray(26)
//        for (char in strs[index]) {
//            key[char.code - 'a'.code]++
//        }
//        // Преобразуйте IntArray в строку
//        val keyStr = key.joinToString("@")
//
//        if (result.containsKey(keyStr)) {
//            result[keyStr]?.add(index)
//        } else {
//            result[keyStr] = mutableListOf(index)
//        }
//    }
//    result.values.toList().forEach { println(it.joinToString(" ")) }
//}
//
//fun groupAnagrams(strs: Array<String>) {
//    val result = mutableMapOf<String, MutableList<Int>>()
//    for (index in strs.indices) {
//        val key = IntArray(26)
//        for (char in strs[index]) {
//            key[char.code - 'a'.code]++
//        }
//        // Преобразуйте IntArray в строку
//        val keyStr = key.joinToString("@")
//
//        if (result.containsKey(keyStr)) {
//            result[keyStr]?.add(index)
//        } else {
//            result[keyStr] = mutableListOf(index)
//        }
//    }
//    result.values.toList().forEach { println(it.joinToString(" ")) }
//}
//
////fun threeSum(nums: IntArray): List<List<Int>> {
////    val result = mutableListOf<List<Int>>()
////    Arrays.sort(nums)
////    for (i in nums.indices) {
////        if ((i == 0 || nums[i] != nums[i - 1])) {
////            var start = i + 1
////            var end = nums.size - 1
////            while (start < end) {
////                val curSum = -nums[start] - nums[end]
////                if (curSum == nums[i]) {
////                    result.add(listOf(nums[i], nums[start], nums[end]))
////                    ++start
////                    --end
////                } else if (curSum > 0) {
////                    --end
////                } else {
////                    ++start
////                }
////            }
////        }
////    }
////    return result
////}
//
//fun threeSum(nums: IntArray): List<List<Int>> {
//    val result = mutableListOf<List<Int>>()
//    Arrays.sort(nums)
//    val seen = mutableSetOf<Int>()
//    for (i in nums.indices) {
//        if ((i == 0 || nums[i - 1] != nums[i])) {
//            for (j in (i + 1) until nums.size) {
//                val tmp = -nums[i] - nums[j]
//                if (seen.contains(tmp)) {
//                    result.add(listOf(nums[i], nums[j], tmp))
//                    var k = j
//                    while (k + 1 < nums.size && nums[j] == nums[j + 1]) ++k
//                }
//                seen.add(nums[j])
//            }
//        }
//    }
//    return result
//}
//
//internal class Solution {
//    fun threeSum(nums: IntArray): List<List<Int>> {
//        Arrays.sort(nums)
//        val res: MutableList<List<Int>> = ArrayList()
//        var i = 0
//        while (i < nums.size && nums[i] <= 0) {
//            if (i == 0 || nums[i - 1] != nums[i]) {
//                val seen = HashSet<Int>()
//                var j = i + 1
//                while (j < nums.size) {
//                    val complement = -nums[i] - nums[j]
//                    if (seen.contains(complement)) {
//                        res.add(listOf(nums[i], nums[j], complement))
//                        while (j + 1 < nums.size && nums[j] == nums[j + 1]) ++j
//                    }
//                    seen.add(nums[j])
//                    ++j
//                }
//            }
//            ++i
//        }
//        return res
//    }
//}
//
//class Solutions {
//
//    fun main() {
//        val size = readln()
//        val target = readln().toInt()
//        val nums = readln().split(" ").map { it.toInt() }
//        fourSum(nums.toIntArray(), target)
//    }
//
//    fun fourSum(nums: IntArray, target: Int) {
//        nums.sort()
//
//        val result: MutableList<List<Int>> = mutableListOf()
//
//        val target = target.toLong()
//
//        for (i in 0..nums.size - 2) {
//            if (i > 0 && nums[i - 1] == nums[i]) continue
//
//
//            for (j in i + 1 until nums.lastIndex - 1) {
//                var start = j + 1
//                var end = nums.lastIndex
//
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue
//                }
//
//                val outerSum: Long = (nums[i] + nums[j]).toLong()
//
//                while (start < end) {
//                    val currentSum: Long = nums[start] + nums[end] + outerSum
//
//                    if (currentSum == target) {
//                        result.add(listOf(nums[i], nums[j], nums[start++], nums[end--]))
//                        while (start < end && nums[start] == nums[start - 1]) start++
//                        while (start < end && nums[end] == nums[end + 1]) end--
//                    } else if (currentSum > target) {
//                        end--
//                    } else {
//                        start++
//                    }
//                }
//            }
//        }
//        println(result.size)
//        result.forEach { println(it.joinToString(" ")) }
//    }
//
//}