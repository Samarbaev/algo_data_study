package basic_theory.algorithms.combinatorics.generate_combinations

interface Combination {

    /**
     * Функция для генерации всех сочетаний из n по k
     * */
    fun combine(n: Int, k: Int) : List<List<Int>>
}