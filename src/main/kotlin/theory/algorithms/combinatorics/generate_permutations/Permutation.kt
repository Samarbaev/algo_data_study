package theory.algorithms.combinatorics.generate_permutations

interface Permutation {

    /***
     * @param nums - набор цифры, из которых необходимо составить все перестановки без повторений
     *
     * @return сгенерированные все перестановки
     */
    fun generatePermute(nums: IntArray) : List<List<Int>>

}