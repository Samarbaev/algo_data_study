package practice.leetcode.array_and_hashing.group_anagrams

class GroupAnagramsSolutionMap : GroupAnagrams {

    override fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = hashMapOf<String, MutableList<String>>()

        for (i in strs.indices) {
            val sortingWordByChar = String(strs[i].toCharArray().sortedArray())

            if (!map.containsKey(sortingWordByChar)){
                map[sortingWordByChar] = mutableListOf()
            }

            map[sortingWordByChar]?.add(strs[i])
        }
        return map.values.toList()
    }
}