package leetcode.combinatorics.generate_combinations

interface Combination {

    /**
     * Функция для генерации всех сочетаний из n по k
     * */
    fun generateCombine(n: Int, k: Int) : List<List<Int>>

    /**
     * Функция генерации следующего сочетания в лексикографическом порядке
     * */
    fun nextCombine(curCombination: MutableList<Int>, n: Int, k: Int) : List<Int>?
}