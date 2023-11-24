package practice.sliding_window.permutation_in_string

/***
 * Brute Force
 *
 * Самый простой метод - сгенерировать все перестановки короткой строки и проверить, является ли сгенерированная перестановка подстрокой длинной строки.
 * Для генерации всех возможных пар мы используем функцию permute(string_1, string_2, current_index). Эта функция создает все возможные перестановки короткой строки s1.
 * Для этого permute принимает индекс текущего элемента current_index в качестве одного из аргументов. Затем он меняет текущий элемент с каждым другим элементом в массиве, находящимся справа от него, чтобы сгенерировать новый порядок элементов массива.
 * После выполнения обмена, он снова вызывает permute, на этот раз с индексом следующего элемента в массиве. При возвращении мы отменяем обмен, выполненный в текущем вызове функции.
 * Таким образом, когда мы достигаем конца массива, генерируется новый порядок элементов массива. Следующая анимация показывает процесс генерации перестановок.
 *
 * The simplest method is to generate all the permutations of the short string and to check if the generated permutation is a substring of the longer string.
 * In order to generate all the possible permutations, we make use of a function permute(string_1, string_2, current_index). This function creates all the possible permutations of the short string s1.
 * To do so, permute takes the index of the current element current_index as one of the arguments. Then, it swaps the current element with every other element in the array, lying towards its right, so as to generate a new ordering of the array elements.
 * After the swapping has been done, it makes another call to permute, but this time with the index of the next element in the array. While returning back, we reverse the swapping done in the current function call.
 * Thus, when we reach the end of the array, a new ordering of the array's elements is generated. The following animation depicts the process of generating the permutations.
 *
 * Time complexity: 0(n!)
 * Space complexity: 0(n*n)
 */
class PermutationInStringSolutionBruteForce : PermutationInString {

    private var flag = false

    override fun checkInclusion(s1: String, s2: String): Boolean {
        permute(s1, s2, 0)
        return flag
    }

    private fun swap(s: String, i0: Int, i1: Int): String {
        if (i0 == i1) return s
        return s.substring(0, i0) + s[i1] + s.substring(i0 + 1, i1) + s[i0] + s.substring(i1 + 1)
    }

    private fun permute(s1: String, s2: String, l: Int) {
        var mutableString = s1
        if (l == mutableString.length) {
            if (s2.indexOf(mutableString) >= 0) flag = true
        } else {
            for (i in l until mutableString.length) {
                mutableString = swap(mutableString, l, i)
                permute(mutableString, s2, l + 1)
                mutableString = swap(mutableString, l, i)
            }
        }
    }
}